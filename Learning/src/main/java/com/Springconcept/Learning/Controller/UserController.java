package com.Springconcept.Learning.Controller;



import com.Springconcept.Learning.Model.Users;
import com.Springconcept.Learning.Service.Imp.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
//    @Autowired
//    private final userservice userService;
//
//    public UserController(userservice userService) {
//        this.userService = userService;
//    }

    // CREATE
    /*@PostMapping
    public Users addUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    // READ - all users
    @GetMapping
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    // READ - by ID
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // READ - by name
    @GetMapping("/search/{name}")
    public Users getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }
*/

}
