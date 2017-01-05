package com.knoldus.controllers.resultHelpers;

import play.mvc.Controller;
import play.mvc.Result;

public class ResultHelpers extends Controller {

  public Result okType() {
    return ok(com.knoldus.views.html.index.render("Ok Type Result...!!"));
  }

  public Result notFoundType() {
    return ok(views.html.defaultpages.notFound.render("Not found Type Result ....!!", "/notFound"));
  }

  public Result pageNotFoundType() {
    return notFound("<h1>Page not found</h1>").as("text/html");
  }

  public Result badRequestType() {
    return ok(views.html.defaultpages.badRequest
        .render("", "/badRequest", "Bad Request Type Result ....!"));
  }

  public Result internalServerType() {
    return internalServerError("Oops ! Internal Server Error");
  }

  public Result strangeResponseType() {
    return status(420, "Strange Response Type");
  }
}
