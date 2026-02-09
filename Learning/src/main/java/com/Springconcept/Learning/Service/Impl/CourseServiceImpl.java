package com.Springconcept.Learning.Service.Impl;

import com.Springconcept.Learning.Dto.CourseDTO;
import com.Springconcept.Learning.Model.Course;
import com.Springconcept.Learning.Repository.CourseRepo;
import com.Springconcept.Learning.Service.CourseService;
import org.modelmapper.ModelMapper;

public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;
    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public CourseDTO CreateCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepo.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }
}
