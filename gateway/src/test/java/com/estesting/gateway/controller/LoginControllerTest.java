package com.estesting.gateway.controller;

import com.estesting.gateway.controller.login.LoginController;
import com.estesting.gateway.model.Error;
import com.estesting.gateway.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Import(LoginController.class)
public class LoginControllerTest extends AbstractTestNGSpringContextTests {

  @Autowired private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private ObjectMapper objectMapper = new ObjectMapper();

  @BeforeClass
  public void setupBeforeClass() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test(dataProvider = "validUserDataProvider")
  public void loginShouldReturnLoginSuccessWithUserNameAndHttp200(User user) throws Exception {
    mockMvc
        .perform(
            post("/login")
                .content(
                    new JSONObject()
                        .put("login", user.getUsername())
                        .put("password", user.getPassword())
                        .toString())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(
            content().string(containsString(String.format("user: %s login", user.getUsername()))))
        .andReturn();
  }

  @Test(dataProvider = "invalidUserDataProvider")
  public void loginShouldReturnLoginErrorAndHttp400(User user, List<String> errorCodes)
      throws Exception {
    MvcResult result =
        mockMvc
            .perform(
                post("/login")
                    .content(
                        new JSONObject()
                            .put("login", user.getUsername())
                            .put("password", user.getPassword())
                            .toString())
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    Error error = objectMapper.readValue(result.getResponse().getContentAsString(), Error.class);
    assertThat(
        result.getResponse().getStatus() + " should be " + HttpStatus.BAD_REQUEST.value(),
        result.getResponse().getStatus(),
        equalTo(HttpStatus.BAD_REQUEST.value()));
    assertThat(
        error.getMessage() + " contains " + errorCodes, error.getMessage().containsAll(errorCodes));
  }

  @DataProvider(name = "invalidUserDataProvider")
  public Object[][] wrongUserDataProvider() {
    return new Object[][] {
      {new User("", "wxpr2xz"), List.of("Email can not be blank", "Email can not be empty")},
      {
        new User(null, "awdawd"),
        List.of("Email can not be empty", "Email can not be blank", "Email is mandatory")
      },
      {
        new User(null, null),
        List.of("Email can not be empty", "Email can not be blank", "Email is mandatory")
      },
      /** mystery for now * */
      //                {new User("Jaugueniush", null)}, mystery for now
      //                {new User("Mateo","" )},

      //            {
      //                    new User("", ""),
      //                    List.of("Email can not be empty", " Email can not be blank",
      // "BAD_REQUEST")
      //            },
    };
  }

  @DataProvider(name = "validUserDataProvider")
  public Object[][] properUserDataProvider() {
    return new Object[][] {
      {new User("Ryszard", "wxpr2xz")},
      {new User("Mateo", "82ja8uda")},
      {new User("Wodzisława", "56jhswery")}
    };
  }

  //    "{"message":"login.loginForm.login: Email can not be empty, login.loginForm.login: Email can
  // not be blank","error":"BAD_REQUEST"}"
}
