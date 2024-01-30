package com.estesting.gateway.exceptions;

import com.estesting.gateway.controller.signin.SignInController;
import com.estesting.gateway.model.Message;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(SignInController.class);

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<String> handleConstraintViolationException(
      ConstraintViolationException exception) {
    Message message = new Message(HttpStatus.BAD_REQUEST, getConstrainsViolations(exception));
    log.error(exception.getMessage());
    return new ResponseEntity(message.getResponseMessage(), HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> handle(ConstraintViolationException exception) {
    Map<String, Object> response = new HashMap<>();
    response.put("code", HttpStatus.BAD_REQUEST);
    response.put("message", exception.getMessage());
    Message message = new Message(HttpStatus.BAD_REQUEST, exception.getMessage());
    log.error(exception.getMessage());
    return new ResponseEntity(message.getResponseMessage(), HttpStatus.BAD_REQUEST);
  }

  private List<String> getConstrainsViolations(ConstraintViolationException exception) {
    return exception.getConstraintViolations().stream()
        .map(ConstraintViolation::getMessage)
        .toList();
  }
}
