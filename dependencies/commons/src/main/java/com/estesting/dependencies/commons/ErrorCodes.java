package com.estesting.dependencies.commons;

public class ErrorCodes {
  public static final String EMAIL_CAN_NOT_BE_BLANK = "Email can not be blank";
  public static final String EMAIL_CAN_NOT_BE_NULL = "Email can not be null";
  public static final String EMAIL_CAN_NOT_BE_EMPTY = "Email can not be empty";
  public static final String EMAIL_IS_MANDATORY = "Email is mandatory";
  public static final String EMAIL_MUST_BE_WELL_FORMATED = "Email must have proper format";
  public static final String THIS_IS_NOT_EMAIL = "This is not email";
  public static final String USERNAME_CAN_NOT_BE_BLANK = "Username can not be blank";
  public static final String USERNAME_CAN_NOT_BE_NULL = "Username can not be null";
  public static final String USERNAME_CAN_NOT_BE_EMPTY = "Username can not be empty";
  public static final String LOGIN_CAN_NOT_BE_BLANK = "Login can not be blank";
  public static final String LOGIN_CAN_NOT_BE_EMPTY = "Login can not be empty";
  public static final String LOGIN_IS_MANDATORY = "Login is mandatory";
  public static final String PASSWORD_CAN_NOT_BE_BLANK = "Password can not be blank";
  public static final String PASSWORD_CAN_NOT_BE_NULL = "Password can not be null";
  public static final String PASSWORD_CAN_NOT_BE_EMPTY = "Password can not be empty";
  public static final String NEW_PASSWORD_CAN_NOT_BE_BLANK = "New password can not be blank";
  public static final String NEW_PASSWORD_CAN_NOT_BE_NULL = "New password can not be null";
  public static final String NEW_PASSWORD_CAN_NOT_BE_EMPTY = "New password can not be empty";
  public static final String PASSWORD_IS_MANDATORY = "Password is mandatory";
  public static final String AGE_CAN_NOT_BE_NULL = "Age can not be null";
  public static final String AGE_CAN_NOT_BE_NEGATIVE = "Age can not be negative";
  public static final String AGE_CAN_NOT_BE_SMALLER_THAN_18 = "Age can not be smaller than 18";
  public static final String AGE_CAN_NOT_BE_GREATER_THAN_100 = "Age can not be greater that 100";
  public static final String MINIMUM_NUMBER_OF_CHARACTERS_FOR_ =
      "Minimum number of characters for ";
  public static final String MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ =
      "Maximum number of characters for ";
  public static final String MINIMUM_NUMBER_OF_CHARACTERS_10 = " is 10";
  public static final String MINIMUM_NUMBER_OF_CHARACTERS_3 = " is 3";
  public static final String MAXIMUM_NUMBER_OF_CHARACTERS_50 = " is 50";
  public static final String MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD = " is 200";

  public static class Password {
    public static final String PASSWORD_MUST_CONTAINS_0_9 = "Password must contains at least one number";
    public static final String PASSWORD_MUST_CONTAINS_a_z = "Password must contains at least one lowercase character";
    public static final String PASSWORD_MUST_CONTAINS_A_Z = "Password must contains at least one uppercase character";
    public static final String PASSWORD_MUST_CONTAINS_SPECIAL_CHARS = "Password must contain one special character !@#$%^&*";
    public static final String PASSWORD_MUST_CONTAINS_NO_WHITESPACE = "Password must contain no whitespace";
  }
}
