package com.example.gradeBook.Dto;

import com.example.gradeBook.Model.Courses;
import com.example.gradeBook.Model.Grades;

import java.util.List;

public class StudentDTO {
    String studentName;
    List<Courses> courses;
    List<Grades> grades;

    public StudentDTO(String studentName, List<Courses> courses, List<Grades> grades) {
        this.studentName = studentName;
        this.courses = courses;
        this.grades = grades;
    }

    public StudentDTO() {
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
