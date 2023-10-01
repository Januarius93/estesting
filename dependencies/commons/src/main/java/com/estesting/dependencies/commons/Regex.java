package com.estesting.dependencies.commons;

public class Regex {

  public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3,50}$";

  public static class Password {

    public static final String MUST_CONTAINS_0_9 = "(?=.*[0-9]).+";
    public static final String MUST_CONTAINS_a_z = "(?=.*[a-z]).+";
    public static final String MUST_CONTAINS_A_Z = "(?=.*[A-Z]).+";
    public static final String MUST_CONTAINS_NO_WHITESPACE = "(?=\\S+$).+";
    public static final String MUST_CONTAINS_SPECIAL_CHARS = "(?=.*[!@#$%^&*]).+";
  }
}
