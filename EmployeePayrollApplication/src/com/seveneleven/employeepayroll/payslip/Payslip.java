package com.seveneleven.employeepayroll.payslip;

import com.seveneleven.employeepayroll.model.Employee;

public class Payslip {

    private Employee employee;
    private SalaryComponents salaryComponents;
    private String month;

    public Payslip(Employee employee, double basicSalary, String month) {
        this.employee = employee;
        this.salaryComponents = new SalaryComponents(basicSalary);
        this.month = month;
    }

    @Override
    public String toString() {

        return "\n=========== PAYSLIP ===========" +
                "\nMonth: " + month +
                "\nEmployee: " + employee +
                "\n--------------------------------" +
                "\nBasic Salary : " + salaryComponents.getBasicSalary() +
                "\nHRA          : " + salaryComponents.getHra() +
                "\nDA           : " + salaryComponents.getDa() +
                "\nAllowance    : " + salaryComponents.getAllowance() +
                "\n--------------------------------" +
                "\nGross Salary : " + salaryComponents.getGrossSalary() +
                "\nPF Deduction : " + salaryComponents.getPf() +
                "\nTax Deduction: " + salaryComponents.getTax() +
                "\n--------------------------------" +
                "\nNET PAY      : " + salaryComponents.getNetPay() +
                "\n================================";
    }
}