package com.example.gestionetudiant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoEtudiant extends AppCompatActivity {

    private  TextView tvID,tvNom,tvPrenom,tvNAnd,tvNJava,tvNArd,tvNTV,tvNC,tvNAUT;
    Etudiant etudiant;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_etudiant);

        Intent intent=getIntent();
        etudiant = (Etudiant)  intent.getSerializableExtra("Data");

        tvID=findViewById(R.id.tvID);
        tvNom=findViewById(R.id.tvNom);
        tvPrenom=findViewById(R.id.tvPrenom);
        tvNAnd=findViewById(R.id.tvNAnd);
        tvNJava=findViewById(R.id.tvNJava);
        tvNArd=findViewById(R.id.tvNArd);
        tvNTV=findViewById(R.id.tvNTV);
        tvNC=findViewById(R.id.tvNC);
        tvNAUT=findViewById(R.id.tvNAUT);


        tvNTV.setText(String.valueOf(etudiant.getNoteTestValidation()));
        tvNC.setText(String.valueOf(etudiant.getNoteCircuit()));
        tvNAUT.setText(String.valueOf(etudiant.getNoteAutomate()));
        tvPrenom.setText(etudiant.getPrenom());
        tvID.setText(String.valueOf(etudiant.getID()));
        tvNom.setText(etudiant.getNom());
        tvNAnd.setText(String.valueOf(etudiant.getNoteAndroid()));
        tvNJava.setText(String.valueOf(etudiant.getNoteJava()));
        tvNArd.setText(String.valueOf(etudiant.getNoteArduino()));


    }

    public void btnSupprimer ( View view ) {

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("Etre vous sur de vouloir supprimer ce produit").setTitle("Attention");
        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick ( DialogInterface dialog, int which ) {

            }
        });
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick ( DialogInterface dialog, int which ) {
                SQLiteDatabase db= Databasehelper.getInstance(getApplicationContext()).getWritableDatabase();
                db.execSQL("DELETE FROM etudiant WHERE ID=?",
                        new String[]{
                                String.valueOf(etudiant.getID())
                        });
                Intent intent =new Intent(getApplicationContext(),ListeEtudiant.class);
                startActivity(intent);

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();


    }

    public void btnModifier ( View view ) {
        Intent intent =new Intent(getApplicationContext(),AjouterEtudiant.class);
        intent.putExtra("Data",etudiant);
        startActivity(intent);
    }
}