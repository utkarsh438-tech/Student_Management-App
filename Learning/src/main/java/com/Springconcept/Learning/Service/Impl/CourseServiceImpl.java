package com.Springconcept.Learning.Service.Impl;

import com.Springconcept.Learning.Dto.CourseDTO;
import com.Springconcept.Learning.Model.Course;
import com.Springconcept.Learning.Repository.CourseRepo;
import com.Springconcept.Learning.Service.CourseService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepo.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public boolean existsByCourseCode(String code) {
        return courseRepo.existsByCourseCodeIgnoreCase(code);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepo.
                findAll().
                stream().
                map(course -> modelMapper.map(course, CourseDTO.class)).
                collect(Collectors.toList());
    }

}
