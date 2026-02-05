package com.Springconcept.Learning.Repository;

import com.Springconcept.Learning.Model.Users;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends Neo4jRepository<Users, UUID> {
    Users findByName(String name);
boolean existbyUsername(String username);

    Optional<Users> findByUsername(String name);
}

