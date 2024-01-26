package com.estesting.gateway;

import static com.estesting.dependencies.commons.Endpoint.SIGN_UP_ENDPOINT;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpFormWithPassword;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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

public abstract class AbstractUnitTest extends AbstractTestNGSpringContextTests {

  protected static final ObjectMapper objectMapper = new ObjectMapper();
  protected MockMvc mockMvc;
  @Autowired
  protected final UserRepository  userRepository = Mockito.mock(UserRepository.class);
  @Autowired
  private WebApplicationContext webApplicationContext;

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
  protected void sendMockedPostRequest(Form form, String endpoint, ResultMatcher status,
      String expectedMessage) {
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

  @SneakyThrows
  protected void sendMockedPutRequest(Form form, String endpoint, ResultMatcher status,
                                       String expectedMessage) {
    mockMvc
            .perform(
                    MockMvcRequestBuilders.put(endpoint)
                            .content(form.getFormData().toString())
                            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status)
            .andExpect(
                    content()
                            .json(
                                    expectedMessage))
            .andReturn();
  }
  @SneakyThrows
  protected MvcResult sendMockedPostRequestAndReturn(Form form, String endpoint){
    return mockMvc
            .perform(
                    MockMvcRequestBuilders.post(endpoint)
                            .content(form.getFormData().toString())
                            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
  }
  @SneakyThrows
  protected MvcResult sendMockedPutRequestAndReturn(Form form, String endpoint){
   return mockMvc
            .perform(
                    MockMvcRequestBuilders.put(endpoint)
                            .content(form.getFormData().toString())
                            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
  }

  @BeforeClass
  protected void setupBeforeClass() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }
}
