package com.example.gestionetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Liste extends AppCompatActivity {
    ListView lv;
    private List<Etudiant> etudiants=new ArrayList<>() ;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        lv=findViewById(R.id.lv);
        SQLiteDatabase db= Databasehelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM etudiant",null);
        while(cursor.moveToNext()){
            Etudiant etudiant =new Etudiant();
            etudiant.setID(cursor.getInt(0));
            etudiant.setNom(cursor.getString(1));
            etudiant.setPrenom(cursor.getString(2));
            etudiant.setNoteAndroid(cursor.getInt(3));
            etudiant.setNoteJava(cursor.getInt(4));
            etudiant.setNoteArduino(cursor.getInt(5));
            etudiant.setNoteTestValidation(cursor.getInt(6));
            etudiant.setNoteCircuit(cursor.getInt(7));
            etudiant.setNoteAutomate(cursor.getInt(8));

            etudiants.add(etudiant);

        }
        ArrayAdapter<Etudiant> adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.etudiant_item,
                R.id.item,etudiants );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick ( AdapterView<?> parent, View view, int position, long id ) {
                Intent intent =new Intent(getApplicationContext(), InfoNotes.class);
                intent.putExtra("Data", (Serializable) etudiants.get(position));
                startActivity(intent);



            }
        });

    }

}