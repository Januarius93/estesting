package com.estesting.gateway.service;

import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.Message;
import com.estesting.gateway.model.Role;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtService jwtService;

  @Override
  public ResponseEntity<String> createUser(SignUpForm signUpForm) {
    // the issue to review is that eventually could throw exception by other cause than user already
    // exists
    signUpForm.setPassword(new PasswordEncoderImpl().encode(signUpForm.getPassword()));
    User user = new UserEntityMapper(signUpForm).generateUser();
    user.setRole(Role.USER);
    try {
      userRepository.save(user);
      log.info("User " + user.getUsername() + " created");
    } catch (Exception e) {
      log.error("User " + user.getUsername() + " already exist in db");
      return new ResponseEntity(
          new Message(
              HttpStatus.BAD_REQUEST,
              "User " + user.getUsername() + " already exist" + " in db")
              .getResponseMessage(),
          HttpStatus.BAD_REQUEST);
    }
    String jwToken = jwtService.generateToken(user);
    return new ResponseEntity(
        new Message(HttpStatus.OK, jwToken, "User: " + user.getUsername() + " created")
            .getResponseMessage(),
        HttpStatus.OK);
  }
}
