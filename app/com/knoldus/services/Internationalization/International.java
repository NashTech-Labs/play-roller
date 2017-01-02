package com.knoldus.services.Internationalization;

import play.i18n.Lang;
import play.i18n.MessagesApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class International {

    private final MessagesApi api;

    @Inject
    public International(MessagesApi msg) {
        this.api = msg;
    }

    public String getMessage() {
        return api.get(Lang.forCode("en"), "hello");
    }

}
