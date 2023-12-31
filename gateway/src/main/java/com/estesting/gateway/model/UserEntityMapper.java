package com.estesting.gateway.model;

import com.estesting.gateway.form.Form;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
public class UserEntityMapper {
  @Setter private Form userForm;

  public UserEntityMapper(Form signUpForm) {
    this.userForm = signUpForm;
  }

  @SneakyThrows
  public User generateUser() {
    return new ObjectMapper().readValue(userForm.getFormData(), User.class);
  }
}
