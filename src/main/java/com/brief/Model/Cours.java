
package com.brief.Model;


public class Cours {
    private int id;
    private String nom_cours;
    private String descrption;

    public Cours(int id, String nom_cours, String descrption) {
        this.id = id;
        this.nom_cours = nom_cours;
        this.descrption = descrption;
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

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}