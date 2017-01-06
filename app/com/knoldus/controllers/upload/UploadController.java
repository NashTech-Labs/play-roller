package com.knoldus.controllers.upload;

import java.io.File;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class UploadController extends Controller {

  public Result upload() {
    return ok(com.knoldus.views.html.upload.render());
  }

  public Result doUpload() {
    Http.MultipartFormData<File> body = request().body().asMultipartFormData();
    Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
    String fileName = picture.getFilename();
    String contentType = picture.getContentType();
    File file = picture.getFile();
    flash("success",
        "Uploaded fileName:   " + fileName + "  of type : " + contentType + " on path  : " + file);
    return ok(com.knoldus.views.html.upload.render());

  }

}
