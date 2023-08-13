package com.khomeini.ems.service;

import com.khomeini.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(long id);
}
