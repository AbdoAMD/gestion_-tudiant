package com.example.gestionetudiant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {

    public static Databasehelper instance;

     public static  synchronized Databasehelper getInstance( Context context){
       if (instance==null){
           instance=new Databasehelper(context);
       }
        return instance;
    }
    public Databasehelper ( @Nullable Context context ) {
        super(context, "etudiant", null, 1);

    }

    @Override
    public void onCreate ( SQLiteDatabase db ) {
        db.execSQL("CREATE TABLE  etudiant ("+
                "ID INTEGER PRIMARY KEY,"+
                "Nom  TEXT,"+
                "Prenom TEXT,"+
                "NoteAndroid INTEGER,"+
                "NoteJava INTEGER,"+
                "NoteArduino INTEGER,"+
                "NoteTestValidation INTEGER,"+
                "NoteCircuit INTEGER,"+
                "NoteAutomate INTEGER)");

    }


    @Override
    public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("DROP TABLE IF EXISTS etudiant ");
        onCreate(db);
    }
}
