package com.estesting.gateway;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
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
