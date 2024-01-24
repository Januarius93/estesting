package com.estesting.gateway.service;

import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.exceptions.PasswordDoesNotMatchException;
import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.model.Message;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {

  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
  @Autowired
  private UserRepository userRepository;

  @Override
  public ResponseEntity<String> signIn(SignInForm signInForm) {
    List<User> userEmailLogin = userRepository.findByEmail(signInForm.getLogin());
    List<User> userUsernameLogin = userRepository.findByUsername(signInForm.getLogin());
    try {
      getNonEmptyUser(userEmailLogin, userUsernameLogin);
    } catch (Exception exception) {
      log.error("User: " + signInForm.getLogin() + " not found");
      return new ResponseEntity(
          new Message(
              HttpStatus.NOT_FOUND, List.of("User: " + signInForm.getLogin() + " not found"))
              .getResponseMessage(),
          HttpStatus.NOT_FOUND);
    }
    return authenticate(signInForm, getNonEmptyUser(userEmailLogin, userUsernameLogin));
  }

  public ResponseEntity<String> authenticate(SignInForm signInForm, User nonEmptyUser) {
    PasswordEncoderImpl passwordEncoder = new PasswordEncoderImpl();
    String password = new UserEntityMapper(signInForm).generateUser().getPassword();
    try {
      if (!passwordEncoder.matches(password, nonEmptyUser.getPassword())) {
        throw new PasswordDoesNotMatchException("Invalid password");
      }
    } catch (PasswordDoesNotMatchException exception) {
      log.error("User: " + signInForm.getLogin() + " typed invalid password");
      return new ResponseEntity(
          new Message(HttpStatus.BAD_REQUEST, "Invalid password").getResponseMessage(),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(
        new Message(
            HttpStatus.OK, "Authentication for user: " + signInForm.getLogin() + " succeeded")
            .getResponseMessage(),
        HttpStatus.OK);
  }

  private User getNonEmptyUser(List<User> emailUserList, List<User> usernameUserList) {
    return Stream.of(emailUserList, usernameUserList)
        .filter(userList -> !userList.isEmpty())
        .toList()
        .stream()
        .findFirst()
        .get()
        .stream()
        .findFirst()
        .get();
  }
}
