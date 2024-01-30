package com.estesting.gateway.controller.signin;

import static com.estesting.dependencies.commons.Endpoint.SIGN_IN_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.USER_ENDPOINT;

import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.service.SignInServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(USER_ENDPOINT)
@Validated
@RestController
@RequiredArgsConstructor
public class SignInController {

  private static final Logger log = LoggerFactory.getLogger(SignInController.class);
  @Autowired
  private SignInServiceImpl signInServiceImpl;

  @SneakyThrows
  @PostMapping(value = SIGN_IN_ENDPOINT, consumes = "application/json")
  public @ResponseBody ResponseEntity<String> signIn(
      @RequestBody @Valid SignInForm signInForm, BindingResult bindingResult) {
    log.info("User: " + signInForm.getLogin() + " sign in attempt");
    return signInServiceImpl.signIn(signInForm);
  }
}
