package com.estesting.gateway.controller.login;
import com.estesting.gateway.form.LoginForm;
import com.estesting.gateway.service.LoginService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @SneakyThrows
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Object> login(@RequestBody @Valid LoginForm loginForm ) {
        loginService.login(loginForm);
        return new ResponseEntity<>("user: "+ loginForm.getLogin() + " login" , HttpStatus.OK);
    }
}
