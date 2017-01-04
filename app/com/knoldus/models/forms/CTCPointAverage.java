package com.knoldus.models.forms;

import com.knoldus.views.formdata.EmployeeFormData;

import java.util.*;

public class CTCPointAverage {
    private long id;
    private String name;

    public CTCPointAverage(long id, String name) {
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

    public static Map<String, Boolean> makeCTCMap(EmployeeFormData employee) {
        Map<String, Boolean> ctcMap = new TreeMap<String, Boolean>();
        for (CTCPointAverage gpa : allGPAs) {
            ctcMap.put(gpa.getName(), (employee == null) ?
                    false :
                    (employee.ctc != null && employee.ctc.equals(gpa.getName())));
        }
        return ctcMap;
    }

    public static List<String> getCTCList() {
        String[] nameArray = {"3 Lakhs", "3.0 - 5.9", "6.0 - 8.9", "9.0 - 15"};
        return Arrays.asList(nameArray);
    }

    public static CTCPointAverage findCTC(String gpaName) {
        for (CTCPointAverage gpa : allGPAs) {
            if (gpaName.equals(gpa.getName())) {
                return gpa;
            }
        }
        return null;
    }

    public static CTCPointAverage getDefaultCTC() {
        return findCTC("4.0");
    }

    @Override
    public String toString() {
        return String.format("[GPA %s]", this.name);
    }

    /**
     * Fake a database of CTCs.
     */
    private static List<CTCPointAverage> allGPAs = new ArrayList<CTCPointAverage>();

    /** Instantiate the fake database of CTCs */
    static {
        allGPAs.add(new CTCPointAverage(1L, "3 Lakhs"));
        allGPAs.add(new CTCPointAverage(2L, "3.0 - 5.9"));
        allGPAs.add(new CTCPointAverage(3L, "6.0 - 8.9"));
        allGPAs.add(new CTCPointAverage(4L, "9.0 - 15"));

    }

}
