package com.estesting.gateway.exceptions;

public class UserNotFoundException extends Exception {

  public UserNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }
}
