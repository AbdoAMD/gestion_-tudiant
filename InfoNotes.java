package com.example.gestionetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoNotes extends AppCompatActivity {
    private TextView tvID,tvNom,tvPrenom,tvNAnd,tvNJava,tvNArd,tvNTV,tvNC,tvNAUT;
    Etudiant etudiant;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_notes);
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
}