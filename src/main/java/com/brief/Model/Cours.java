
package com.brief.Model;

import com.brief.Controller.AddStudent;

public class Cours {
    private int id;
    private AddStudent student;
    private Cours cours;

    public Cours(int id, AddStudent student, Cours cours) {
        this.id = id;
        this.student = student;
        this.cours = cours;
    }

    public Cours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddStudent getStudent() {
        return student;
    }

    public void setStudent(AddStudent student) {
        this.student = student;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
