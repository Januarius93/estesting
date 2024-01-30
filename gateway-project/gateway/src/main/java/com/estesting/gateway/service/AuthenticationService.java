package com.estesting.gateway.service;

import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.form.AuthenticationForm;
import com.estesting.gateway.model.Message;
import com.estesting.gateway.model.User;
import com.estesting.gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.estesting.gateway.service.Commons.getNonEmptyUser;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements com.estesting.gateway.service.Service {
  private final AuthenticationManager authenticationManager;
  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

  @Autowired private UserRepository userRepository;

  @Autowired private final JwtService jwtService;

  public ResponseEntity<String> authenticate(AuthenticationForm authenticationForm) {
    List<User> userEmailLogin = userRepository.findByEmail(authenticationForm.getLogin());
    List<User> userUsernameLogin = userRepository.findByUsername(authenticationForm.getLogin());
    var user = getNonEmptyUser(userEmailLogin, userUsernameLogin);
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            user.getUsername(), authenticationForm.getPassword()));
    log.info("Authentication for user: " + user.getUsername() + " succeeded");
    var jwtToken = jwtService.generateToken(user);
    return new ResponseEntity(
        new Message(
                HttpStatus.OK,
                jwtToken,
                "Authentication for user: " + user.getUsername() + " succeeded")
            .getResponseMessage(),
        HttpStatus.OK);
  }
}
