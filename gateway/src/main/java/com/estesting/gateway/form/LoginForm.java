package com.estesting.gateway.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginForm implements Form {
  @NotBlank(message = "Email can not be blank")
  @NotEmpty(message = "Email can not be empty")
  @NotNull(message = "Email is mandatory")
  private String login;

  @NotBlank(message = "Password can not be blank")
  @NotEmpty(message = "Password can not be empty")
  @NotNull(message = "Password is mandatory")
  private String password;
}
