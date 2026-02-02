package com.Springconcept.Learning.Confiq;

import com.Springconcept.Learning.Model.Users;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Datainitial {

    CommandLineRunner LoadSampleData(UserRepo userRepo) {

        return (args) -> {
            if(!userRepo.existbyUsername("Admin")){
                Users user=new Users();
                user.setName("Admin");
                user.setPassword("admin");
                user.setState(true);
                userRepo.save(user);
            }
        };
    };
}
