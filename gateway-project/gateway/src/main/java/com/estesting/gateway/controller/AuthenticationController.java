package com.estesting.gateway.controller;

import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.form.AuthenticationForm;
import com.estesting.gateway.service.AuthenticationService;
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

import static com.estesting.dependencies.commons.Endpoint.AUTHENTICATE_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.USER_ENDPOINT;

@RequestMapping(USER_ENDPOINT)
@Validated
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;
    @SneakyThrows
    @PostMapping(value = AUTHENTICATE_ENDPOINT, consumes = "application/json")
    public @ResponseBody ResponseEntity<String> authenticate(
            @RequestBody @Valid AuthenticationForm authenticationForm, BindingResult bindingResult) {
        log.info(authenticationForm.getLogin() + "authentication attempt");
        return authenticationService.authenticate(authenticationForm);
    }
}
