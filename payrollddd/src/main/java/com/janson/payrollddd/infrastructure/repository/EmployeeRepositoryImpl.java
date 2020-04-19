package com.janson.payrollddd.infrastructure.repository;

import com.janson.payrollddd.domain.Employee;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> findByType(Integer employeeType) {
        System.out.println("mock");
        return null;
    }
}
