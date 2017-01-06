package com.knoldus.controller;

import com.knoldus.controllers.jpa.EmployeeController;
import com.knoldus.entities.jpa.Department;
import com.knoldus.entities.jpa.Employee;
import com.knoldus.services.jpa.EmployeeService;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static play.test.Helpers.contentAsString;

/**
 * Created by knoldus on 6/1/17.
 */

public class EmployeeControllerTest extends WithApplication {

    @Test
    public void testAddNewEmployee() {
        Department department = new Department();
        department.setName("Devops");

        Employee employee = new Employee();
        employee.setName("James");
        employee.setAge(27);
        employee.setSex("Male");
        employee.setDepartment(department);

        EmployeeService employeeService = mock(EmployeeService.class);
        doNothing().when(employeeService).saveNewEmployee(employee);

        when(employeeService.findAllEmployees()).thenReturn(Arrays.asList(employee));

        when(employeeService.findEmployeeById(100)).thenReturn(employee);

        Result result = new EmployeeController(employeeService).addNewEmployee();

        assertThat(result.status(), is(equalTo(Http.Status.OK)));
        assertThat(contentAsString(result), is(equalTo("Add New Employee Successfully")));
    }
}
