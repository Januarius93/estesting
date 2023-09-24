package com.estesting.gateway.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Password {
  @Setter
  @NotBlank(message = "Password can not be blank")
  @NotEmpty(message = "Password can not be empty")
  @NotNull(message = "Password is mandatory")
  private String PASSWORD;
}
