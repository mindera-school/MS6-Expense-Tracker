package com.example.punished.expensetracker.repository;


import com.example.punished.expensetracker.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
