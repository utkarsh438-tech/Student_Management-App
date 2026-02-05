package com.Springconcept.Learning.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String courseName;
    private String courseCode;
    private int duration;
}
