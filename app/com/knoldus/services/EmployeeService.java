package com.knoldus.services;

import java.util.List;

import com.knoldus.entities.Employee;

/**
 * Created by knoldus on 27/12/16.
 */
public interface EmployeeService {

  void saveNewEmployee(Employee employee);
  Employee findEmployeeById(int id);
  List<Employee> findAllEmployees();
  int updateEmployeeById(int id);
}
