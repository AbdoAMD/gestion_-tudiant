package com.example.gestionetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void bnAjouterEtud ( View view ) {
       //Databasehelper.getInstance(getApplicationContext()).getWritableDatabase();
        Intent intent = new Intent(this, AjouterEtudiant.class);
        startActivity(intent);
    }

    public void bnListEtud ( View view ) {
        Intent intent = new Intent(this, ListeEtudiant.class);
        startActivity(intent);

    }
}