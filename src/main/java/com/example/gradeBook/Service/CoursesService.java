package com.example.gradeBook.Service;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Commons.Status;
import com.example.gradeBook.Dto.CoursesDTO;
import com.example.gradeBook.Model.Courses;
import com.example.gradeBook.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public ApiResponse addCourses(CoursesDTO coursesDTO){
        Courses courses = new Courses();
        courses.setCourseName(coursesDTO.getCourseName());
        courses.setCourseWeight(coursesDTO.getCourseWeight());

        coursesRepository.save(courses);

        return new ApiResponse(Status.Status_Ok,"Sucessfully Added",courses);
    }

    public ApiResponse getAllCourses(){
        List<Courses> coursesList= coursesRepository.getAll();
        return new ApiResponse(Status.Status_Ok,"Sucessfully get", coursesList);
    }

    public ApiResponse getCoursesById(Long id){
        Optional<Courses> course = coursesRepository.findById(id);
                if(course.isPresent()){
                    return new ApiResponse(Status.Status_Ok,"Successfully get by Id", course.get());
                }
        else{
                    return new ApiResponse(Status.Status_ERROR,"Not present", null);
                }
    }

    public ApiResponse deleteById(Long id){
        Optional<Courses> courses= coursesRepository.findById(id);
        if(courses.isPresent()){
            courses.get().setActive(false);
            coursesRepository.save(courses.get());
            return new ApiResponse(Status.Status_Ok,"Successfully Deleted", getAllCourses());
        }
        else{
            return new ApiResponse(Status.Status_ERROR,"Not Present", getAllCourses());
        }
    }

    public ApiResponse updateCourse(Long id, CoursesDTO coursesDTO){
        Optional<Courses> findcourse = coursesRepository.findById(id);
        Courses courses = findcourse.get();

        courses.setCourseName(coursesDTO.getCourseName());
        courses.setCourseWeight(coursesDTO.getCourseWeight());

        return new ApiResponse(Status.Status_Ok,"Successfully Updated", courses);
    }
}
