package com.estesting.gateway.exceptions;

public class PasswordDoesNotMatchException extends Exception {
  public PasswordDoesNotMatchException(String exceptionMessage) {
    super(exceptionMessage);
  }
}
