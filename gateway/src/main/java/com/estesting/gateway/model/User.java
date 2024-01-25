package com.estesting.gateway.model;

import static com.estesting.dependencies.commons.ErrorCodes.THIS_IS_NOT_EMAIL;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  private String login;

  @Pattern(regexp = EMAIL_REGEX, message = THIS_IS_NOT_EMAIL)
  @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
  private String email;

  @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
  private String username;

  @Column(name = "PASSWORD", length = 200, nullable = false)
  @Getter
  private String password;

  @Column(name = "OLD_PASSWORD", length = 200)
  @Getter
  private String oldPassword;

  @Column(name = "AGE", length = 3, nullable = false)
  private Integer age;

  @Enumerated(EnumType.STRING)
  private Role role;

  public User(String login, String password) {
    this.username = login;
    this.password = password;
  }
}
