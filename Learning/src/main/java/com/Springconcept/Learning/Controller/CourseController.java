package com.Springconcept.Learning.Controller;

//import ch.qos.logback.core.model.Model;

import com.Springconcept.Learning.Dto.CourseDTO;
import com.Springconcept.Learning.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping("")
    public String coursePage(Model model) {
        return "courses";
    }

    @GetMapping("/new")
    public String ShowCreatedCourse(Model model) {
        model.addAttribute("courseDto", new CourseDTO());
        return "add-course";
    }

    @GetMapping("/List")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";  }


        @PostMapping("")
        public String createCourse(@Valid @ModelAttribute("courseDto") CourseDTO courseDTO, BindingResult
        bindingResult, Model model, RedirectAttributes redirectAttributes ){
//    return "CreateCourse";
            if (bindingResult.hasErrors()) {
                return "add-course";
            }
            if (courseService.existsByCourseCode(courseDTO.getCourseCode())) {
                bindingResult.rejectValue("courseCode", "error.courseCode.exist", "course code exist");
                return "add-course";
            }
            courseService.createCourse(courseDTO);
            redirectAttributes.addFlashAttribute("message", "Course created successfully");

            return "redirect:/course/List";
        }

    }
