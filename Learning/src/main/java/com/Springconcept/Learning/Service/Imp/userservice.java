package com.Springconcept.Learning.Service.Imp;

import com.Springconcept.Learning.Model.User;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class userservice {
    private final UserRepo userRepo;

    public userservice(UserRepo userRepo) {
        this.userRepo = userRepo;
    } // CREATE
public User createUser(User user) {
        return userRepo.save(user);
    } // READ - all users
 public List<User> getAllUsers() {
        return userRepo.findAll();
    } // READ - by ID
 public Optional<User> getUserById(Long id) {
        return userRepo.findById(id); }
// READ - by name
public User getUserByName(String name) {
        return userRepo.findByName(name);
    } // UPDATE
 public User updateUser(Long id, User updatedUser) {
        return userRepo.findById(id) .map(user -> {
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            user.setState(updatedUser.isState());
            return userRepo.save(user); }) .orElseThrow(() -> new RuntimeException("User not found"));
 } }