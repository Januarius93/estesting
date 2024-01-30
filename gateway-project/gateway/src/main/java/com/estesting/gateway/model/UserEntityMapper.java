package com.estesting.gateway.model;

import com.estesting.gateway.form.Form;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Setter
@Getter
public class UserEntityMapper {

  private Form userForm;

  public UserEntityMapper(Form userForm) {
    this.userForm = userForm;
  }

  @SneakyThrows
  public User generateUser() {
    return new ObjectMapper().readValue(this.userForm.getFormData().toString(), User.class);
  }
}
