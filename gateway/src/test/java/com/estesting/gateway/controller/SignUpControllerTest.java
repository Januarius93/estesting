package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.SignUpForm;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import java.util.List;

import static com.estesting.dependencies.commons.Endpoint.SIGN_UP_ENDPOINT;
import static com.estesting.gateway.SignUpFormTestData.buildValidSignUpForm;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatResponseContainsErrorCodes;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatStatusCodeIs400;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {

  @Test
  @SneakyThrows
  public void withValidSignUpDataSignupShouldReturnSuccessAndHttp200() {
    SignUpForm validSignupForm = buildValidSignUpForm();
    mockMvc
        .perform(
            post(SIGN_UP_ENDPOINT)
                .content(validSignupForm.getFormData())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    containsString(
                        String.format("user: %s signup", validSignupForm.getFormData()))))
        .andReturn();
  }

  @SneakyThrows
  @Test(dataProvider = "invalidDataSignUpForm", dataProviderClass = UnitTestDataProvider.class)
  public void withInvalidSignupDataShouldReturnErrorsAnd400(
      SignUpForm signUpFormData, List<String> errorCodes) {
    MvcResult mvcResult =
        mockMvc
            .perform(
                post(SIGN_UP_ENDPOINT)
                    .content(signUpFormData.getFormData())
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    assertThatStatusCodeIs400(mvcResult);
    assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
  }
}
