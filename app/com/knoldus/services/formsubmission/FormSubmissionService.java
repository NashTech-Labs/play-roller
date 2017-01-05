package com.knoldus.services.formsubmission;

import com.knoldus.models.formsubmission.User;

/**
 * Created by sahil on 1/5/17.
 */
public class FormSubmissionService {

    public Boolean validateCredentials(User user) {
        if (user.getPassword() == "workshop") {
            return true;
        } else return false;
    }
}
