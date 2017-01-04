package com.knoldus.utils.webservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.libs.Json;
import play.libs.ws.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by sahil on 12/31/16.
 */
public class WSHelper {

    @Inject
    private WSClient ws;

    public CompletionStage<JsonNode> wsGetRequest(String url) {
        WSRequest request = ws.url(url);
        WSRequest complexRequest = request
                .setHeader("headerKey", "headerValue")  //Optional here
                .setRequestTimeout(2000)
                .setQueryParameter("postId", "5")
                .setQueryParameter("id", "25");
        //Http GET request
        CompletionStage<WSResponse> response = complexRequest.get();

        CompletionStage<JsonNode> handledResponse = response
                .handle((result, error) -> {
                    if (error != null) {
                        //handle the exception here via default json
                        JsonNode json = Json.parse("{\"code\" : \"400\", \"message\" : \""+error.getMessage()+"\" }");
                        return json;
                    } else {
                        return result.asJson();
                    }
                });

        return handledResponse;
    }

}
