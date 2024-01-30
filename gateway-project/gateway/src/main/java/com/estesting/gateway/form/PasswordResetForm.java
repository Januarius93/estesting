package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_BLANK;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_EMPTY;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_CAN_NOT_BE_NULL;
import static com.estesting.dependencies.commons.ErrorCodes.EMAIL_MUST_BE_WELL_FORMATED;
import static com.estesting.dependencies.commons.ErrorCodes.THIS_IS_NOT_EMAIL;
import static com.estesting.dependencies.commons.FormRequestAttributes.EMAIL;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Setter
@Getter
public class PasswordResetForm implements Form {

  @NotBlank(message = EMAIL_CAN_NOT_BE_BLANK)
  @NotNull(message = EMAIL_CAN_NOT_BE_NULL)
  @NotEmpty(message = EMAIL_CAN_NOT_BE_EMPTY)
  @Pattern(regexp = EMAIL_REGEX, message = THIS_IS_NOT_EMAIL)
  @Email(message = EMAIL_MUST_BE_WELL_FORMATED)
  private String email;

  @Override
  public JSONObject getFormData() {
    return new JSONObject().put(EMAIL, this.email);
  }
}
