package com.estesting.gateway;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {

  private final Argon2PasswordEncoder argon2PasswordEncoder;
  int saltLength = 16;
  int hashLength = 32;
  int parallelism = 1;
  int memory = 4096;
  int iterations = 3;

  public PasswordEncoderImpl() {
    argon2PasswordEncoder =
        new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
  }

  @Override
  public String encode(CharSequence rawPassword) {
    return argon2PasswordEncoder.encode(rawPassword);
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return argon2PasswordEncoder.matches(rawPassword, encodedPassword);
  }

  @Override
  public boolean upgradeEncoding(String encodedPassword) {
    return PasswordEncoder.super.upgradeEncoding(encodedPassword);
  }
}
