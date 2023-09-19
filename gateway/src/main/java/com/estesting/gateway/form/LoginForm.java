package com.estesting.gateway.form;

import com.estesting.gateway.model.User;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
public class LoginForm {
   @NotBlank(message = "Email can not be blank")
   @NotEmpty(message = "Email can not be empty")
   @NotNull(message = "Email is mandatory")
   @Setter
   private String login;

   @NotBlank(message = "Email can not be blank")
   @NotEmpty(message = "Email can not be empty")
   @NotNull(message = "Email is mandatory")
   @Setter
   private String password;

}
