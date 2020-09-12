package com.example.gradeBook;

import com.example.gradeBook.Model.User;
import com.example.gradeBook.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

//    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserDao repository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new User("teacher@teacher.com","imran khan",bcryptEncoder.encode("111"),true,"teacher",1L));

    }
}