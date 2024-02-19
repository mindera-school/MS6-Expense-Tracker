package com.example.punished.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

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
        private int id;
        @Column(nullable = false)
        private String description;
        @Column(nullable = false)
        private int cost;

    }