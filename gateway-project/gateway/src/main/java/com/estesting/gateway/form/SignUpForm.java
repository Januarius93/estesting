package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.AGE_CAN_NOT_BE_GREATER_THAN_100;
import static com.estesting.dependencies.commons.ErrorCodes.AGE_CAN_NOT_BE_NEGATIVE;
import static com.estesting.dependencies.commons.ErrorCodes.AGE_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.ErrorCodes.AGE_CAN_NOT_BE_SMALLER_THAN_18;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_MUST_BE_WELL_FORMATED;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_50;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_10;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_3;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.PASSWORD_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_0_9;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_A_Z;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_NO_WHITESPACE;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_SPECIAL_CHARS;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_a_z;
import static com.estesting.dependencies.commons.ErrorCodes.THIS_IS_NOT_EMAIL;
import static com.estesting.dependencies.commons.ErrorCodes.USERNAME_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.USERNAME_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.USERNAME_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.FormRequestAttributes.AGE;
import static com.estesting.dependencies.commons.FormRequestAttributes.EMAIL;
import static com.estesting.dependencies.commons.FormRequestAttributes.PASSWORD;
import static com.estesting.dependencies.commons.FormRequestAttributes.USERNAME;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_0_9;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_A_Z;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_NO_WHITESPACE;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_SPECIAL_CHARS;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_a_z;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
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
  @Size(
      min = 3,
      message = MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MINIMUM_NUMBER_OF_CHARACTERS_3)
  @Size(
      max = 50,
      message = MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MAXIMUM_NUMBER_OF_CHARACTERS_50)
  private String username;

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

  @NotNull(message = AGE_CAN_NOT_BE_NULL)
  @Positive(message = AGE_CAN_NOT_BE_NEGATIVE)
  @Min(value = 18, message = AGE_CAN_NOT_BE_SMALLER_THAN_18)
  @Max(value = 100, message = AGE_CAN_NOT_BE_GREATER_THAN_100)
  private Integer age;

  @Override
  public JSONObject getFormData() {
    return new JSONObject()
        .put(EMAIL, this.email)
        .put(USERNAME, this.username)
        .put(PASSWORD, this.password)
        .put(AGE, this.age);
  }
}
