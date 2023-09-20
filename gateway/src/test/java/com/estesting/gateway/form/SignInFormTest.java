package com.estesting.gateway.form;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SignInFormTest {

  @Test
  public void SignInFormCreatedSuccessfully() {
    String login = "someSignIn";
    String password = "somepwd";
    SignInForm signInForm = SignInForm.builder().login("someSignIn").password(password).build();

    assertThat(signInForm.getLogin() + "should be" + login, signInForm.getLogin().equals(login));
    assertThat(
        signInForm.getPassword() + "should be" + password,
        signInForm.getPassword().equals(password));
  }
}
