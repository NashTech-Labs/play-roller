package com.knoldus.controllers.webservice;

import com.google.inject.Inject;
import com.knoldus.utils.webservice.WSHelper;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;


/**
 * Created by sahil on 1/4/17.
 */
public class WebServiceController extends Controller {

    @Inject
    WSHelper wsHelper;

    public CompletionStage<Result> fetchViaWebService() {
        return wsHelper.wsGetRequest("https://jsonplaceholder.typicode.com/comments")
                .thenApply(jsonNode ->
                        ok(jsonNode.toString())
                );
    }
}