package com.estesting.gateway.controller.login;

import com.estesting.gateway.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody User user) {
        log.info("login sucess with credentials:" + user.getUsername() + " " + user.getPassword());
        return "login sucess with credentials:" + user.getUsername() + " " + user.getPassword();
    }
}
