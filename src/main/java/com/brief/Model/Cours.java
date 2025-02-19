
package com.brief.Model;


public class Cours {
    private int id;
    private String nom_cours;
    private String date_naissance;

    public Cours(int id, String nom_cours, String date_naissance) {
        this.id = id;
        this.nom_cours = nom_cours;
        this.date_naissance = date_naissance;
    }

    public Cours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_cours() {
        return nom_cours;
    }

    public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
}
