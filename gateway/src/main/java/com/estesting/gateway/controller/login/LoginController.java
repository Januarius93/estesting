package com.estesting.gateway.controller.login;


import com.estesting.gateway.model.Credentials;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @SneakyThrows
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody Credentials credentials) {
        log.info("login sucess with credentials:" + credentials.getUsername() + " " + credentials.getPassword());
        return new JSONObject().put("message","login success with credentials: "+ credentials.getUsername() + " " + credentials.getPassword()).toString();
    }
}
