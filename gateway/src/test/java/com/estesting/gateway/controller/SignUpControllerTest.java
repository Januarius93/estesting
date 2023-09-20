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
  private SignUpForm userWithWrongEmail;
  private SignUpForm userWithEmptyMail;

  private SignUpForm userWithEmptyUserName;

  private SignUpForm userWithEmptyPassword;
  private SignUpForm userWithBelow18;
  private SignUpForm userWithAbove100;

  private SignUpForm userWithAllEmptyFields;
  private SignUpForm userWithAllNullValues;

  private SignUpForm userWithNoData;

  @BeforeTest
  public void setupBeforeTest() {
    correctSignUpform =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("someusername")
            .password("somepwd")
            .age(18)
            .build();

    userWithWrongEmail =
        SignUpForm.builder()
            .email("wrongmail")
            .username("someusername")
            .password("somepwd")
            .age(21)
            .build();

    userWithEmptyMail =
        SignUpForm.builder().email("").username("someusername").password("somepwd").age(18).build();

    userWithEmptyUserName =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("")
            .password("somepwd")
            .age(18)
            .build();

    userWithEmptyPassword =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("someusername")
            .password("")
            .age(18)
            .build();

    userWithBelow18 =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("someusername")
            .password("somepwd")
            .age(17)
            .build();

    userWithAbove100 =
        SignUpForm.builder()
            .email("somepropermail@mail.com")
            .username("someusername")
            .password("somepwd")
            .age(101)
            .build();

    userWithAllEmptyFields =
        SignUpForm.builder().email("").username("").password("").age(101).build();

    userWithAllNullValues =
        SignUpForm.builder().email(null).username(null).password(null).age(null).build();

    userWithNoData = SignUpForm.builder().build();
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
  public void withBadEmailSignupShouldReturnErrorsAnd400() {}

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
