package com.estesting.gateway.repository;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static com.estesting.gateway.SignUpFormTestData.buildValidSignUpForm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
public class UserRepositoryTest extends AbstractUnitTest {
    @Autowired
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

//    @BeforeClass
//    public void beforeMethod() {
//        userRepository = Mockito.mock(UserRepository.class);
//    }

    @Test
    public void withValidSignUpFormUserShouldBeCreatedInRepository() {
        SignUpForm validSignUpForm = buildValidSignUpForm();
        User user = new UserEntityMapper(validSignUpForm).generateUser();
        User repositoryUser = userRepository.save(user);
        assertThat("User should be created in repository", repositoryUser.getId(), is(notNullValue()));
    }

//    @Test
//    public void withInvalidSignUpFormUserShouldNotBeCreatedInRepositoryWithErrors() {
//        User user = new UserEntityMapper(SignUpForm.builder().age(18).username("awd").password("awd").email("").build()).generateUser();
//        User repositoryUser = userRepository.save(user);
//        assertThat("User should be created in repository", repositoryUser.getId(), is(notNullValue()));
//    }
}
