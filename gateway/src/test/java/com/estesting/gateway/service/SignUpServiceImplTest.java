package com.estesting.gateway.service;

import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

@SpringBootTest
@Import(SignUpServiceImpl.class)
public class SignUpServiceImplTest extends AbstractUnitTest {

  @Autowired
  private SignUpServiceImpl signUpServiceImpl = Mockito.mock(SignUpServiceImpl.class);

  @Test(priority = 1)
  public void withValidSignUpFormSignUpServiceReturnsOK() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    ResponseEntity<String> signUpResponseEntity = signUpServiceImpl.createUser(validSignUpForm);

    assertThat(
        "User created",
        signUpResponseEntity.toString(),
        Matchers.containsString("User: " + validSignUpForm.getUsername() + " created"));
  }

  @Test(priority = 2, dependsOnMethods = "withValidSignUpFormSignUpServiceReturnsOK")
  public void withExistingUserInDatabaseSecondTheSameUserCanNotBeCreated() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    ResponseEntity<String> signUpResponseEntity = signUpServiceImpl.createUser(validSignUpForm);

    assertThat(
        "User created",
        signUpResponseEntity.toString(),
        Matchers.containsString(
            "User " + validSignUpForm.getUsername() + " already exist" + " in db"));
  }
}
