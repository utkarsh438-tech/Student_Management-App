package com.Springconcept.Learning.Service;

import com.Springconcept.Learning.Dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    boolean existsByCourseCode(String code);

    List<CourseDTO> getAllCourses();
}
