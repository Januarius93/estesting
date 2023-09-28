package com.estesting.gateway.service;

import static com.estesting.gateway.SignInFormTestData.buildValidSignInForm;
import static com.estesting.gateway.SignUpFormTestData.buildOtherValidSignUpForm;
import static com.estesting.gateway.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

@SpringBootTest
@Import(SignInServiceImpl.class)
public class SignInServiceImplTest extends AbstractUnitTest {

  @Autowired private SignInServiceImpl signInService = Mockito.mock(SignInServiceImpl.class);

  @Test
  public void withNonExistentUserSignInServiceReturnsUserNotFound() {
    SignInForm signInForm = buildValidSignInForm();
    ResponseEntity<String> signInResponseEntity = signInService.signIn(signInForm);

    assertThat(
        "Response contains: ",
        signInResponseEntity.toString(),
        Matchers.containsString("User: Josh567890 " + "not found"));
  }

  @Test
  public void withExistingUserSignInServiceReturnsStatusOk() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    String rawPassword = validSignUpForm.getPassword();

    validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
    User user1 = new UserEntityMapper(validSignUpForm).generateUser();
    userRepository.save(user1);

    validSignUpForm.setPassword(rawPassword);

    SignInForm validSignInForm =
        SignInForm.builder()
            .login(validSignUpForm.getEmail())
            .password(validSignUpForm.getPassword())
            .build();

    ResponseEntity<String> signInResponseEntity = signInService.signIn(validSignInForm);

    assertThat(
        "Response contains: ",
        signInResponseEntity.toString(),
        Matchers.containsString("Authentication for user: somepropermail@mail.com succeeded"));
  }

  @Test
  public void withIncorrectPasswordSignInServiceReturnInvalidPasswordError() {
    SignUpForm validSignUpForm = buildOtherValidSignUpForm();
    String rawPassword = validSignUpForm.getPassword();

    validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
    User user1 = new UserEntityMapper(validSignUpForm).generateUser();
    userRepository.save(user1);

    validSignUpForm.setPassword("rawPassword");

    SignInForm validSignInForm =
        SignInForm.builder()
            .login(validSignUpForm.getEmail())
            .password(validSignUpForm.getPassword())
            .build();

    ResponseEntity<String> signInResponseEntity = signInService.signIn(validSignInForm);

    assertThat(
        "Response contains: ",
        signInResponseEntity.toString(),
        Matchers.containsString("Invalid password"));
  }
}
