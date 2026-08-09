package com.aruna.employeemanagement.repository;

import com.aruna.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrDesignationContainingIgnoreCase(
            String firstName,
            String lastName,
            String email,
            String department,
            String designation
    );
}
