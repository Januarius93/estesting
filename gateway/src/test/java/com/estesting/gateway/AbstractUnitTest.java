package com.estesting.gateway;

import com.estesting.gateway.form.Form;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

import static com.estesting.dependencies.commons.Endpoint.PASSWORD_CHANGE_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.PASSWORD_ENDPOINT;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpFormWithPassword;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class AbstractUnitTest extends AbstractTestNGSpringContextTests {
    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected MockMvc mockMvc;
    protected MvcResult mvcResult;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    protected UserRepository userRepository = Mockito.mock(UserRepository.class);

    protected User generateUser(String password) {
        SignUpForm validSignUpForm = buildValidSignUpFormWithPassword(password);
        validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
        User user = new UserEntityMapper(validSignUpForm).generateUser();
        userRepository.save(user);
        return user;
    }

    protected User generateUser() {
        SignUpForm validSignUpForm = buildValidSignUpForm();
        validSignUpForm.setPassword(new PasswordEncoderImpl().encode(validSignUpForm.getPassword()));
        User user = new UserEntityMapper(validSignUpForm).generateUser();
        userRepository.save(user);
        return user;
    }

    @SneakyThrows
    protected void sendMockedRequest(Form form, String endpoint, ResultMatcher status, String expectedMessage) {
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post(endpoint)
                                .content(form.getFormData().toString())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status)
                .andExpect(
                        content()
                                .json(
                                        expectedMessage))
                .andReturn();
    }

    @BeforeClass
    protected void setupBeforeClass() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
}
