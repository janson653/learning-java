package com.janson653.payrollddd.application;

import com.janson653.payrollddd.domain.PayRoll;
import com.janson653.payrollddd.domain.PayrollCalService;

import java.util.List;

/**
 * 支付服务
 */
public class PayAppService {
    private PayrollCalService payrollCalService;

    public void pay() {
        // 计算所有员工工资
        List<PayRoll> payRolls = payrollCalService.calPayRoll();
        // 支付工资
        paySalary(payRolls);
    }

    private void paySalary(List<PayRoll> payRolls) {

    }
}
