package com.example.gradeBook.Repository;


import com.example.gradeBook.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {

    @Query(value = "select * from courses",nativeQuery = true)
    List<Courses> getAll();
}
