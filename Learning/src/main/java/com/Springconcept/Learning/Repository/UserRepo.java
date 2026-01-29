package com.Springconcept.Learning.Repository;

import com.Springconcept.Learning.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepo extends Neo4jRepository<User, Long> {
    User findByName(String name);}
