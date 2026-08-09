package com.aruna.employeemanagement.service;

import com.aruna.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> search(String keyword);

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
