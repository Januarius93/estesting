package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.LOGIN_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.LOGIN_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.LOGIN_IS_MANDATORY;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_50;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_10;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_3;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_IS_MANDATORY;
import static com.estesting.dependencies.commons.FormRequestAttributes.LOGIN;
import static com.estesting.dependencies.commons.FormRequestAttributes.PASSWORD;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class SignInForm implements Form {

  @NotBlank(message = LOGIN_CAN_NOT_BE_BLANK)
  @NotEmpty(message = LOGIN_CAN_NOT_BE_EMPTY)
  @NotNull(message = LOGIN_IS_MANDATORY)
  @Size(
      min = 3,
      message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3)
  @Size(
      max = 50,
      message = MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MAXIMUM_NUMBER_OF_CHARACTERS_50)
  private String login;

  @NotBlank(message = PASSWORD_CAN_NOT_BE_BLANK)
  @NotEmpty(message = PASSWORD_CAN_NOT_BE_EMPTY)
  @NotNull(message = PASSWORD_IS_MANDATORY)
  @Size(
      min = 10,
      message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
  @Size(
      max = 200,
      message =
          MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD)
  private String password;

  @Override
  public JSONObject getFormData() {
    return new JSONObject().put(LOGIN, this.login).put(PASSWORD, this.password);
  }
}
