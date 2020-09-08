package com.example.gradeBook.Controller;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Dto.CoursesDTO;
import com.example.gradeBook.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @PostMapping("/")
    public ApiResponse addCourses(@RequestBody CoursesDTO coursesDTO){
        return coursesService.addCourses(coursesDTO);
    }

    @GetMapping("/")
    public ApiResponse getAllCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ApiResponse getCoursesById(@PathVariable("id") Long id){
        return coursesService.getCoursesById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable("id") Long id){
        return coursesService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse updateCourse(@PathVariable("id") Long id, @RequestBody CoursesDTO coursesDTO ){
        return coursesService.updateCourse(id,coursesDTO);
    }
}
