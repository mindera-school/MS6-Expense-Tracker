package com.example.punished.expensetracker.controller;


import com.example.punished.expensetracker.entity.*;
import com.example.punished.expensetracker.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addUser(user)).getBody();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable final int userId) {
        return service.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable final int userId) {
        service.deleteUser(userId);
    }
}
