package com.Springconcept.Learning.Controller;

//import ch.qos.logback.core.model.Model;
import com.Springconcept.Learning.Dto.CourseDTO;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Course")
public class CourseController {
@GetMapping("/new")
    public String ShowCreatedCourse(Model model){
    model.addAttribute("courseDto",new CourseDTO());
        return "Course";
    }
    @GetMapping("/List")
    public String ListCourse(Model model){
//        model.addAttribute("courseDto",new CourseDTO());
        return "ListCourse";
    }
    @PostMapping("")
    public String CreateCourse(@Valid @ModelAttribute("courseDto") CourseDTO courseDTO){
    return "CreateCourse";
    }
}
