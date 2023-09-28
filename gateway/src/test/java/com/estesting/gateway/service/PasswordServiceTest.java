package com.estesting.gateway.service;

import static org.hamcrest.MatcherAssert.assertThat;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.PasswordResetForm;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

@SpringBootTest
@Import(PasswordServiceImpl.class)
public class PasswordServiceTest extends AbstractUnitTest {
  @Autowired private PasswordServiceImpl signInService = Mockito.mock(PasswordServiceImpl.class);

  @Test
  public void withNonExistentUserPasswordResetShouldReturnsEmailNotFound() {
    String someMail = "somemail@comn.pl";
    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail("somemail@comn.pl");
    ResponseEntity<String> paswordResetResponseEntity =
        signInService.resetPassword(passwordResetForm);
    assertThat(
        "User not found in db",
        paswordResetResponseEntity.toString(),
        Matchers.containsString("User with given mail: " + someMail + " was not found"));
  }
}
