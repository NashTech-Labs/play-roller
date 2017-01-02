package com.knoldus.controllers.internationlization;

import akka.actor.ActorSystem;
import com.knoldus.services.Internationalization.International;
import com.knoldus.views.html.internationalization.international;
import com.knoldus.views.html.internationalization.international1;
import play.i18n.Lang;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import play.i18n.Messages;


@Singleton
public class InternationalizationController extends Controller {

    private final ActorSystem actorSystem;
    private final ExecutionContextExecutor exec;
    private final International in;

    @Inject
    public InternationalizationController(ActorSystem actorSystem, ExecutionContextExecutor exec, International inter) {
        this.actorSystem = actorSystem;
        this.exec = exec;
        this.in = inter;
    }


    //Dynamic
    public Result international(String lang) {
        return ok(international.render(lang));
    }

    //For english only
    public Result international1() {
        return ok(in.getMessage());
    }

    //For french only
    public Result international2() {
        ctx().changeLang("fr");
        return ok(international1.render());
    }
}
