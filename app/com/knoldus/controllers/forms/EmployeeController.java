package com.knoldus.controllers.forms;

import com.knoldus.models.forms.*;
import com.knoldus.views.formdata.EmployeeFormData;
import com.knoldus.views.html.forms.index;
import controllers.WebJarAssets;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by knoldus on 4/1/17.
 */
public class EmployeeController extends Controller {

    @Inject
    private WebJarAssets webJarAssets;

    public Result getIndex(long id) {
        EmployeeFormData employeeData =
                (id == 0) ? new EmployeeFormData() : Employee.makeEmployeeFormData(id);
        Form<EmployeeFormData> formData = Form.form(EmployeeFormData.class).fill(employeeData);
        return ok(index.render(formData, Profile.makeProfileMap(employeeData), CTCLevel.getNameList(),
                CTCPointAverage.makeCTCMap(employeeData), Major.makeMajorMap(employeeData), webJarAssets));
    }

    public Result postIndex() {

        // Get the submitted form data from the request object, and run validation.
        Form<EmployeeFormData> formData = Form.form(EmployeeFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            // Don't call formData.get() when there are errors, pass 'null' to helpers instead.
            flash("error", " Your form has Errors. Please correct errors");
            return badRequest(index.render(formData, Profile.makeProfileMap(null), CTCLevel.getNameList(),
                    CTCPointAverage.makeCTCMap(null), Major.makeMajorMap(null), webJarAssets));
        } else {
            // Convert the formData into a Employee model instance.
            Employee employee = Employee.makeInstance(formData.get());
            flash("success",
                    "Welcome !  " + employee.getName() + ", you have successfully Registered Yourself.");
            return ok(index
                    .render(formData, Profile.makeProfileMap(formData.get()), CTCLevel.getNameList(),
                            CTCPointAverage.makeCTCMap(formData.get()), Major.makeMajorMap(formData.get()), webJarAssets));
        }
    }
}
