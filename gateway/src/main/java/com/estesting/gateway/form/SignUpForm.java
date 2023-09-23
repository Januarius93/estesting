package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.*;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.validation.constraints.*;
import lombok.Builder;
import org.json.JSONObject;

@Builder
public class SignUpForm implements Form {

  @NotBlank(message = EMAIL_CAN_NOT_BE_BLANK)
  @NotNull(message = EMAIL_CAN_NOT_BE_NULL)
  @NotEmpty(message = EMAIL_CAN_NOT_BE_EMPTY)
  @Pattern(regexp = EMAIL_REGEX, message = THIS_IS_NOT_EMAIL)
  @Email(message = EMAIL_MUST_BE_WELL_FORMATED)
  @Size(
      min = 3,
      message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MINIMUM_NUMBER_OF_CHARACTERS_3)
  @Size(
      max = 50,
      message = MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MAXIMUM_NUMBER_OF_CHARACTERS_50)
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
