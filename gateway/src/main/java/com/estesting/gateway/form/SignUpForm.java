package com.estesting.gateway.form;

import jakarta.validation.constraints.*;
import lombok.Builder;
import org.json.JSONObject;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.*;


@Builder
public class SignUpForm implements Form {

    @NotBlank(message = EMAIL_CAN_NOT_BE_BLANK)
    @NotNull(message = EMAIL_CAN_NOT_BE_NULL)
    @NotEmpty(message = EMAIL_CAN_NOT_BE_EMPTY)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = THIS_IS_NOT_EMAIL)
    @Email
    private String email;

    @NotBlank(message = USERNAME_CAN_NOT_BE_BLANK)
    @NotNull(message = USERNAME_CAN_NOT_BE_NULL)
    @NotEmpty(message = USERNAME_CAN_NOT_BE_EMPTY)
    private String username;

    @NotBlank(message = PASSWORD_CAN_NOT_BE_BLANK)
    @NotNull(message = PASSWORD_CAN_NOT_BE_NULL)
    @NotEmpty(message = PASSWORD_CAN_NOT_BE_EMPTY)
    private String password;

    @NotNull(message = AGE_CAN_NOT_BE_NULL)
    @Positive(message = AGE_CAN_NOT_BE_NEGATIVE)
    @Min(value = 18, message = AGE_CAN_NOT_BE_SMALLER_THAN_18)
    @Max(value = 100, message = AGE_CAN_NOT_BE_GREATER_THAN_100)
    private Integer age;

    @Override
    public String getFormData() {
        return new JSONObject()
                .put(EMAIL, this.email)
                .put(USERNAME, this.username)
                .put(PASSWORD, this.password)
                .put(AGE, this.age)
                .toString();
    }
}
