package com.brief.Model;

public class Cours {
    private int id;
    private String nom_cours;
    private String description;

    public Cours(int id, String nom_cours, String description) {
        this.id = id;
        this.nom_cours = nom_cours;
        this.description = description;
    }

    public Cours() {
    }

    public Cours(String nom_cours, String description) {
        this.nom_cours = nom_cours;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", nom_cours='" + nom_cours + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}