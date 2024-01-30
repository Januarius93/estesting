package com.estesting.gateway.form;

import lombok.Getter;
import org.json.JSONObject;

import static com.estesting.dependencies.commons.FormRequestAttributes.*;

@Getter
public class AuthenticationForm implements Form {
    private String login;
    private String password;

    @Override
    public JSONObject getFormData() {
        return new JSONObject().put(LOGIN, this.login).put(PASSWORD, this.password);
    }
}
