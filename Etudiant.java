package com.example.gestionetudiant;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private  int ID ;
    private  String Nom;
    private  String Prenom;
    private  int NoteAndroid;
    private  int NoteJava;
    private  int NoteArduino;
    private  int NoteTestValidation;
    private  int NoteCircuit;
    private  int NoteAutomate;




    public Etudiant ( int ID, String nom, String prenom, int noteAndroid, int noteJava, int noteArduino, int noteTestValidation, int noteCircuit, int noteAutomate ) {
        this.ID = ID;
        this.Nom = nom;
        this.Prenom = prenom;
        this.NoteAndroid = noteAndroid;
        this.NoteJava = noteJava;
        this.NoteArduino = noteArduino;
        this.NoteTestValidation = noteTestValidation;
        this.NoteCircuit = noteCircuit;
        this.NoteAutomate = noteAutomate;
    }

    public Etudiant () {

    }

    public int getID () {
        return ID;
    }

    public void setID ( int ID ) {
        this.ID = ID;
    }

    public String getNom () {
        return Nom;
    }

    public void setNom ( String nom ) {
        Nom = nom;
    }

    public String getPrenom () {
        return Prenom;
    }

    public void setPrenom ( String prenom ) {
        Prenom = prenom;
    }

    public int getNoteAndroid () {
        return NoteAndroid;
    }

    public void setNoteAndroid ( int noteAndroid ) {
        NoteAndroid = noteAndroid;
    }

    public int getNoteJava () {
        return NoteJava;
    }

    public void setNoteJava ( int noteJava ) {
        NoteJava = noteJava;
    }

    public int getNoteArduino () {
        return NoteArduino;
    }

    public void setNoteArduino ( int noteArduino ) {
        NoteArduino = noteArduino;
    }

    public int getNoteTestValidation () {
        return NoteTestValidation;
    }

    public void setNoteTestValidation ( int noteTestValidation ) {
        NoteTestValidation = noteTestValidation;
    }

    public int getNoteCircuit () {
        return NoteCircuit;
    }

    public void setNoteCircuit ( int noteCircuit ) {
        NoteCircuit = noteCircuit;
    }

    public int getNoteAutomate () {
        return NoteAutomate;
    }

    public void setNoteAutomate ( int noteAutomate ) {
        NoteAutomate = noteAutomate;
    }

    @Override
    public String toString () {
        return
                 Nom  +
                "    '" + Prenom + '\''
                ;
    }
}
