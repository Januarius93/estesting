package com.estesting.gateway.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.json.JSONObject;

import static com.estesting.dependencies.commons.ErrorCodes.*;

@Builder
public class SignInForm implements Form {
    @NotBlank(message = EMAIL_CAN_NOT_BE_BLANK)
    @NotEmpty(message = EMAIL_CAN_NOT_BE_EMPTY)
    @NotNull(message = EMAIL_IS_MANDATORY)
    private String login;

    @NotBlank(message = PASSWORD_CAN_NOT_BE_BLANK)
    @NotEmpty(message = PASSWORD_CAN_NOT_BE_EMPTY)
    @NotNull(message = PASSWORD_IS_MANDATORY)
    private String password;

    @Override
    public String getFormData() {
        return new JSONObject().put("login", this.login).put("password", this.password).toString();
    }
}
