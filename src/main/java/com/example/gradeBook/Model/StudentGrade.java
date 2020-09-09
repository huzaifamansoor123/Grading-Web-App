package com.example.gradeBook.Model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentGrade implements Serializable {

//    String grades;

    @Id
    @ManyToOne
    @JoinColumn
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn
    private Courses courses;

    public StudentGrade(Student student, Courses courses) {
//        this.grades = grades;
        this.student = student;
        this.courses = courses;
    }
//
//    public String getGrades() {
//        return grades;
//    }
//
//    public void setGrades(String grades) {
//        this.grades = grades;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}