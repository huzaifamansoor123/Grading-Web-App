package com.example.gradeBook.Dto;

import com.example.gradeBook.Model.Courses;
import com.example.gradeBook.Model.Student;

public class GradesDTO {

    double courseMarks;
    Student student;
    Courses course;

    public GradesDTO(double courseMarks, Student student, Courses course) {
        this.courseMarks = courseMarks;
        this.student = student;
        this.course = course;
    }

    public GradesDTO() {
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
