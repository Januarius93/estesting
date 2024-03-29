package com.estesting.gateway.assertion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.model.Error;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;

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
    Error message =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Error.class);
    assertThat(
        errorCodes + "all contains in" + message.getMessage(),
        errorCodes.containsAll(message.getMessage()));
  }
}
