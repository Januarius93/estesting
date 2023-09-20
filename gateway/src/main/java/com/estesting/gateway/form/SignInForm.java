package com.estesting.gateway.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.json.JSONObject;

@Builder
public class SignInForm implements Form {
  @NotBlank(message = "Email can not be blank")
  @NotEmpty(message = "Email can not be empty")
  @NotNull(message = "Email is mandatory")
  private String login;

  @NotBlank(message = "Password can not be blank")
  @NotEmpty(message = "Password can not be empty")
  @NotNull(message = "Password is mandatory")
  private String password;

  @Override
  public String getFormData() {
    return new JSONObject().put("login", this.login).put("password", this.password).toString();
  }
}
