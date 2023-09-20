package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {

  private SignUpForm signUpForm = new SignUpForm();

  @Test
  @SneakyThrows
  public void signupShouldReturnSignUpSuccessWithValidUserDataAndHttp200() {
    mockMvc
        .perform(post("/signup").content(signUpForm.getLogin()))
        .andExpect(status().isOk());
  }
}
