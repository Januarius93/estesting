package com.estesting.gateway.controller;

import com.estesting.gateway.controller.login.LoginController;
import com.estesting.gateway.model.Credentials;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@SpringBootTest
@Import(LoginController.class)
public class LoginControllerTest extends AbstractTestNGSpringContextTests {
    Credentials credentials;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeClass
    public void setupBeforeClass() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @BeforeTest
    public void setUpBeforeClass() {
        credentials = new Credentials("sampleusername", "samplepassword");
    }

    @Test
    public void loginShouldReturnLoginSuccessWithCredentials() throws Exception {
        mockMvc.perform(post("/login")
                        .content(new JSONObject()
                                .put("username", credentials.getUsername())
                                .put("password", credentials.getPassword()).toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.format("message\":\"login success with credentials: %s %s", credentials.getUsername(), credentials.getPassword()))))
                .andReturn();
    }
}
