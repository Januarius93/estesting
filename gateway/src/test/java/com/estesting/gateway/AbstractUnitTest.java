package com.estesting.gateway;

import com.estesting.gateway.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

public abstract class AbstractUnitTest extends AbstractTestNGSpringContextTests {
  protected static ObjectMapper objectMapper = new ObjectMapper();
  protected MockMvc mockMvc;
  protected MvcResult mvcResult;
//  @Autowired protected UserRepository userRepository;
  @Autowired private WebApplicationContext webApplicationContext;
  @Autowired protected UserRepository userRepository = Mockito.mock(UserRepository.class);

  @BeforeClass
  protected void setupBeforeClass() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }
}
