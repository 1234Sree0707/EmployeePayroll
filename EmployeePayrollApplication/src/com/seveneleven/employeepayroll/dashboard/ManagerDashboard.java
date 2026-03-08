package com.seveneleven.employeepayroll.dashboard;

import java.util.List;
import com.seveneleven.employeepayroll.payslip.Payslip;

public class ManagerDashboard implements Dashboard {

    @Override
    public void display(List<Payslip> payslips) {

        System.out.println("\n===== MANAGER DASHBOARD =====");

        System.out.println("Total Payslips Generated: " + payslips.size());

        double payroll = payslips.stream()
                .mapToDouble(p -> p.getSalary().getNetPay())
                .sum();

        System.out.println("Total Payroll Expense: " + payroll);
    }
}