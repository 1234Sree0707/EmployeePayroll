package com.seveneleven.employeepayroll.dashboard;

import java.util.Comparator;
import java.util.List;

import com.seveneleven.employeepayroll.payslip.Payslip;

public class EmployeeDashboard implements Dashboard {

    @Override
    public void display(List<Payslip> payslips) {

        System.out.println("\n===== EMPLOYEE DASHBOARD =====");

        payslips.stream()
                .sorted(Comparator.comparing(Payslip::getMonth).reversed())
                .limit(3)
                .forEach(p -> System.out.println(p));

        double ytd = payslips.stream()
                .mapToDouble(p -> p.getSalary().getNetPay())
                .sum();

        System.out.println("\nYTD Earnings: " + ytd);
    }
}