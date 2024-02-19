package com.example.punished.expensetracker.service;


import com.example.punished.expensetracker.entity.*;
import com.example.punished.expensetracker.repository.*;
import com.example.punished.expensetracker.exceptions.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

        private final UserRepository repository;
        public List<User> getUsers() {
            return repository.findAll().stream().toList();
        }

        public User addUser(User user) {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new InvalidRequestException("Username, password cannot be empty");
            }
            repository.save(user);
            return User.builder()
                    .username(user.getUsername())
                    .build();
        }

        public User getUserById(final int userId) {
            User userAux = repository.getReferenceById(userId);
            return User.builder()
                    .username(userAux.getUsername())
                    .build();
        }
        public void deleteUser(final int userId) {
            User user = repository.getReferenceById(userId);
            repository.deleteById(user.getId());
        }

}
