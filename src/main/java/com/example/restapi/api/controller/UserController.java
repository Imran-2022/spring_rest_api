package com.example.restapi.api.controller;

import com.example.restapi.api.model.User;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Read - Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    // Read - Get a specific user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Create - Add a new user
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
    }

    //    @GetMapping("/user")
//    public User getUser(@RequestParam Integer id){
//        Optional<User> user = userService.getUser(id);
//        if(user.isPresent()){
//            return (User) user.get();
//        }
//        return null;
//    }
// Update - Update an existing user
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
    Optional<User> existingUser = userService.getUser(id);
    if (existingUser.isPresent()) {
        User user = existingUser.get();
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }
    return ResponseEntity.notFound().build();
}

    // Delete - Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok("Deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
