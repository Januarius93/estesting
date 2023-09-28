package com.estesting.gateway.controller;

import static com.estesting.dependencies.commons.Endpoint.PASSWORD_RESET_ENDPOINT;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatResponseContainsErrorCodes;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatStatusCodeIs400;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.PasswordResetForm;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

@SpringBootTest
@Import(PasswordController.class)
public class PasswordControllerTest extends AbstractUnitTest {
  @Test
  public void withValidEmailPasswordResetShouldReturnSuccessWithHttp200() throws Exception {
    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail("some@mail.com");
    mockMvc
        .perform(
            post(PASSWORD_RESET_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(passwordResetForm.getFormData()))
        .andExpect(status().isOk())
        .andExpect(
            content().string(containsString(passwordResetForm.getFormData() + " user:  RESET")))
        .andReturn();
  }

  @SneakyThrows
  @Test(
      dataProvider = "invalidDataPasswordResetForm",
      dataProviderClass = UnitTestDataProvider.class)
  public void withInvalidEmailPasswordResetShouldReturnErrorsWithHttp400(
      String email, List<String> errorCodes) {
    PasswordResetForm passwordResetForm = new PasswordResetForm();
    passwordResetForm.setEmail(email);
    mvcResult =
        mockMvc
            .perform(
                post(PASSWORD_RESET_ENDPOINT)
                    .content(passwordResetForm.getFormData())
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    assertThatStatusCodeIs400(mvcResult);
    assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
  }
}
