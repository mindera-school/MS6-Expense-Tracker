package com.example.punished.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseGetDto {
    private Integer id;
    private String description;
    private Integer cost;
}
