package com.brief.Model;

import java.util.List;

public class Student {
    int id;
    String nom;
    String prenom;
    String email;
    String dateNaissance;
    private List<Cours> courses;

    public Student(String nom, String prenom, String email, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    public Student() {
    }
    public List<Cours> getCourses() {
        return courses;
    }

    public void setCourses(List<Cours> courses) {
        this.courses = courses;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
