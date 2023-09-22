package com.estesting.gateway.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user_entity")
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 50, nullable = false, unique = true)
    private Password password;

    @Column(name = "AGE", length = 50, nullable = false, unique = true)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String login, String password) {
        this.username = login;
        this.password = new Password(password);
    }
}
