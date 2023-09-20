package com.estesting.gateway.form;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginFormTest {

  @Test
  public void loginFormCreatedSuccessfully() {
    String login = "somelogin";
    String password = "somepwd";
    LoginForm loginForm = LoginForm.builder().login("somelogin").password(password).build();

    assertThat(loginForm.getLogin() + "should be" + login, loginForm.getLogin().equals(login));
    assertThat(
        loginForm.getPassword() + "should be" + password, loginForm.getPassword().equals(password));
  }
}
