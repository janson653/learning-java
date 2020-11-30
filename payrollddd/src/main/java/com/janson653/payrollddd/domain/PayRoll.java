package com.janson653.payrollddd.domain;


import java.time.LocalDate;

public class PayRoll {
    private EmployeeId employeeId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private double salary;

    public PayRoll(EmployeeId employeeId, LocalDate beginDate, LocalDate endDate, double salary) {
        this.employeeId = employeeId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.salary = salary;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getSalary() {
        return salary;
    }
}
