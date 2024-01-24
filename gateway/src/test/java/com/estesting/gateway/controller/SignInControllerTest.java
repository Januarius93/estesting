package com.estesting.gateway.controller;

import static com.estesting.dependencies.commons.Endpoint.SIGN_IN_ENDPOINT;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatResponseContainsErrorCodes;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatStatusCodeIs400;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.controller.signin.SignInController;
import com.estesting.gateway.data.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import java.util.List;
import lombok.SneakyThrows;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

@SpringBootTest
@Import(SignInController.class)
public class SignInControllerTest extends AbstractUnitTest {

  private SignInForm validSignInForm;
  private SignUpForm validSignUpForm;
  @Autowired
  private UserRepository userRepository = Mockito.mock(UserRepository.class);

  @Test
  public void withValidSignInDataSignInShouldReturnSuccessWithHttp200() throws Exception {
    validSignUpForm = buildValidSignUpForm();
    String rawPassword = validSignUpForm.getPassword();
    validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
    User user1 = new UserEntityMapper(validSignUpForm).generateUser();
    userRepository.save(user1);

    validSignUpForm.setPassword(rawPassword);
    validSignInForm =
        SignInForm.builder()
            .login(validSignUpForm.getEmail())
            .password(validSignUpForm.getPassword())
            .build();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post(SIGN_IN_ENDPOINT)
                .content(validSignInForm.getFormData().toString())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    "{\"message\":\"Authentication for user: somepropermail@mail.com succeeded\","
                        + "\"code\":\"OK\"}"))
        .andReturn();
  }

  @SneakyThrows
  @Test(dataProvider = "invalidSignInForm", dataProviderClass = UnitTestDataProvider.class)
  public void withInvalidSignInDataSignInShouldReturnErrorsAndHttp400(
      SignInForm signInForm, List<String> errorCodes) {
    mvcResult =
        mockMvc
            .perform(
                post(SIGN_IN_ENDPOINT)
                    .content(String.valueOf(signInForm.getFormData()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    assertThatStatusCodeIs400(mvcResult);
    assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
  }
}
