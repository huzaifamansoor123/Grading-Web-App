package com.example.gradeBook.Service;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Dto.StudentDTO;
import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Model.User;
import com.example.gradeBook.Repository.StudentRepository;
import com.example.gradeBook.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private UserDao userDao;



    public ApiResponse addStudent( StudentDTO studentDTO){
        Student foundstudent=studentRepository.findBystudentEmail(studentDTO.getStudentEmail());
        User founduser=userDao.findByEmail(studentDTO.getStudentEmail());
        if(foundstudent==null && founduser==null ) {
            Student student = new Student();
            student.setStudentName(studentDTO.getStudentName());
            student.setPassword(studentDTO.getPassword());
            student.setStudentEmail(studentDTO.getStudentEmail());
            student.setStatus("Active");
            studentRepository.save(student);


            User user = new User();
            user.setName(studentDTO.getStudentName());
            user.setPassword(bcryptEncoder.encode(studentDTO.getPassword()));
            user.setEmail(studentDTO.getStudentEmail());
            user.setClientId(1l);
            user.setActive(true);
            user.setUserType("student");
            userDao.save(user);

            return new ApiResponse(200,"SUCCESSFULLY SAVED",student);

        }
        else{
            return new ApiResponse(409,"ALREADY EXSIST",foundstudent);
        }



    }
    public List<Student> getAllStudents(){
       List<Student> students= studentRepository.findAll();
       return students;

    }
    public ApiResponse updateStudent( Long id ,  StudentDTO studentDTO){
        Student student=studentRepository.getOne(id);
        if(student==null){
            return new ApiResponse(404,"not found",student);
        }
        else {
            student.setId(student.getId());
            student.setStatus("Active");
            student.setStudentEmail(studentDTO.getStudentEmail());
            student.setStudentName(studentDTO.getStudentName());
            student.setPassword(bcryptEncoder.encode(studentDTO.getPassword()));
            studentRepository.save(student);
            return new ApiResponse(200, "succesfully updated", student);

        }
    }

}
