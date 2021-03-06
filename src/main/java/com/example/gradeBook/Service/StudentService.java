package com.example.gradeBook.Service;

import com.example.gradeBook.Commons.ApiResponse;
import com.example.gradeBook.Commons.Status;
import com.example.gradeBook.Dto.ProfileDTO;
import com.example.gradeBook.Dto.StudentDTO;
import com.example.gradeBook.Model.Grades;
import com.example.gradeBook.Model.Student;
import com.example.gradeBook.Model.StudentGrade;
import com.example.gradeBook.Model.User;
import com.example.gradeBook.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private UserDao userDao;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    StudentGradeRepository studentGradeRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    GradesRepository gradesRepository;






    public ApiResponse addStudent( StudentDTO studentDTO){
        Student foundstudent=studentRepository.findBystudentEmail(studentDTO.getStudentEmail());
        User founduser=userDao.findByEmail(studentDTO.getStudentEmail());
        if(foundstudent==null && founduser==null ) {
            Student student = new Student();
            student.setStudentName(studentDTO.getStudentName());
            student.setPassword(studentDTO.getStudentPassword());
            student.setStudentEmail(studentDTO.getStudentEmail());
            student.setStatus("Active");

            studentRepository.save(student);


            User user = new User();
            user.setName(studentDTO.getStudentName());
            user.setPassword(bcryptEncoder.encode(studentDTO.getStudentPassword()));
            user.setEmail(studentDTO.getStudentEmail());
            user.setClientId(1l);
            user.setActive(true);
            user.setUserType("student");
            userDao.save(user);
            try {
                mailToUser(studentDTO.getStudentEmail(),studentDTO.getStudentEmail(),studentDTO.getStudentPassword());

                return new ApiResponse(200,"SUCCESSFULLY SAVED",student);
            }catch (Exception e){
                return new ApiResponse(200,"SUCCESSFULLY SAVED BUT SOME ERROR OCCURED IN SENDING MAIL ",student);
            }


        }
        else{
            return new ApiResponse(409,"ALREADY EXSIST",foundstudent);
        }

    }
    public List<Student> getAllStudents(){
       List<Student> students= studentRepository.findAll();
       return students;

    }

    public ApiResponse getStudentByID(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return new ApiResponse(Status.Status_Ok,"Successfully Get",student.get());
        }
        else{
            return new ApiResponse(Status.Status_ERROR,"Not present", null);
        }
    }



    public ApiResponse updateStudent( Long id ,  StudentDTO studentDTO){
        Student student=studentRepository.getOne(id);
        User user=userDao.findByEmail(student.getStudentEmail());
        if(student==null&&user==null){
            return new ApiResponse(404,"not found",student);
        }
        else {
            student.setId(student.getId());
            student.setStatus("Active");
            student.setStudentEmail(studentDTO.getStudentEmail());
            student.setStudentName(studentDTO.getStudentName());
            student.setPassword((studentDTO.getStudentPassword()));
            studentRepository.save(student);
            user.setEmail(studentDTO.getStudentEmail());
            user.setName(studentDTO.getStudentName());
            user.setPassword((bcryptEncoder.encode( studentDTO.getStudentPassword())));
            userDao.save(user);
            try {
                mailToUser(studentDTO.getStudentEmail(),studentDTO.getStudentEmail(),studentDTO.getStudentPassword());
                return new ApiResponse(200, "succesfully updated");
            }catch (Exception e){
                return new ApiResponse(200, " succesfully updated but error in sending email please try again");
            }







        }
    }

    public ApiResponse deleteStudent(Long id){
        Student student=studentRepository.getOne(id);
        User deleteuser=userDao.findByEmail(student.getStudentEmail());
//        User user=userDao.findByEmail(student.getStudentEmail());
        if(student==null&&deleteuser==null){
            return new ApiResponse(404,"unsucessfull! student  cannot be deleted ",student);
        }
        else {
            studentRepository.delete(student);
            userDao.delete(deleteuser);
            return new ApiResponse(200,"sucessfully deleted");

        }


    }
    void mailToUser(String recevierEmail,String username,String passowrd) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recevierEmail);

        msg.setSubject("UserName and Password");
        msg.setText("Your UserName is:"+username+" "+" Your Password is:"+passowrd);

        javaMailSender.send(msg);

    }

    public ApiResponse getGradeBookData(String email) {
        ProfileDTO profileDTO = new ProfileDTO();
            Double weight=0.0;
            Double obtainedMarks=0.0;
        Student std=studentRepository.findBystudentEmail(email);
         for(StudentGrade grade :std.getStudentGrades())
         {
           weight+=  grade.getCourses().getCourseWeight();
         }
        for(Grades grade :std.getGrades())
        {
            obtainedMarks+=  grade.getCourseMarks();
        }
        profileDTO.setCourseWeight((weight));
        profileDTO.setObtainedMarks((obtainedMarks));
        profileDTO.setEmail(std.getStudentEmail());
        profileDTO.setStudent_name(std.getStudentName());
        return new ApiResponse(Status.Status_Ok,"Fetched Sucessfully",profileDTO);


    }
}
