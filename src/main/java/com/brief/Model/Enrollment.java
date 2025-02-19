package com.brief.Model;

public class Enrollment {
int student_id;
int course_id;
String date_inscription ;

    public Enrollment(int student_id, int course_id, String date_inscription) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.date_inscription = date_inscription;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(String date_inscription) {
        this.date_inscription = date_inscription;
    }
}
