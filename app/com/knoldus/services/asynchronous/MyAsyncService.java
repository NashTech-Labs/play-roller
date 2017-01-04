package com.knoldus.services.asynchronous;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import play.libs.concurrent.Timeout;

public class MyAsyncService implements Timeout {

    public CompletionStage<String> getFileContent(String fileName) {

        //this is the place where webservice or DAL is generally called
        return timeout(fetchFileContent(fileName), Duration.ofSeconds(3));
    }

    private CompletionStage<String> fetchFileContent(String fileName) {
        return CompletableFuture.supplyAsync(() ->
                {
                    String result = "File Content"; //The data fetched from database (Predefined for example)
                    return result;
                }
        );
    }

}
