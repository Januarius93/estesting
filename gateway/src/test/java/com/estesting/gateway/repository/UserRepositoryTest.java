package com.estesting.gateway.repository;

import static com.estesting.gateway.SignUpFormTestData.buildInvalidEmailFormatSignUpForm;
import static com.estesting.gateway.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import jakarta.validation.ConstraintViolationException;
import lombok.SneakyThrows;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;
import org.testng.TestException;
import org.testng.annotations.Test;

@SpringBootTest
public class UserRepositoryTest extends AbstractUnitTest {
  @Autowired private UserRepository userRepository = Mockito.mock(UserRepository.class);

  @Test
  public void withValidSignUpFormUserShouldBeCreatedInRepository() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    User user = new UserEntityMapper(validSignUpForm).generateUser();
    User repositoryUser = userRepository.save(user);
    assertThat("User should be created in repository", repositoryUser.getId(), is(notNullValue()));
  }
}
