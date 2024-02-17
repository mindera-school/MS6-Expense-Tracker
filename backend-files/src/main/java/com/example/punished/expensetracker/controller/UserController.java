package com.example.punished.expensetracker.controller;

import com.example.punished.expensetracker.entity.User;
import com.example.punished.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
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
    public User getUserById(@PathVariable final Long userId) {
        return service.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable final Long userId) {
        service.deleteUser(userId);
    }
}
