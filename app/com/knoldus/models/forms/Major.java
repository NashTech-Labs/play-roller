package com.knoldus.models.forms;

import com.knoldus.views.formdata.EmployeeFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Major {
    private long id;
    private String name;

    public Major(long id, String name) {
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

    public static Map<String, Boolean> makeMajorMap(EmployeeFormData employee) {
        Map<String, Boolean> majorMap = new HashMap<String, Boolean>();
        for (Major major : allMajors) {
            majorMap.put(major.getName(),
                    (employee == null) ? false : employee.majors.contains(major.getName()));
        }
        return majorMap;
    }

    /**
     * Return the Major instance in the database with name 'MajorName' or null if not found.
     *
     * @param majorName The Major name.
     * @return The Major instance, or null.
     */
    public static Major findMajor(String majorName) {
        for (Major major : allMajors) {
            if (majorName.equals(major.getName())) {
                return major;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[Major %s]", this.name);
    }

    /**
     * Fake a database of majors.
     */
    private static List<Major> allMajors = new ArrayList<Major>();

    /** Instantiate the fake database of Majors. */
    static {
        allMajors.add(new Major(1L, "Data Science"));
        allMajors.add(new Major(2L, "IT"));
        allMajors.add(new Major(3L, "Physics"));
        allMajors.add(new Major(4L, "Mathematics"));
    }

}
