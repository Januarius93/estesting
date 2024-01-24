package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_10;
import static com.estesting.dependencies.commons.ErrorCodes.MINIMUM_NUMBER_OF_CHARACTERS_FOR_;
import static com.estesting.dependencies.commons.ErrorCodes.NEW_PASSWORD_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.NEW_PASSWORD_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.NEW_PASSWORD_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_0_9;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_A_Z;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_NO_WHITESPACE;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_SPECIAL_CHARS;
import static com.estesting.dependencies.commons.ErrorCodes.Password.PASSWORD_MUST_CONTAINS_a_z;
import static com.estesting.dependencies.commons.FormRequestAttributes.EMAIL;
import static com.estesting.dependencies.commons.FormRequestAttributes.OLD_PASSWORD;
import static com.estesting.dependencies.commons.FormRequestAttributes.PASSWORD;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_0_9;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_A_Z;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_NO_WHITESPACE;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_SPECIAL_CHARS;
import static com.estesting.dependencies.commons.Regex.Password.MUST_CONTAINS_a_z;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Builder
public class PasswordChangeForm implements Form {

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
  private String password;

  @Getter
  @Setter
  private String oldPassword;

  @Getter
  @Setter
  private String email;

  @Override
  public JSONObject getFormData() {
    return new JSONObject().put(PASSWORD, this.password).put(OLD_PASSWORD, this.oldPassword)
        .put(EMAIL, this.email);
  }
}
