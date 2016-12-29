package com.knoldus.dao.jpa;

import com.knoldus.entities.jpa.Employee;

import java.util.List;

/**
 * Created by knoldus on 27/12/16.
 */
public interface EmployeeDao {

  void save(Employee t);

  Employee findById(int id);

  List<Employee> findAll();

  int updateById(int id);
}
