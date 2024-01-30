package com.estesting.gateway.service;

import static com.estesting.gateway.data.PasswordChangeFormTestData.buildValidPasswordChangeForm;
import static org.hamcrest.MatcherAssert.assertThat;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.form.PasswordResetForm;
import com.estesting.gateway.model.User;
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

  @Autowired
  private final PasswordServiceImpl passwordService = Mockito.mock(PasswordServiceImpl.class);

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
    User user = generateUser();
    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail(user.getEmail());

    ResponseEntity<String> passwordResetResponseEntity =
        passwordService.resetPassword(passwordResetForm);
    assertThat(
        "Email found in db",
        passwordResetResponseEntity.toString(),
        Matchers.containsString(
            "Password reset instructions was sent to: " + passwordResetForm.getEmail()));
  }

  @Test
  public void withProperDataUserIsAbleToChangePassword() {
    String TEST_PASSWORD = "1q2w!Q@W2w1q@W!Q";
    User user = generateUser(TEST_PASSWORD);
    PasswordChangeForm passwordChangeForm = buildValidPasswordChangeForm(user.getEmail(),
        TEST_PASSWORD);

    ResponseEntity<String> passwordChangeResponseEntity =
        passwordService.changePassword(passwordChangeForm);

    assertThat(
        "Password changed successfully",
        passwordChangeResponseEntity.toString(),
        Matchers.containsString(
            "Password changed for: " + user.getEmail()));

  }

  @Test
  public void withInProperPasswordDataUserIsNotAbleToChangePassword() {
    String TEST_PASSWORD = "1q2w!Q@W2w1q@W!Q";
    String INVALID_TEST_PASSWORD = "12w!1q@W!QQ@Wq2w";
    User user = generateUser(TEST_PASSWORD);
    PasswordChangeForm passwordChangeForm = buildValidPasswordChangeForm(user.getEmail(),
        INVALID_TEST_PASSWORD);
    ResponseEntity<String> passwordChangeResponseEntity =
        passwordService.changePassword(passwordChangeForm);

    assertThat(
        "Password change failed",
        passwordChangeResponseEntity.toString(),
        Matchers.containsString(
            "Old password for:  " + user.getEmail() + " is incorrect"));

  }
}
