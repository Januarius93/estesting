package com.estesting.gateway.model;

import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

  @Pattern(regexp = EMAIL_REGEX)
  @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
  private String email;

  @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
  private String username;

  @Column(name = "PASSWORD", length = 50, nullable = false, unique = true)
  private String password;

  @Column(name = "AGE", length = 50, nullable = false, unique = true)
  private Integer age;

  @Enumerated(EnumType.STRING)
  private Role role;

  public User(String login, String password) {
    this.username = login;
    this.password = password;
  }
}
