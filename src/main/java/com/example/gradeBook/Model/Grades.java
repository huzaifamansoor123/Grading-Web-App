package com.example.gradeBook.Model;

import javax.persistence.*;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    double courseMarks;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    Courses course;

    public Grades(Long id, double courseMarks, Student student, Courses course,String status) {
        this.id = id;
        this.courseMarks = courseMarks;
        this.student = student;
        this.course = course;
        this.status=status;
    }

    public Grades() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCourseMarks() {
        return courseMarks;
    }

    public void setCourseMarks(double courseMarks) {
        this.courseMarks = courseMarks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}
