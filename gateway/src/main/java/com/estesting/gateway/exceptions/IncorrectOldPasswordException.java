package com.estesting.gateway.exceptions;

public class IncorrectOldPasswordException extends Exception {
    public IncorrectOldPasswordException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
