package com.example.gestionetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;


public class AjouterEtudiant extends AppCompatActivity {
    private EditText etID,etNom,etPrenom,etNAnd,etNJava,etNArd,etNTV,etNC,etNAUT;
    boolean update=false;
    private  Etudiant etudiant;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_etudiant);
        etID=findViewById(R.id.etID);
        etNom=findViewById(R.id.etNom);
        etPrenom=findViewById(R.id.etPrenom);
        etNAnd=findViewById(R.id.etNAnd);
        etNJava=findViewById(R.id.etNJava);
        etNArd=findViewById(R.id.etNArd);
        etNTV=findViewById(R.id.etNTV);
        etNC=findViewById(R.id.etNC);
        etNAUT=findViewById(R.id.etNAUT);


        Intent intent=getIntent();
        etudiant= (Etudiant) intent.getSerializableExtra("Data");

        if(etudiant!=null){
            etNTV.setText(String.valueOf(etudiant.getNoteTestValidation()));
            etNC.setText(String.valueOf(etudiant.getNoteCircuit()));
            etNAUT.setText(String.valueOf(etudiant.getNoteAutomate()));
            etPrenom.setText(etudiant.getPrenom());
            etID.setText(String.valueOf(etudiant.getID()));
            etNom.setText(etudiant.getNom());
            etNAnd.setText(String.valueOf(etudiant.getNoteAndroid()));
            etNJava.setText(String.valueOf(etudiant.getNoteJava()));
            etNArd.setText(String.valueOf(etudiant.getNoteArduino()));

            update=true;
        }
    }
    public void bnEnresterEtud ( View view ) {
        SQLiteDatabase db = Databasehelper.getInstance(getApplicationContext()).getWritableDatabase();
        if(update){
            db.execSQL("UPDATE  etudiant set ID=?,Nom=?,Prenom=?,NoteAndroid=?,NoteJava=?,NoteArduino=?,NotetestValidation=?,NoteCircuit=?,NoteAutomate=? WHERE ID=?",
                    new String[]{
                            etID.getText().toString(),
                            etNom.getText().toString(),
                            etPrenom.getText().toString(),
                            etNAnd.getText().toString(),
                            etNJava.getText().toString(),
                            etNArd.getText().toString(),
                            etNTV.getText().toString(),
                            etNC.getText().toString(),
                            etNAUT.getText().toString(),
                            String.valueOf(etudiant.getID())
                    });
        }else {
            db.execSQL("INSERT INTO etudiant (ID,Nom,Prenom,NoteAndroid,NoteJava,NoteArduino,NotetestValidation,NoteCircuit,NoteAutomate) VALUES (?,?,?,?,?,?,?,?,?)",
                    new String[]{
                            etID.getText().toString(),
                            etNom.getText().toString(),
                            etPrenom.getText().toString(),
                            etNAnd.getText().toString(),
                            etNJava.getText().toString(),
                            etNArd.getText().toString(),
                            etNTV.getText().toString(),
                            etNC.getText().toString(),
                            etNAUT.getText().toString()
                    });
        }
        Intent intent = new Intent(this, ListeEtudiant.class);
        startActivity(intent);

    }
}