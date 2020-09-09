package com.example.gradeBook.Controller;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Dto.StudentDTO;
import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody StudentDTO studentDTO){
        return this.studentService.addStudent(studentDTO);
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return this.studentService.getAllStudents();

    }
    @PutMapping("/update/{id}")
    public ApiResponse updateStudent(@PathVariable("id") Long id ,@RequestBody StudentDTO studentDTO){
        return this.studentService.updateStudent(id,studentDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable("id") Long id){
        return this.studentService.deleteStudent(id);
    }

}
