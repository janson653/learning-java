package com.janson.payrollddd;

import com.janson.payrollddd.domain.EmployeeId;
import com.janson.payrollddd.domain.HourlyEmployee;
import com.janson.payrollddd.domain.PayRoll;
import com.janson.payrollddd.domain.SettlementPeriod;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class HourlyEmployeeTest {
    @BeforeAll
    public static void setUp() {

    }

    @Test
    public void should_cal_payroll() {
        // given
        EmployeeId employeeId = new EmployeeId("emp-001");
        HourlyEmployee hourlyEmployee = new HourlyEmployee(employeeId, "zhangsan",
                0,
                LocalDate.of(2019, 1, 1),
                100
        );
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 13), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 14), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 15), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 16), 9));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 17), 8));
        SettlementPeriod settlementPeriod = new SettlementPeriod(LocalDate.of(2020, 4, 13),
                LocalDate.of(2020, 4, 17));

        // when
        PayRoll payRoll = hourlyEmployee.calPayRoll(settlementPeriod);

        // verify
        Assert.notNull(payRoll, "not null");
    }

    @Test
    public void should_cal_payroll_overtime_correct() {
        // given
        EmployeeId employeeId = new EmployeeId("emp-001");
        HourlyEmployee hourlyEmployee = new HourlyEmployee(employeeId, "zhangsan",
                0,
                LocalDate.of(2019, 1, 1),
                100
        );
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 13), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 14), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 15), 8));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 16), 9));
        hourlyEmployee.submitTimeCard(new HourlyEmployee.TimeCard(LocalDate.of(2020, 4, 17), 8));
        SettlementPeriod settlementPeriod = new SettlementPeriod(LocalDate.of(2020, 4, 13),
                LocalDate.of(2020, 4, 17));

        // when
        PayRoll payRoll = hourlyEmployee.calPayRoll(settlementPeriod);

        // verify
        Assert.notNull(payRoll, "not null");
        Assert.isTrue(4150 == payRoll.getSalary());
    }
}
