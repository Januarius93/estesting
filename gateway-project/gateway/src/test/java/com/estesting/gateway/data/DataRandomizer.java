package com.estesting.gateway.data;

import java.util.Random;

public class DataRandomizer {

  private static final String TEST_USER_MAIL = "somepropermail%d@mail.com";
  private static final String TEST_USER_USERNAME = "someuse%drname";

  public static String generateUserEmailWithSoftRandom() {
    return String.format(TEST_USER_MAIL, new Random().nextInt(100 - 10 + 1) * 10);
  }

  public static String generateUserNameWithSoftRandom() {
    return String.format(TEST_USER_USERNAME, new Random().nextInt(100 - 10 + 1) * 10);
  }
}
