package com.estesting.gateway.service;

import static com.estesting.gateway.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.form.PasswordResetForm;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
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
  @Autowired private PasswordServiceImpl passwordService = Mockito.mock(PasswordServiceImpl.class);
  @Test
  public void withNonExistentEmailUserPasswordResetShouldReturnsEmailNotFound() {
    String someMail = "somemail@comn.pl";
    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail("somemail@comn.pl");
    ResponseEntity<String> paswordResetResponseEntity =
        passwordService.resetPassword(passwordResetForm);
    assertThat(
        "Email not found in db",
        paswordResetResponseEntity.toString(),
        Matchers.containsString("User with given mail: " + someMail + " was not found"));
  }

  @Test
  public void withExistingEmailUserPasswordResetShouldReturnsProceedWithPasswordReset() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
    User user = new UserEntityMapper(validSignUpForm).generateUser();
    userRepository.save(user);

    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail(user.getEmail());

    ResponseEntity<String> paswordResetResponseEntity =
        passwordService.resetPassword(passwordResetForm);
    assertThat(
        "Email found in db",
        paswordResetResponseEntity.toString(),
        Matchers.containsString(
            "Password reset instructions was sent to: " + passwordResetForm.getEmail()));
  }
}
