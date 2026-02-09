package com.Springconcept.Learning.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CourseDTO {

    private Long id;

    private String courseName;


    private String courseCode;
    private String duration;
    private boolean active = true;
    private BigDecimal fee;

    private String description;


    private LocalDateTime creationDate;
}

