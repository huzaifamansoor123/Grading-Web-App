package com.example.gradeBook.Repository;

import com.example.gradeBook.Model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades,Long> {
}
