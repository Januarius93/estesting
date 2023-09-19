package com.estesting.gateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  @NotNull(message = "Email can not be null")
  @NotEmpty(message = "Email can not be empty")
  @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "this is not email")
  @Email
  private String email;

  @Getter
  @Setter
  @NotNull(message = "username can not be null")
  @NotEmpty(message = "username can not be empty")
  private String username;

  @Getter
  @Setter
  @NotNull(message = "password can not be null")
  @NotEmpty(message = "password can not be empty")
  private Password password;

  @Getter
  @Setter
  @NotNull(message = "age can not be null")
  @NotEmpty(message = "age can not be empty")
  @Positive(message = "age can not be negative")
  @Pattern(regexp = "\\d", message = "only numbers")
  @Min(value = 18, message = "age can not be smaller that 18")
  @Max(value = 18, message = "age can not be greater that 100")
  private Integer age;

  private Role role;

  public User(String login, String password) {
    this.username = login;
    this.password = new Password(password);
  }
}
