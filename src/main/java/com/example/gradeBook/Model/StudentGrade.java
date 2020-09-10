package com.example.gradeBook.Model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentGrade implements Serializable {

//    String grades;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @ManyToOne
    @JoinColumn
    private Student student;


    @ManyToOne
    @JoinColumn
    private Courses courses;

    public StudentGrade() {
    }

    public StudentGrade(Student student, Courses courses) {
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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