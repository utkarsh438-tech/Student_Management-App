package com.Springconcept.Learning.Controller;



import com.Springconcept.Learning.Model.User;
import com.Springconcept.Learning.Service.Imp.userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final userservice userService;

    public UserController(userservice userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // READ - all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // READ - by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // READ - by name
    @GetMapping("/search/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }


}
