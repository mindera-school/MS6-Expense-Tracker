package com.example.punished.expensetracker.controller;

import com.example.punished.expensetracker.entity.Expense;
import com.example.punished.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/{userId}/expense")
@RequiredArgsConstructor
public class ExpenseController {

        private final ExpenseService service;

        @GetMapping
        public List<Expense> getExpenses() {
            return service.getExpenses();
        }

        @PostMapping
        public Expense addExpense(@RequestBody Expense expense) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.addExpense(expense)).getBody();
        }

        @GetMapping("/{expenseId}")
        public Optional<Expense> getExpenseById(@PathVariable final Long expenseId) {
            return service.getExpenseById(expenseId);
        }

        @DeleteMapping("/{expenseId}")
        public void deleteExpense(@PathVariable final Long expenseId) {
            service.deleteExpense(expenseId);
        }
    }


