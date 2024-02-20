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
@Table(name = "\"expenses\"")
@Data
public class Expense {

        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column
        private Integer id;
        @Column(nullable = false)
        private String description;
        @Column(nullable = false)
        private Integer cost;
        @Column(nullable = false)
        private Integer userId;

    }
