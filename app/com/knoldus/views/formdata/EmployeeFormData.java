package com.knoldus.views.formdata;

import com.knoldus.models.forms.CTCLevel;
import com.knoldus.models.forms.CTCPointAverage;
import com.knoldus.models.forms.Major;
import com.knoldus.models.forms.Profile;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Employee data form.
 */
public class EmployeeFormData {

    public String name = "";
    public String password = "";
    public List<String> profiles = new ArrayList<String>();
    public String level = "";
    public String ctc = "";
    public List<String> majors = new ArrayList<String>();

    /**
     * Required for form instantiation.
     */
    public EmployeeFormData() {
    }

    /**
     * Creates an initialized form instance. Assumes the passed data is valid.
     *
     * @param name     The name.
     * @param password The password.
     * @param level    The level.
     * @param ctc      The GPA.
     * @param profiles The profiles.
     * @param majors   The majors.
     */
    public EmployeeFormData(String name, String password, CTCLevel level, CTCPointAverage ctc,
                            List<Profile> profiles, List<Major> majors) {
        this.name = name;
        this.password = password;
        this.level = level.getName();
        this.ctc = ctc.getName();
        for (Profile profile : profiles) {
            this.profiles.add(profile.getName());
        }
        for (Major major : majors) {
            this.majors.add(major.getName());
        }
    }

    /**
     * Validates Form<EmployeeFormData>.
     * Called automatically in the controller by bindFromRequest().
     **/
    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<ValidationError>();

        if (name == null || name.length() == 0) {
            errors.add(new ValidationError("name", "No name was given."));
        }

        if (password == null || password.length() == 0) {
            errors.add(new ValidationError("password", "No password was given."));
        } else if (password.length() < 5) {
            errors.add(new ValidationError("password", "Given password is less than five characters."));
        }

        // Profiles are optional, but if supplied must exist in database.
        if (profiles.size() > 0) {
            for (String hobby : profiles) {
                if (Profile.findProfile(hobby) == null) {
                    errors.add(new ValidationError("profiles", "Unknown hobby: " + hobby + "."));
                }
            }
        }

        // Grade Level is required and must exist in database.
        if (level == null || level.length() == 0) {
            errors.add(new ValidationError("level", "No grade level was given."));
        } else if (CTCLevel.findLevel(level) == null) {
            errors.add(new ValidationError("level", "Invalid grade level: " + level + "."));
        }

        // GPA is required and must exist in database.
        if (ctc == null || ctc.length() == 0) {
            errors.add(new ValidationError("ctc", "No ctc was given."));
        } else if (CTCPointAverage.findCTC(ctc) == null) {
            errors.add(new ValidationError("ctc", "Invalid GPA: " + ctc + "."));
        }

        // Majors are optional, but if supplied must exist in database.
        if (majors.size() > 0) {
            for (String major : majors) {
                if (Major.findMajor(major) == null) {
                    errors.add(new ValidationError("majors", "Unknown Major: " + major + "."));
                }
            }
        }

        if (errors.size() > 0) return errors;

        return null;
    }
}
