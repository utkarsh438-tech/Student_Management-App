package com.Springconcept.Learning.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Indexed;
import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.stereotype.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Node("Course")
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String courseName;

    @NotBlank
//    @Indexed(unique = true) // intent; still create DB constraints in Neo4j
    private String courseCode;

    // Consider Duration if you plan to do time arithmetic; else String is fine
    private String duration;

    // Primitive boolean can’t be null; default true set via initializer
    private boolean active = true;

    @NotNull
    private BigDecimal fee;

    private String description;

    // Will be auto-populated if auditing is enabled (@EnableNeo4jAuditing)
    @CreatedDate
    private LocalDateTime creationDate;
}