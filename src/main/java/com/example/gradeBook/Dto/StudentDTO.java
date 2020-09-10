package com.example.gradeBook.Dto;

import com.example.gradeBook.Model.Courses;
import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Model.StudentGrade;

import java.util.List;

public class StudentDTO {
    String studentName;
    String password;
    String studentEmail;
    List<StudentGrade> studentGrades;
    List<Grades> grades;
    String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO(String studentName, String password, String studentEmail, List<StudentGrade> studentGrades, List<Grades> grades, String status) {
        this.studentName = studentName;
        this.password = password;
        this.studentEmail = studentEmail;
        this.studentGrades = studentGrades;
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
