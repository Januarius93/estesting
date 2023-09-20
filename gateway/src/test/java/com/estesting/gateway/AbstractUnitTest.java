package com.estesting.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

public abstract class AbstractUnitTest {
  protected MockMvc mockMvc;

  protected ObjectMapper objectMapper = new ObjectMapper();

  @BeforeClass
  protected void setupBeforeClass(WebApplicationContext webApplicationContext) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
}
