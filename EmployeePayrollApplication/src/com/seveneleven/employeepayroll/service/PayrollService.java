package com.seveneleven.employeepayroll.service;

import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.payslip.Payslip;

public class PayrollService {

    public Payslip generatePayslip(Employee employee, double basicSalary, String month) {

        return new Payslip(employee, basicSalary, month);
    }
}