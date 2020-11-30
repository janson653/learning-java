package com.janson653.payrollddd.domain;

import com.janson653.payrollddd.infrastructure.repository.EmployeeRepository;
import com.janson653.payrollddd.infrastructure.repository.EmployeeRepositoryImpl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PayrollCalService {
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    public List<PayRoll> calPayRoll() {
        List<PayRoll> payRolls = new LinkedList<>();
        LocalDate now = LocalDate.now();
        // 是支付日
        boolean payDay = isHourlyEmployeePayDay(now);
        if (payDay) {
            SettlementPeriod settlementPeriod = SettlementPeriod.calSettlementPeriod(now);
            List<Employee> employees = employeeRepository.findByType(1);
            employees.forEach(item->  {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) item;
                PayRoll payRoll = hourlyEmployee.calPayRoll(settlementPeriod);
                payRolls.add(payRoll);
            });
        }
        return payRolls;
    }

    private boolean isHourlyEmployeePayDay(LocalDate now) {
        // todo
        return false;
    }

}
