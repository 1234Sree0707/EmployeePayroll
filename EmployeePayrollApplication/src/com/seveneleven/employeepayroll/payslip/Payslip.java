package com.seveneleven.employeepayroll.payslip;

import com.seveneleven.employeepayroll.model.Employee;

public class Payslip implements Cloneable {

    private Employee employee;
    private SalaryComponents salary;
    private String month;

    public Payslip(Employee employee, double basicSalary, String month) {
        this.employee = employee;
        this.salary = new SalaryComponents(basicSalary);
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public SalaryComponents getSalary() {
        return salary;
    }

    public String getMonth() {
        return month;
    }

    // Clone Payslip
    @Override
    public Payslip clone() {
        try {
            return (Payslip) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Payslip))
            return false;

        Payslip other = (Payslip) obj;

        return this.employee.equals(other.employee)
                && this.month.equals(other.month);
    }

    @Override
    public int hashCode() {
        return employee.hashCode() + month.hashCode();
    }

    @Override
    public String toString() {

        return "\n=========== PAYSLIP ===========" +
                "\nMonth: " + month +
                "\nBasic Salary : " + salary.getBasicSalary() +
                "\nHRA : " + salary.getHra() +
                "\nDA : " + salary.getDa() +
                "\nAllowance : " + salary.getAllowance() +
                "\nPF : " + salary.getPf() +
                "\nTax : " + salary.getTax() +
                "\nNet Pay : " + salary.getNetPay() +
                "\n===============================";
    }
}