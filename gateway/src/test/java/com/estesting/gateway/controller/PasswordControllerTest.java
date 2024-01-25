package com.estesting.gateway.controller;

import static com.estesting.dependencies.commons.Endpoint.PASSWORD_CHANGE_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.PASSWORD_ENDPOINT;
import static com.estesting.gateway.data.PasswordChangeFormTestData.buildInvalidOldPasswordPasswordChangeForm;
import static com.estesting.gateway.data.PasswordChangeFormTestData.buildValidPasswordChangeForm;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testng.annotations.Test;

@SpringBootTest
@Import(PasswordController.class)
public class PasswordControllerTest extends AbstractUnitTest {

  private static final String PASSWORD_CHANGE = PASSWORD_ENDPOINT + PASSWORD_CHANGE_ENDPOINT;
  @Test
  public void withExistingEmailDataPasswordResetShouldReturnSuccessWithHttp200() {
  }

  @Test
  public void withNonExistentEmailDataPasswordResetShouldReturnSuccessWithHttp400() {
  }

  @Test
  public void withProperOldPasswordDataPasswordChangeShouldReturnSuccessWithHttp200() {
    String TEST_PASSWORD = "$R#E1q2#E1@QE";
    User user = generateUser(TEST_PASSWORD);
    PasswordChangeForm validPasswordChangeForm = buildValidPasswordChangeForm(user.getEmail(),
        TEST_PASSWORD);
    sendMockedRequest(validPasswordChangeForm, PASSWORD_CHANGE, status().isOk(),
        "{\"message\":\"Password changed for: " + user.getEmail() + "\","
            + "\"code\":\"OK\"}");
  }

  @Test
  public void withInvalidOldPasswordDataPasswordResetShouldReturnErrorsAndHttp500() {
    String TEST_PASSWORD = "$R#E1q2#E1@QE";
    User user = generateUser(TEST_PASSWORD);
    PasswordChangeForm validPasswordChangeForm = buildInvalidOldPasswordPasswordChangeForm(
        user.getEmail());
    sendMockedRequest(validPasswordChangeForm, PASSWORD_CHANGE, status().isInternalServerError(),
        "{\"message\":\"Old password for:  " + user.getEmail() + " is incorrect\","
            + "\"code\":\"INTERNAL_SERVER_ERROR\"}");
  }
}
