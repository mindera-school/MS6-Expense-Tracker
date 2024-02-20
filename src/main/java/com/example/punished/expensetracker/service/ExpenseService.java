package com.example.punished.expensetracker.service;

import com.example.punished.expensetracker.entity.Expense;
import com.example.punished.expensetracker.exceptions.InvalidRequestException;
import com.example.punished.expensetracker.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ExpenseService {

        private final ExpenseRepository repository;
        public List<Expense> getExpenses() {
            return repository.findAll().stream().toList();
        }

        public Expense addExpense(Expense expense) {
            if (expense.getDescription()== null) {
                throw new InvalidRequestException("Description cannot be empty");
            }

            return repository.save(expense);
        }

        public Optional<Expense> getExpenseById(final int expenseId) {
            Optional<Expense> expenseAux = repository.findById(expenseId);
            return expenseAux;
        }

        public void deleteExpense(final int expenseId) {
            Optional<Expense> expense = repository.findById(expenseId);
            repository.delete(expense.get());
        }
}
