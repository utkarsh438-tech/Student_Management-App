package com.Springconcept.Learning.Repository;

import com.Springconcept.Learning.Model.Users;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends Neo4jRepository<Users, UUID> {
//    Users findByUsername(String username);
boolean existsByUsername(String username);

    Optional<Users> findByUsername(String name);


}

