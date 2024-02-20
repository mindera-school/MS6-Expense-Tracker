package com.example.punished.expensetracker.service;
import com.example.punished.expensetracker.entity.User;
import com.example.punished.expensetracker.exceptions.InvalidRequestException;
import com.example.punished.expensetracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            Optional<User> userAux = repository.findById(userId);
            return User.builder()
                    .username(userAux.get().getUsername())
                    .build();
        }
        public void deleteUser(final int userId) {
            if (repository.findById(userId).isEmpty()) {
                throw new InvalidRequestException("User not found");
            }
            repository.deleteById(userId);
        }

}
