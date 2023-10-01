package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.ErrorCodes.Password.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.*;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;
import static com.estesting.dependencies.commons.Regex.Password.*;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
  @Getter
  private String email;

  @NotBlank(message = USERNAME_CAN_NOT_BE_BLANK)
  @NotNull(message = USERNAME_CAN_NOT_BE_NULL)
  @NotEmpty(message = USERNAME_CAN_NOT_BE_EMPTY)
  @Size(
      min = 3,
      message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MINIMUM_NUMBER_OF_CHARACTERS_3)
  @Size(
      max = 50,
      message = MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MAXIMUM_NUMBER_OF_CHARACTERS_50)
  @Getter
  private String username;

  @Getter
  @Setter
  @NotBlank(message = PASSWORD_CAN_NOT_BE_BLANK)
  @NotNull(message = PASSWORD_CAN_NOT_BE_NULL)
  @NotEmpty(message = PASSWORD_CAN_NOT_BE_EMPTY)
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
  private String password;

  @Getter
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
