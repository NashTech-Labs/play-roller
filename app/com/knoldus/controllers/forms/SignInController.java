package com.knoldus.controllers.forms;

import com.knoldus.models.SignInForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class SignInController extends Controller {

  public Result doSignIn() {

    Form<SignInForm> signInForm = Form.form(SignInForm.class);
    return ok(com.knoldus.views.html.signin.render(signInForm));
  }

  public Result signIn() {
    Form<SignInForm> signInForm = Form.form(SignInForm.class).bindFromRequest();
    if (signInForm.hasErrors()) {
      flash("error", "Hey your Credentials are in-correct !!!!");
      return badRequest(com.knoldus.views.html.signin.render(signInForm));
    } else {
      flash("success", "Hey you are Signed In !!!!");
      return ok(com.knoldus.views.html.signin.render(signInForm));
    }
  }
}
