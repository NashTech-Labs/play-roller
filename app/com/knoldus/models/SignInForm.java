package com.knoldus.models;

import play.data.validation.Constraints;

public class SignInForm {

  @Constraints.Required(message = "validation.required")
/*  @Constraints.Email(message = "validation.email")*/
  @Constraints.MaxLength(value = 100, message = "validation.maxLength") private String email;

  @Constraints.Required(message = "validation.required")
  @Constraints.MaxLength(value = 40, message = "validation.maxLength") private String password;

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public String validate() {
    if (email == null || password == null) {
      return "Invalid email or password";
    }
    return null;
  }

}
