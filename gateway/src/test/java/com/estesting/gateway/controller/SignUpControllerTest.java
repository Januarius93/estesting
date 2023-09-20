package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.form.SignUpForm;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {
  private SignUpForm correctSignUpform;
  private SignUpForm userWithWrong;

  @BeforeTest
  public void setupBeforeTest() {
    correctSignUpform =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("someusername")
            .password("somepwd")
            .age(18)
            .build();
  }

  @Test
  @SneakyThrows
  public void withValidUserDataSignupShouldReturnSuccessAndHttp200() {
    mockMvc
        .perform(
            post("/signup")
                .content(correctSignUpform.getSignUpData())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  @SneakyThrows
  public void withBadEmailSignupShouldReturnErrorsAnd400() {

  }

  @Test
  @SneakyThrows
  public void whenUsernameEmptySignupShouldReturnErrorsAnd400() {

  }

  @Test
  @SneakyThrows
  public void whenPasswordEmptySignupShouldReturnErrorsAnd400() {

  }

  @Test
  @SneakyThrows
  public void whenAgeBrokenSignupShouldReturnErrorsAnd400() {

  }
}
