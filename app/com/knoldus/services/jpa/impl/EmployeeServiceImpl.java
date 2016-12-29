package com.knoldus.services.jpa.impl;

import com.knoldus.dao.jpa.EmployeeDao;
import com.knoldus.entities.jpa.Employee;
import com.knoldus.services.jpa.EmployeeService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by knoldus on 27/12/16.
 */
@Singleton
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Inject
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void saveNewEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public int updateEmployeeById(int id) {
        return employeeDao.updateById(id);
    }
}
