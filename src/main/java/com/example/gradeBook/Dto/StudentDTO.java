package com.example.gradeBook.Dto;

import com.example.gradeBook.Model.Courses;
import com.example.gradeBook.Model.Grades;

import java.util.List;

public class StudentDTO {
    String studentName;
    String studentPassword;
    String studentEmail;
    List<Courses> courses;
    List<Grades> grades;
    String status;

    public StudentDTO(String studentName, String studentPassword, String studentEmail, List<Courses> courses, List<Grades> grades, String status) {
        this.studentName = studentName;
        this.studentPassword = studentPassword;
        this.studentEmail = studentEmail;
        this.courses = courses;
        this.grades = grades;
        this.status = status;
    }

    public StudentDTO() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
