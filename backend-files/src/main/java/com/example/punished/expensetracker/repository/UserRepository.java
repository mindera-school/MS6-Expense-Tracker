package com.example.punished.expensetracker.repository;

import com.example.Expense.Tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
