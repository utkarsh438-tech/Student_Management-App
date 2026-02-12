package com.Springconcept.Learning.Service;

import com.Springconcept.Learning.Dto.CourseDTO;
import com.Springconcept.Learning.Model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    boolean existsByCourseCode(String code);

    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(UUID id);
    CourseDTO updateCourse(CourseDTO courseDTO, UUID id);
    Boolean existsByCourseCodeAndIdNot(String code, UUID id);
}
