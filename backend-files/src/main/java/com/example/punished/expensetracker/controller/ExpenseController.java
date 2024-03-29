package com.example.punished.expensetracker.controller;

import com.example.punished.expensetracker.dto.ExpenseGetDto;
import com.example.punished.expensetracker.service.ExpenseService;
import com.example.punished.expensetracker.dto.ExpenseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class ExpenseController {

        private final ExpenseService service;

        @GetMapping
        public List<ExpenseGetDto> getExpenses() {
            return service.getExpenses();
        }

        @PostMapping
        public ExpenseDto addExpense(@RequestBody ExpenseDto expense) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.addExpense(expense)).getBody();
        }
        @DeleteMapping("/{expenseId}")
        public void deleteExpense(@PathVariable final int expenseId) {
            service.deleteExpense(expenseId);
        }
    }


