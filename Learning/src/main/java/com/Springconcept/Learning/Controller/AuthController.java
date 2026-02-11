package com.Springconcept.Learning.Controller;

import com.Springconcept.Learning.Model.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String loginPage() {
        return "login";

    }
//    @GetMapping("/dashboard")
//    public String dashboard(){
////        Users[] users = new Users[1];
//        return "Welcome to Dashboard "  ;
//    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, Authentication authentication){
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request, response,authentication);
        }
        return " Successfully logged out!";

    }
}
