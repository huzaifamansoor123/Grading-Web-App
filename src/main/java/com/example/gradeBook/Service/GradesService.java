package com.example.gradeBook.Service;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Commons.Status;
import com.example.gradeBook.Dto.GradesDTO;
import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    GradesRepository gradesRepository;

    public ApiResponse addWeight(GradesDTO gradesDTO){
        Grades weight=new Grades();
        weight.setCourseMarks(gradesDTO.getCourseMarks());
        weight.setStudent(gradesDTO.getStudent());
        weight.setCourse(gradesDTO.getCourse());
        weight.setStatus("ACTIVE");
        gradesRepository.save(weight);
        return new ApiResponse(200,"sucessfully saved",weight);

    }
    public List<Grades> getAllWeights(){
        List<Grades> weights= gradesRepository.findAll();
        return weights;

    }

    public ApiResponse getGradeByID(Long id){
        Optional<Grades> grades = gradesRepository.findById(id);
        if(grades.isPresent()){
            return new ApiResponse(Status.Status_Ok,"Successfully Get",grades.get());
        }
        else{
            return new ApiResponse(Status.Status_ERROR,"Not present", null);
        }
    }
    public ApiResponse updateWeight(Long id,GradesDTO gradesDTO){
        Grades weightTofound=gradesRepository.getOne(id);
        if(weightTofound==null){
            return new ApiResponse(404,"Not found ",weightTofound);

        }else {
            weightTofound.setCourse(gradesDTO.getCourse());
            weightTofound.setStudent(gradesDTO.getStudent());
            weightTofound.setCourseMarks(gradesDTO.getCourseMarks());
            gradesRepository.save(weightTofound);
            return new ApiResponse(200,"sucessfully updated",weightTofound);
        }

    }
    public ApiResponse deleteWeight(Long id){
        Grades weightTofound=gradesRepository.getOne(id);
        if(weightTofound==null){
            return new ApiResponse(404,"not found",weightTofound);
        }
        else {
            weightTofound.setStatus("INACTIVE");
            gradesRepository.save(weightTofound);
            return new ApiResponse(200,"successfully deleted",weightTofound);
        }

    }
}
