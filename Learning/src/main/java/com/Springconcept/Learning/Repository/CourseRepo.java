package com.Springconcept.Learning.Repository;

import com.Springconcept.Learning.Model.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface CourseRepo extends Neo4jRepository<Course, UUID> {

boolean existsByCourseCodeIgnoreCase(String code);
boolean existsByCourseCodeIgnoreCaseAndIdNot(String code,UUID id);

}
