package com.janson653.payrollddd.infrastructure.repository;

import com.janson653.payrollddd.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findByType(Integer employeeType);
}
