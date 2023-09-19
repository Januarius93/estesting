package com.estesting.gateway.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<String> handleNoSuchElementFoundException(
      ConstraintViolationException exception) {

    Map<String, Object> response = new HashMap<>();
    response.put("message", exception.getMessage());
    response.put("error", HttpStatus.BAD_REQUEST);
    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
  }
}
