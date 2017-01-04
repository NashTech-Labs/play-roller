package com.knoldus.models.forms;

import com.knoldus.views.formdata.EmployeeFormData;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private long id;
    private String name;
    private String password;
    private List<Profile> profiles = new ArrayList<Profile>();
    private CTCLevel level;
    private CTCPointAverage gpa;
    private List<Major> majors = new ArrayList<Major>();

    public Employee() {
    }

    /**
     * Constructor for Employee
     *
     * @param id
     * @param name
     * @param password
     * @param level
     * @param gpa
     */
    public Employee(long id, String name, String password, CTCLevel level, CTCPointAverage gpa) {
        this.setId(id);
        this.name = name;
        this.password = password;
        this.level = level;
        this.gpa = gpa;
    }

    /**
     * @return the id
     */
    private long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    private void setId(long id) {
        this.id = id;
    }

    public boolean hasProfile(String profileName) {
        for (Profile profile : this.profiles) {
            if (profileName.equals(profile.getName())) return true;
        }
        return false;
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile);
    }

    public boolean hasMajor(String majorName) {
        for (Major major : this.getMajors()) {
            if (majorName.equals(major.getName())) return true;
        }
        return false;
    }

    public String toString() {
        return String.format(
                "[Employee name: '%s' Password: '%s' Profiles: %s Grade Level: %s GPA: %s Majors: %s]",
                this.getName(), this.getPassword(), this.profiles, this.level, this.gpa, this.getMajors());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the level
     */
    public CTCLevel getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(CTCLevel level) {
        this.level = level;
    }

    /**
     * @return the ctc
     */
    public CTCPointAverage getGpa() {
        return gpa;
    }

    /**
     * @param gpa the ctc to set
     */
    public void setGpa(CTCPointAverage gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the majors
     */
    public List<Major> getMajors() {
        return majors;
    }

    /**
     * @param majors the majors to set
     */
    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public void addMajor(Major major) {
        this.majors.add(major);
    }

    public static EmployeeFormData makeEmployeeFormData(long id) {
        for (Employee employee : allEmployees) {
            if (employee.getId() == id) {
                return new EmployeeFormData(employee.name, employee.password, employee.level, employee.gpa,
                        employee.profiles, employee.majors);
            }
        }
        throw new RuntimeException("Couldn't find employee");
    }

    public static Employee makeInstance(EmployeeFormData formData) {
        Employee employee = new Employee();
        employee.name = formData.name;
        employee.password = formData.password;
        for (String profile : formData.profiles) {
            employee.profiles.add(Profile.findProfile(profile));
        }
        employee.level = CTCLevel.findLevel(formData.level);
        employee.gpa = CTCPointAverage.findCTC(formData.ctc);
        for (String major : formData.majors) {
            employee.majors.add(Major.findMajor(major));
        }
        return employee;
    }

    /**
     * Fake a database of employee.
     */
    private static List<Employee> allEmployees = new ArrayList<Employee>();

}
