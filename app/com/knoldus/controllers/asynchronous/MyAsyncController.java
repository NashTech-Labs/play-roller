package com.knoldus.controllers.asynchronous;

import com.google.inject.Inject;
import com.knoldus.services.asynchronous.MyAsyncService;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by sahil on 1/4/17.
 */
public class MyAsyncController extends Controller {

    //dependency injection
    private final MyAsyncService serv;
    @Inject
    public MyAsyncController(MyAsyncService serv){
        this.serv = serv;
    }

    //Action 1
    public CompletionStage<Result> renderFileContent(String fileName) {

        return serv.getFileContent(fileName).thenApply(( content ->
                ok("Content of "+fileName+" is -> "+content)
        ));
    }

    //Action 2
    public CompletionStage<Result> calculateDiv(Integer num, Integer den) {
        return fetchResult(num, den)
                .thenApply(res ->
                        ok("Result of divison is " + res))
                .exceptionally(ex ->
                        ok("EXCEPTION : " + ex.getMessage())
                );
    }

    private CompletionStage<Integer> fetchResult(Integer num, Integer den) {
        return CompletableFuture.supplyAsync(() -> num / den);
    }


}
