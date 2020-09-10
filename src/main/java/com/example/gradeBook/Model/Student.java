package com.example.gradeBook.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String studentPassword;

    String studentEmail;

    String studentName;
    String status;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<StudentGrade> studentGrades ;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Grades> grades;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student() {
    }

    public Student(String password, String studentEmail, String studentName, String status, List<StudentGrade> studentGrades, List<Grades> grades) {
        this.studentPassword = password;
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.status = status;
        this.studentGrades = studentGrades;
        this.grades = grades;
    }

    public String getPassword() {
        return studentPassword;
    }

    public void setPassword(String password) {
        this.studentPassword = password;
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

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
