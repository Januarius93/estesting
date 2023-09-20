package com.estesting.gateway.exceptions;

import com.estesting.gateway.controller.login.LoginController;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(LoginController.class);

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<String> handleConstraintViolationException(
      ConstraintViolationException exception) {
    Map<String, Object> response = new HashMap<>();
    response.put("error", HttpStatus.BAD_REQUEST);
    response.put("message", getConstrainsViolations(exception));
    log.error(exception.getMessage());
    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
  }


  private List<String> getConstrainsViolations(ConstraintViolationException exception) {
    return exception.getConstraintViolations().stream()
        .map(ConstraintViolation::getMessage)
        .toList();
  }
}
