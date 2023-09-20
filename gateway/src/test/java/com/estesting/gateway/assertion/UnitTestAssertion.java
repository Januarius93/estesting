package com.estesting.gateway.assertion;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.model.Error;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UnitTestAssertion extends AbstractUnitTest {
  public static void assertThatStatusCodeIs400(MvcResult mvcResult) {
    assertThat(
        mvcResult.getResponse().getStatus() + " should be " + HttpStatus.BAD_REQUEST.value(),
        mvcResult.getResponse().getStatus(),
        equalTo(HttpStatus.BAD_REQUEST.value()));
  }

  @SneakyThrows
  public static void assertThatResponseContainsErrorCodes(
      MvcResult mvcResult, List<String> errorCodes) {
    Error error = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Error.class);
    assertThat(
        error.getMessage() + " contains " + errorCodes, error.getMessage().containsAll(errorCodes));
  }
}
