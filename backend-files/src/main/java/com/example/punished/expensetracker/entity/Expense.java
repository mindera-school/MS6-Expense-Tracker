package com.example.punished.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Expenses")
@Data
public class Expense {

        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column
        private Long id;
        @Column(nullable = false)
        private String name;
        @Column(nullable = false)
        private int cost;

    }
