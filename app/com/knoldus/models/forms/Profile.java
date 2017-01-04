package com.knoldus.models.forms;

import com.knoldus.views.formdata.EmployeeFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private long id;
    private String name;

    public Profile(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Map<String, Boolean> makeProfileMap(EmployeeFormData employee) {
        Map<String, Boolean> profileMap = new HashMap<String, Boolean>();
        for (Profile profile : allProfiles) {
            profileMap.put(profile.getName(),
                    (employee != null && employee.profiles.contains(profile.getName())));
        }
        return profileMap;
    }

    public static Profile findProfile(String profileName) {
        for (Profile profile : allProfiles) {
            if (profileName.equals(profile.getName())) {
                return profile;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[Profile %s]", this.name);
    }

    /**
     * Fake a database of profiles.
     */
    private static List<Profile> allProfiles = new ArrayList<Profile>();

    /** Instantiate the fake database of profiles. */
    static {
        allProfiles.add(new Profile(1L, "UI"));
        allProfiles.add(new Profile(2L, "DataBase"));
        allProfiles.add(new Profile(3L, "DevOps"));
        allProfiles.add(new Profile(4L, "Developer"));
    }

}
