package com.estesting.gateway.service;

import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.exceptions.UserNotFoundException;
import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.model.Message;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {
  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
  @Autowired private UserRepository userRepository;

  @Override
  public ResponseEntity<String> signIn(SignInForm signInForm) {
    String login = new UserEntityMapper(signInForm).generateUser().getLogin();
    try {
      if (userRepository.findByEmail(login).isEmpty()
          && userRepository.findByUsername(login).isEmpty()) {
        throw new UserNotFoundException("User: " + login + " not found");
      }
    } catch (UserNotFoundException exception) {
      log.error("User: " + login + " not found");
      return new ResponseEntity(
          new Message(HttpStatus.NOT_FOUND, List.of("User: " + login + " not found"))
              .getResponseMessage(),
          HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(
        new Message(HttpStatus.OK, List.of("User: " + login + " found")).getResponseMessage(),
        HttpStatus.OK);
  }
}
