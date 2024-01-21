package com.estesting.gateway.repository;

import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
public class UserRepositoryTest extends AbstractUnitTest {
  @Autowired private UserRepository userRepository = Mockito.mock(UserRepository.class);

  @Test
  public void withValidSignUpFormUserShouldBeCreatedInRepository() {
    SignUpForm validSignUpForm = buildValidSignUpForm();
    User user = new UserEntityMapper(buildValidSignUpForm()).generateUser();
    User repositoryUser = userRepository.save(user);
    assertThat("User should be created in repository", repositoryUser.getId(), is(notNullValue()));
  }
}
