package com.example.gradeBook.Controller;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Dto.GradesDTO;
import com.example.gradeBook.Dto.StudentDTO;
import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin
public class GradesController {

    @Autowired
    GradesService gradesService;

    @PostMapping("/add")
    public ApiResponse addWeight(@RequestBody GradesDTO gradesDTO){
        return this.gradesService.addWeight(gradesDTO);
    }

    @GetMapping("/getAll")
    public List<Grades> getAllWeights(){
        return this.gradesService.getAllWeights();
    }

    @GetMapping("{id}")
    public ApiResponse getGradeByID(@PathVariable("id") Long id){
        return this.gradesService.getGradeByID(id);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateWeight(@PathVariable("id") Long id ,@RequestBody GradesDTO gradesDTO){
        return this.gradesService.updateWeight(id,gradesDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteWeight(@PathVariable("id") Long id){
        return this.gradesService.deleteWeight(id);
    }

}
