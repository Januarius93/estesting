package controller.login;

import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        log.info("login sucess with credentials:" + username + " " + password);
        return "login sucess with credentials:" + username + " " + password;
    }
}
