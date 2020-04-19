package com.janson.payrollddd.domain;


import java.time.LocalDate;

public abstract class Employee {
    private final EmployeeId employId;
    private final String name;
    private final Integer sex;
    private final LocalDate onboardDate;

    public Employee(EmployeeId employId, String name, Integer sex, LocalDate onboardDate) {
        this.employId = employId;
        this.name = name;
        this.sex = sex;
        this.onboardDate = onboardDate;
    }

    public EmployeeId getEmployId() {
        return employId;
    }

    public String getName() {
        return name;
    }

    public Integer getSex() {
        return sex;
    }

    public LocalDate getOnboardDate() {
        return onboardDate;
    }

    public abstract PayRoll calPayRoll(SettlementPeriod settlementPeriod);
}
