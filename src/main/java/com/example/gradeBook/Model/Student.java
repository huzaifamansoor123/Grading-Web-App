package com.example.gradeBook.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String password;
    String studentEmail;

    String studentName;
    String status;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Courses> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Grades> grades;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student() {
    }

    public Student(Long id, String studentName, List<Courses> courses, List<Grades> grades, String password,String studentEmail) {
        this.id = id;
        this.studentName = studentName;
        this.courses = courses;
        this.grades = grades;
        this.password=password;
        this.studentEmail=studentEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
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
