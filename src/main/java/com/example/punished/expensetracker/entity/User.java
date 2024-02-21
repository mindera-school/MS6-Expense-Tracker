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
@Table(name = "\"users\"")
@Data
public class User {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(unique = true)
        private Integer id;
        @Column(nullable = false)
        private String username;
        @Column(nullable = false)
        private String password;
        @Column(unique = true, nullable = false)
        private String email;

}
