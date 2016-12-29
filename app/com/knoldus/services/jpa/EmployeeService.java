package com.knoldus.services.jpa;

import com.knoldus.entities.jpa.Employee;

import java.util.List;

/**
 * Created by knoldus on 27/12/16.
 */
public interface EmployeeService {

    void saveNewEmployee(Employee employee);

    Employee findEmployeeById(int id);

    List<Employee> findAllEmployees();

    int updateEmployeeById(int id);
}
