package com.estesting.gateway.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LoginForm {
  @NotBlank(message = "Email can not be blank")
  @NotEmpty(message = "Email can not be empty")
  @NotNull(message = "Email is mandatory")
  @Setter
  private String login;

  @NotBlank(message = "Password can not be blank")
  @NotEmpty(message = "Password can not be empty")
  @NotNull(message = "Password is mandatory")
  @Setter
  private String password;
}
