package com.example.gradeBook.Repository;

import com.example.gradeBook.Model.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade,Long>{
}