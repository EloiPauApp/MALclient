package com.example.malclient.models;

public class Usuari {
    private String idUsuari;
    private String username;
    private String nom;
    private String cognoms;
    private String mail;
    private int edat;

    private Usuari(){

    }

    public Usuari(String idUsuari, String username, String nom, String cognoms, String mail, int edat) {
        this.idUsuari = idUsuari;
        this.username = username;
        this.nom = nom;
        this.cognoms = cognoms;
        this.mail = mail;
        this.edat = edat;
    }
}
