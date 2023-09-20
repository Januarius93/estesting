package com.estesting.gateway.form;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;


@Builder
public class SignUpForm implements Form {

  @NotBlank(message = "Email can not be blank")
  @NotNull(message = "Email can not be null")
  @NotEmpty(message = "Email can not be empty")
  @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "This is not email")
  @Email
  private String email;

  @NotBlank(message = "Username can not be blank")
  @NotNull(message = "Username can not be null")
  @NotEmpty(message = "Username can not be empty")
  private String username;

  @NotBlank(message = "Password can not be blank")
  @NotNull(message = "Password can not be null")
  @NotEmpty(message = "Password can not be empty")
  private String password;

  @NotNull(message = "Age can not be null")
  @Positive(message = "Age can not be negative")
  @Min(value = 18, message = "Age can not be smaller that 18")
  @Max(value = 100, message = "Age can not be greater that 100")
  private Integer age;

  @Override
  public String getFormData() {
    return new JSONObject()
        .put("email", this.email)
        .put("username", this.username)
        .put("password", this.password)
        .put("age", this.age)
        .toString();
  }
}
