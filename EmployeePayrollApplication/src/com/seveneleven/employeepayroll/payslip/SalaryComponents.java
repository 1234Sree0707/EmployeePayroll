package com.seveneleven.employeepayroll.payslip;

import java.util.stream.Stream;

public class SalaryComponents {

    private double basicSalary;
    private double hra;
    private double da;
    private double allowance;

    private double pf;
    private double tax;

    private double grossSalary;
    private double netPay;

    public SalaryComponents(double basicSalary) {

        this.basicSalary = basicSalary;

        this.hra = basicSalary * 0.20;
        this.da = basicSalary * 0.10;
        this.allowance = basicSalary * 0.05;

        this.grossSalary = Stream.of(basicSalary, hra, da, allowance)
                                 .mapToDouble(Double::doubleValue)
                                 .sum();

        this.pf = basicSalary * 0.12;
        this.tax = grossSalary * 0.10;

        this.netPay = grossSalary - (pf + tax);
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetPay() {
        return netPay;
    }

    public double getPf() {
        return pf;
    }

    public double getTax() {
        return tax;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public double getDa() {
        return da;
    }

    public double getAllowance() {
        return allowance;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> feature/UC4
