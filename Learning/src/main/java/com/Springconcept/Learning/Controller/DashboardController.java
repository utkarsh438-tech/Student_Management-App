package com.Springconcept.Learning.Controller;


import com.Springconcept.Learning.Model.Users;
import com.Springconcept.Learning.Repository.CourseRepo;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DashboardController {
    private final UserRepo userRepo;
    private final CourseRepo courseRepo;

    public DashboardController(UserRepo userRepo, CourseRepo courseRepo) {
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/dashboard")

    public String dashboard(Model model) {
        model.addAttribute("totalStudents", userRepo.count());
        model.addAttribute("totalCourses", courseRepo.count());
        model.addAttribute("topCourseCode", "CS101");
        model.addAttribute("thisMonthEnrollments", 37);
        model.addAttribute("recentRegistrations", null);
        return "dashboard";
    }
}
