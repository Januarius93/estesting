package com.estesting.gateway.service;

import com.estesting.gateway.exceptions.EmailDoesNotExist;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.form.PasswordResetForm;
import com.estesting.gateway.model.Message;
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
public class PasswordServiceImpl implements PasswordService {
  private static final Logger log = LoggerFactory.getLogger(PasswordServiceImpl.class);

  @Autowired private UserRepository userRepository;

  public ResponseEntity<String> resetPassword(PasswordResetForm passwordResetForm) {
    User user = new UserEntityMapper(passwordResetForm).generateUser();
    try {
      userRepository.findByEmail(user.getEmail()).stream()
          .findFirst()
          .orElseThrow(
              () ->
                  new EmailDoesNotExist(
                      "User with given mail: " + user.getEmail() + " was not found"));
    } catch (Exception e) {
      log.error("User with given mail: " + user.getEmail() + "was not found");
      return new ResponseEntity(
          new Message(
                  HttpStatus.NOT_FOUND,
                  "User with given mail: " + passwordResetForm.getEmail() + " was not found")
              .getResponseMessage(),
          HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(
        new Message(
                HttpStatus.OK,
                "Password reset instructions was sent to: " + passwordResetForm.getEmail())
            .getResponseMessage(),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> changePassword(PasswordChangeForm passwordChangeForm) {
    return null;
  }
}
