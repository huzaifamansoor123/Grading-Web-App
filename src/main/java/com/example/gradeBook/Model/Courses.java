package com.example.gradeBook.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String courseName;

    Double courseWeight;

    boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "courses")
    List<StudentGrade> studentGrades ;


    @JsonIgnore
    @OneToMany(mappedBy = "course")
    List<Grades> grades;

    public Courses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Courses(String courseName, Double courseWeight, boolean active, List<StudentGrade> studentGrades, List<Grades> grades) {
        this.courseName = courseName;
        this.courseWeight = courseWeight;
        this.active = active;
        this.studentGrades = studentGrades;
        this.grades = grades;
    }
}
