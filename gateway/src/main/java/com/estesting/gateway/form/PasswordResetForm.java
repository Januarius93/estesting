package com.estesting.gateway.form;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.EMAIL;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
public class PasswordResetForm implements Form {
  @NotBlank(message = EMAIL_CAN_NOT_BE_BLANK)
  @NotNull(message = EMAIL_CAN_NOT_BE_NULL)
  @NotEmpty(message = EMAIL_CAN_NOT_BE_EMPTY)
  @Pattern(regexp = EMAIL_REGEX, message = THIS_IS_NOT_EMAIL)
  @Email(message = EMAIL_MUST_BE_WELL_FORMATED)
  @Setter
  private String email;

  @Override
  public String getFormData() {
    return new JSONObject().put(EMAIL, this.email).toString();
  }
}
