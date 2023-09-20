package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.Password;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {
  private SignUpForm correctSignUpform;

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
  public void signupShouldReturnSignUpSuccessWithValidUserDataAndHttp200() {
    mockMvc
        .perform(
            post("/signup")
                .content(correctSignUpform.getSignUpData())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }
}
