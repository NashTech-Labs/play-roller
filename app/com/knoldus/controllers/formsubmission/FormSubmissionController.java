package com.knoldus.controllers.formsubmission;

import com.google.inject.Inject;
import com.knoldus.controllers.asynchronous.routes;
import com.knoldus.models.formsubmission.User;
import com.knoldus.services.formsubmission.FormSubmissionService;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by sahil on 1/5/17.
 */
public class FormSubmissionController extends Controller {

    private final FormFactory formFactory;
    private final FormSubmissionService service;

    @Inject
    public FormSubmissionController(FormFactory formFactory, FormSubmissionService serv) {
        this.formFactory = formFactory;
        this.service = serv;
    }

    public Result login() {

        if (session().containsKey("email")) {
            return ok(com.knoldus.views.html.formsubmission.successfulLogin.render(session("email")));
        }
        Form<User> userForm = formFactory.form(User.class).fill(new User("your@email.com", "password"));
        return ok(com.knoldus.views.html.formsubmission.login.render(userForm));
    }

    public Result postLogin() {

        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if (userForm.hasErrors()) {
            flash("error", userForm.globalError().message());
            return badRequest(com.knoldus.views.html.formsubmission.login.render(userForm));
        }
        else if (!service.validateCredentials(userForm.get())) {
            flash("error", "Credentials dont match");
            return badRequest(com.knoldus.views.html.formsubmission.login.render(userForm));
        }
        else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", userForm.get().getEmail());
            return ok(com.knoldus.views.html.formsubmission.successfulLogin.render(session("email")));
        }
    }

    public Result logout() {

        flash("out", "Logout Successsfull");
        session().clear();
        return redirect(com.knoldus.controllers.formsubmission.routes.FormSubmissionController.login());
    }

}
