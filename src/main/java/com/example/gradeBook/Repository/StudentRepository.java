package com.example.gradeBook.Repository;

import com.example.gradeBook.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Student findBystudentEmail(String email);
}
