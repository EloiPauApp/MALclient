package com.example.malclient.grid_model;

import android.graphics.drawable.Drawable;

public class Anime {
    private String nom;
    private String tag;
    private String imatge;

    public Drawable getImatge() {
        return Drawable.createFromPath(imatge);
    }

    public void setImatge(String image) {
        this.imatge = image;
    }

    public String getName() {
        return nom;
    }

    public void setName(String name) {
        this.nom = nom;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
