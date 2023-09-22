package com.estesting.gateway.service;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpServiceImplTest extends AbstractUnitTest {
    private SignUpForm signUpForm;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SignUpServiceImpl signUpService;

    @Autowired
    private UserRepository userRepository;

    @BeforeClass
    public void setUpBeforeTest() {

    }

    @Test
    public void withValidSignUpFormSignUpServiceCreateUser() {
        signUpForm = SignUpForm.builder().email("awdawd").password("awd").build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        signUpService.createUser(signUpForm);
    }
}
