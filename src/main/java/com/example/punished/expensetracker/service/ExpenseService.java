package com.example.punished.expensetracker.service;

import com.example.punished.expensetracker.dto.ExpenseDto;
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

    public ExpenseDto addExpense(ExpenseDto expense) {
        System.out.println(expense.getCost()+expense.getDescription());
        if (expense.getDescription() == null || expense.getCost() == null) {
            throw new InvalidRequestException("Description, cost cannot be empty");
        }
        Expense newExpense = new Expense();
        newExpense.setDescription(expense.getDescription());
        newExpense.setCost(expense.getCost());
        repository.save(newExpense);
        return expense;
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
