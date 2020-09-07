package com.example.gradeBook.Dto;

import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Model.Student;

import java.util.List;

public class CoursesDTO {
    String courseName;

    Double courseWeight;

    Student student;

    List<Grades> grades;

    public CoursesDTO(String courseName, Double courseWeight, Student student, List<Grades> grades) {
        this.courseName = courseName;
        this.courseWeight = courseWeight;
        this.student = student;
        this.grades = grades;
    }

    public CoursesDTO() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(Double courseWeight) {
        this.courseWeight = courseWeight;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
