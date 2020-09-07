package com.example.gradeBook.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String studentName;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Courses> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Grades> grades;

    public Student() {
    }

    public Student(Long id, String studentName, List<Courses> courses, List<Grades> grades) {
        this.id = id;
        this.studentName = studentName;
        this.courses = courses;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
