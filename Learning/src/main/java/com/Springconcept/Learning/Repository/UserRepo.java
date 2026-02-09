package com.Springconcept.Learning.Repository;

import com.Springconcept.Learning.Model.Users;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends Neo4jRepository<Users, UUID> {
    Users findByName(String name);
boolean existbyUsername(String username);

    Optional<Users> findByUsername(String name);

    @Service
    class userservice {
        private final UserRepo userRepo;

        public userservice(UserRepo userRepo) {
            this.userRepo = userRepo;
        } // CREATE

        public Users createUser(Users user) {
            return userRepo.save(user);
        } // READ - all users

        public List<Users> getAllUsers() {
            return userRepo.findAll();
        } // READ - by ID

        public Optional<Users> getUserById(UUID id) {
            return userRepo.findById(id);
        }

        // READ - by name
        public Users getUserByName(String name) {
    //        return userRepo.findByName(name);
            return null;
        } // UPDATE

        public Users updateUser(UUID id, Users updatedUser) {
            return userRepo.findById(id).map(user -> {
                user.setName(updatedUser.getName());
                user.setPassword(updatedUser.getPassword());
                user.setState(updatedUser.isState());
                return userRepo.save(user);
            }).orElseThrow(() -> new RuntimeException("User not found"));
     } }
}

