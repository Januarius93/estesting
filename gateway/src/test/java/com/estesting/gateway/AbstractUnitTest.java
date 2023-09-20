package com.estesting.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

public abstract class AbstractUnitTest extends AbstractTestNGSpringContextTests {
  protected MockMvc mockMvc;
  protected MvcResult mvcResult;
  protected static final String SIGN_UP_ENDPOINT = "/signup";
  protected static final String SIGN_IN_ENDPOINT = "/signin";
  protected static ObjectMapper objectMapper = new ObjectMapper();
  @Autowired private WebApplicationContext webApplicationContext;

  @BeforeClass
  protected void setupBeforeClass() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }
}
