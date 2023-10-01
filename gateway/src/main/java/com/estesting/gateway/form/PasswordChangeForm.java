package com.estesting.gateway.form;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.ErrorCodes.Password.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.PASSWORD;
import static com.estesting.dependencies.commons.Regex.Password.*;


public class PasswordChangeForm {
    @Getter
    @Setter
    @NotBlank(message = NEW_PASSWORD_CAN_NOT_BE_BLANK)
    @NotNull(message = NEW_PASSWORD_CAN_NOT_BE_NULL)
    @NotEmpty(message = NEW_PASSWORD_CAN_NOT_BE_EMPTY)
    @Size(
            min = 10,
            message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
    @Size(
            max = 200,
            message =
                    MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD)
    @Pattern.List({
            @Pattern(regexp = MUST_CONTAINS_0_9, message = PASSWORD_MUST_CONTAINS_0_9),
            @Pattern(regexp = MUST_CONTAINS_a_z, message = PASSWORD_MUST_CONTAINS_a_z),
            @Pattern(regexp = MUST_CONTAINS_A_Z, message = PASSWORD_MUST_CONTAINS_A_Z),
            @Pattern(
                    regexp = MUST_CONTAINS_SPECIAL_CHARS,
                    message = PASSWORD_MUST_CONTAINS_SPECIAL_CHARS),
            @Pattern(regexp = MUST_CONTAINS_NO_WHITESPACE, message = PASSWORD_MUST_CONTAINS_NO_WHITESPACE)
    })
    private String newPassword;
}
