package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.Error;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import java.util.List;

import static com.estesting.gateway.SignUpFormTestData.*;
import static com.estesting.gateway.assertion.UnitTestAssertion.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {

  @Test
  @SneakyThrows
  public void withValidUserDataSignupShouldReturnSuccessAndHttp200() {
    mockMvc
        .perform(
            post(SIGN_UP_ENDPOINT)
                .content(buildValidSignUpForm())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

  @SneakyThrows
  @Test(dataProvider = "invalidMailSignUpForm", dataProviderClass = UnitTestDataProvider.class)
  public void withBadEmailSignupShouldReturnErrorsAnd400(
      String signUpFormData, List<String> errorCodes) {
    MvcResult mvcResult =
        mockMvc
            .perform(
                post(SIGN_UP_ENDPOINT)
                    .content(signUpFormData)
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    assertThatStatusCodeIs400(mvcResult);
    assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
  }

  @Test
  @SneakyThrows
  public void whenUsernameEmptySignupShouldReturnErrorsAnd400() {}

  @Test
  @SneakyThrows
  public void whenPasswordEmptySignupShouldReturnErrorsAnd400() {}

  @Test
  @SneakyThrows
  public void whenAgeBrokenSignupShouldReturnErrorsAnd400() {}
}
