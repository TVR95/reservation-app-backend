package com.demo.reservationapp.controller;

import com.demo.reservationapp.exception.UserNotFoundException;
import com.demo.reservationapp.model.User;
import com.demo.reservationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get all users
    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new user
    @PostMapping(path = "/users")
    public User createUser(@RequestParam User user) {
        return userRepository.save(user);
    }

    // Get a single user
    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable(value="id") Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    // Update an user
    @PutMapping(path = "/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        user.setUsername(userDetails.getUsername());

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    // Delete an user
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
