package com.Springconcept.Learning.Confiq;

import com.Springconcept.Learning.Model.Users;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Datainitial {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Datainitial(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner loadSampleData() {
        return args -> {
            if (!userRepo.existsByUsername("Admin")) {
                Users user = new Users();
                user.setUsername("Admin");
                user.setPassword(passwordEncoder.encode("admin")); // encode password
                user.setState(true);
                userRepo.save(user);
            }
        };
    }
}
