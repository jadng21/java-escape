package com.example.javaescape;

public class Dialogue {
    private String personnage;
    private String texte;
    private String imagePath;

    public Dialogue ( String personnage, String texte, String imagePath) {
        this.personnage = personnage;
        this.texte = texte;
        this.imagePath = imagePath;
    }

    public String getPersonnage() {
        return personnage;
    }

    public String getTexte() {
        return texte;
    }


    public String getImagePath() {
        return imagePath;
    }
}