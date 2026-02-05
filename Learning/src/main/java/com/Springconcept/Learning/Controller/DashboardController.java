package com.Springconcept.Learning.Controller;

import com.Springconcept.Learning.Model.Users;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(){
        Users[] users = new Users[1];
        return "Welcome to Dashboard " +users[0].getName();
    }
}
