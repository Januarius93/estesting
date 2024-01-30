package com.estesting.gateway.controller.signup;

import com.estesting.gateway.form.AuthenticationForm;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.service.AuthenticationService;
import com.estesting.gateway.service.SignUpServiceImpl;
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

import static com.estesting.dependencies.commons.Endpoint.*;

@RequestMapping(USER_ENDPOINT)
@Validated
@RestController
@RequiredArgsConstructor
public class SignUpController {

  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
  @Autowired
  private SignUpServiceImpl signUpService;

  @SneakyThrows
  @PutMapping(value = SIGN_UP_ENDPOINT, consumes = "application/json")
  public @ResponseBody ResponseEntity<String> signUp(
      @RequestBody @Valid SignUpForm signUpForm, BindingResult bindingResult) {
    log.info("Sign up attempt");
    return signUpService.createUser(signUpForm);
  }
}
