package com.Springconcept.Learning.Confiq;

import com.Springconcept.Learning.Controller.UserController;
import com.Springconcept.Learning.Model.User;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Datainitial {

    CommandLineRunner LoadSampleData(UserRepo userRepo) {

        return (args) -> {
            if(!userRepo.existbyUsername("Admin")){
                User user=new User();
                user.setName("Admin");
                user.setPassword("admin");
                user.setState(true);
                userRepo.save(user);
            }
        };
    };
}
