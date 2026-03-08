package com.seveneleven.employeepayroll.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.UserAccount;
import com.seveneleven.employeepayroll.payslip.Payslip;
import com.seveneleven.employeepayroll.service.*;
import com.seveneleven.employeepayroll.session.Session;
import com.seveneleven.employeepayroll.util.Validation;
import com.seveneleven.employeepayroll.validexception.ValidationException;
import com.seveneleven.employeepayroll.util.ValidationService;

public class EmployeeApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // ===== Employee Registration =====
        	System.out.print("Enter Employee ID: ");
        	String id = sc.nextLine().trim();
        	ValidationService.validateEmployeeId(id);

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();
            ValidationService.validateEmail(email);

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine().trim();
            ValidationService.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine().trim();

            System.out.print("Create Password: ");
            String password = sc.nextLine().trim();
            ValidationService.validatePassword(password);

            UserAccount account = new UserAccount(username, password);

            Employee emp = new Employee(id, name, email, phone, account);
            emp.persist();

            System.out.println(emp);
            System.out.println("\nData persisted in file: employee_data.txt");


            // ===== Login =====
            System.out.println("\n========EMPLOYEE AUTHENTICATION & LOGIN=========");

            AuthenticationService auth = new AuthenticationService();
            Session session = auth.login(sc);

            if (session == null) {
                System.out.println("Login failed.");
                return;
            }

            System.out.println("\n" + session);

            if (!session.isExpired()) {
                System.out.println("Session active and valid.");
            } else {
                System.out.println("Session expired.");
                return;
            }


            // ===== Payslip Generation =====
            PayrollService payroll = new PayrollService();

            System.out.print("Enter Basic Salary: ");
            double basic = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Month: ");
            String month = sc.nextLine();

            Payslip payslip = payroll.generatePayslip(emp, basic, month);

            System.out.println(payslip);


            // ===== Dashboard Display =====
            DashboardService dashboardService = new DashboardService();

            List<Payslip> payslips = new ArrayList<>();
            payslips.add(payslip);

            dashboardService.showDashboard("EMPLOYEE", payslips);


            // ===== Payslip Download =====
            FileService fileService = new FileService();

            Payslip clonedPayslip = payslip.clone();

            String filename = fileService.savePayslip(clonedPayslip);

            System.out.println("\nPayslip downloaded: " + filename);

        } 
        catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }
    }
}