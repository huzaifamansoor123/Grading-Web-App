package com.example.gradeBook.Repository;

import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Model.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade,Long>{
    @Query(value = "select * from student_grade sg where sg.student_id=:stdId and sg.courses_id=:course_id ",nativeQuery = true)
    List<StudentGrade> findByStudentId(@Param("stdId") Long stdId,@Param("course_id") Long course_id);

}