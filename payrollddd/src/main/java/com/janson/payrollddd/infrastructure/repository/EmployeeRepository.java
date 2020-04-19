package com.janson.payrollddd.infrastructure.repository;

import com.janson.payrollddd.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findByType(Integer employeeType);
}
