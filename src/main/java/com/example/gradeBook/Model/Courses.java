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

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    Student student;


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

    public Courses(Long id, String courseName, Double courseWeight, Student student, List<Grades> grades) {
        this.id = id;
        this.courseName = courseName;
        this.courseWeight = courseWeight;
        this.student = student;
        this.grades = grades;
    }
}
