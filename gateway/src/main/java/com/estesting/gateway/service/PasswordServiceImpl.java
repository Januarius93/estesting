package com.estesting.gateway.service;

import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.exceptions.EmailDoesNotExist;
import com.estesting.gateway.exceptions.IncorrectOldPasswordException;
import com.estesting.gateway.form.Form;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.form.PasswordResetForm;
import com.estesting.gateway.model.Message;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.estesting.dependencies.commons.FormRequestAttributes.*;

@Service
public class PasswordServiceImpl implements PasswordService {
    private static final Logger log = LoggerFactory.getLogger(PasswordServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> resetPassword(Form passwordResetForm) {
        User user = new UserEntityMapper(passwordResetForm).generateUser();
        String email = user.getEmail();
        try {
            checkIfUserExist(user);
        } catch (Exception e) {
            return userNotFound(user);
        }
        return new ResponseEntity(
                new Message(
                        HttpStatus.OK,
                        "Password reset instructions was sent to: " + email)
                        .getResponseMessage(),
                HttpStatus.OK);
    }


    @Override
    public ResponseEntity<String> changePassword(Form passwordChangeForm) {
        PasswordEncoderImpl passwordEncoder = new PasswordEncoderImpl();
        User user = new UserEntityMapper(passwordChangeForm).generateUser();
        try {
            checkIfUserExist(user);
        } catch (Exception e) {
            userNotFound(user);
        }
        log.error("User " + user.getEmail() + " found");
        String oldPassword = user.getOldPassword();
        User userToUpdate = userRepository.findByEmail(user.getEmail()).stream().findFirst().get();

        try {
            if (!passwordEncoder.matches(oldPassword, userToUpdate.getPassword())) {
                throw new IncorrectOldPasswordException("Old password for:  " + user.getEmail() + " is incorrect");
            }
        } catch (IncorrectOldPasswordException e) {
            log.error("Old password is incorrect!");
            return new ResponseEntity(
                    new Message(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            "Old password for:  " + user.getEmail() + " is incorrect")
                            .getResponseMessage(),
                    HttpStatus.NOT_FOUND);
        }
        userToUpdate.setPassword(new PasswordEncoderImpl().encode(passwordChangeForm.getFormData().get(PASSWORD).toString()));
        userRepository.save(userToUpdate);

        return new ResponseEntity(
                new Message(
                        HttpStatus.OK,
                        "Password changed for: " + user.getEmail())
                        .getResponseMessage(),
                HttpStatus.OK);
    }

    @SneakyThrows
    private void checkIfUserExist(User user) {
        userRepository.findByEmail(user.getEmail()).stream()
                .findFirst()
                .orElseThrow(
                        () ->
                                new EmailDoesNotExist(
                                        "User with given mail: " + user.getEmail() + " was not found"));
    }

    private ResponseEntity userNotFound(User user) {
        log.error("User with given mail: " + user.getEmail() + "was not found");
        return new ResponseEntity(
                new Message(
                        HttpStatus.NOT_FOUND,
                        "User with given mail: " + user.getEmail() + " was not found")
                        .getResponseMessage(),
                HttpStatus.NOT_FOUND);
    }
}
