package com.example.gradeBook.Service;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Commons.Status;
import com.example.gradeBook.Dto.GradesDTO;
import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Model.StudentGrade;
import com.example.gradeBook.Repository.GradesRepository;
import com.example.gradeBook.Repository.StudentGradeRepository;
import com.example.gradeBook.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    GradesRepository gradesRepository;
    @Autowired
    StudentGradeRepository studentGradeRepository;
    @Autowired
    StudentRepository studentRepository;


    public ApiResponse addWeight(GradesDTO gradesDTO){

        List<StudentGrade> sg = studentGradeRepository.findByStudentId(gradesDTO.getStudent().getId(), gradesDTO.getCourse().getId());
            if(sg.size()>0){
                return new ApiResponse(Status.Status_DUPLICATE,"Duplicate Course or Student",null);

            }

        Grades weight=new Grades();
        StudentGrade studentGrade = new StudentGrade();

        weight.setCourseMarks(gradesDTO.getCourseMarks());
        weight.setStudent(gradesDTO.getStudent());
        weight.setCourse(gradesDTO.getCourse());
        weight.setStatus("ACTIVE");
        studentGrade.setStudent(gradesDTO.getStudent());
        studentGrade.setCourses(gradesDTO.getCourse());
        gradesRepository.save(weight);
        studentGradeRepository.save(studentGrade);

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
        Grades weightTofound = gradesRepository.getOne(id);
        if(weightTofound==null){
            return new ApiResponse(404,"Not found ",weightTofound);

        }else {
            weightTofound.setCourse(gradesDTO.getCourse());
            weightTofound.setStudent(gradesDTO.getStudent());
            weightTofound.setCourseMarks(gradesDTO.getCourseMarks());
            gradesRepository.save(weightTofound);
            return new ApiResponse(200,"sucessfully updated");
        }

    }
    public ApiResponse deleteWeight(Long id){
        Grades weightTofound=gradesRepository.getOne(id);
        if(weightTofound==null){
            return new ApiResponse(404,"not found",weightTofound);
        }
        else {
            gradesRepository.delete(weightTofound);
            return new ApiResponse(200,"successfully deleted");
        }

    }
}
