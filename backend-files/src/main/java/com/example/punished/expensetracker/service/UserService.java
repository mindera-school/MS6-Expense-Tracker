package com.example.punished.expensetracker.service;
import com.example.punished.expensetracker.dto.UserDto;
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

        public UserDto addUser(UserDto user) {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new InvalidRequestException("Username, password cannot be empty");
            }
            repository.save(User.builder()
                    .username(user.getUsername())
                    .build());
            return user;
        }

        public UserDto getUserById(final int userId) {
            Optional<User> userAux = repository.findById(userId);
            return new UserDto(userAux.get().getUsername(),userAux.get().getPassword(),userAux.get().getEmail());
        }
        public void deleteUser(final int userId) {
            if (repository.findById(userId).isEmpty()) {
                throw new InvalidRequestException("User not found");
            }
            repository.deleteById(userId);
        }

}
