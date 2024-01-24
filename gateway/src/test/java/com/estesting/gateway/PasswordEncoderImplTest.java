package com.estesting.gateway;

import org.junit.Assert;
import org.testng.annotations.Test;

public class PasswordEncoderImplTest {

  @Test
  public void passwordEncoderWillCreateProperHash() {
    String password = "awdawd";
    PasswordEncoderImpl passwordEncoder = new PasswordEncoderImpl();
    String encodedPassword = passwordEncoder.encode(password);
    Assert.assertTrue(passwordEncoder.matches(password, encodedPassword));
  }
}
