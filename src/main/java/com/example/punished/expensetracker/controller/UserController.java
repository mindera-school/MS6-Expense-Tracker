package com.example.punished.expensetracker.controller;

import com.example.punished.expensetracker.dto.UserDto;
import com.example.punished.expensetracker.entity.User;
import com.example.punished.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addUser(user)).getBody();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable final int userId) {
        return service.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable final int userId) {
        service.deleteUser(userId);
    }
}
