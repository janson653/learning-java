package com.janson653.payrollddd.infrastructure.repository;

import com.janson653.payrollddd.domain.Employee;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> findByType(Integer employeeType) {
        System.out.println("mock");
        return null;
    }
}
