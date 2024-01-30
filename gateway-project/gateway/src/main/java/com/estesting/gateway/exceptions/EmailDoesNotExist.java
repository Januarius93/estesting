package com.estesting.gateway.exceptions;

public class EmailDoesNotExist extends Exception {

  public EmailDoesNotExist(String exceptionMessage) {
    super(exceptionMessage);
  }
}
