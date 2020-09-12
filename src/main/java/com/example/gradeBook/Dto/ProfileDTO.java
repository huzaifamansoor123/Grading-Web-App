package com.example.gradeBook.Dto;

public class ProfileDTO {
    String student_name;
    String email;
    Double courseWeight;
    Double obtainedMarks;

    public ProfileDTO() {
    }

    public ProfileDTO(String student_name, String email, Double courseWeight, Double obtainedMarks) {
        this.student_name = student_name;
        this.email = email;
        this.courseWeight = courseWeight;
        this.obtainedMarks = obtainedMarks;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(Double courseWeight) {
        this.courseWeight = courseWeight;
    }

    public Double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
}