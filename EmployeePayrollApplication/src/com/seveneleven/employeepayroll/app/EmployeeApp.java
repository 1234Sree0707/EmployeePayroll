package com.seveneleven.employeepayroll.app;

import java.util.Scanner;
import java.io.IOException;

import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.UserAccount;
import com.seveneleven.employeepayroll.model.RegularEmployee;

import com.seveneleven.employeepayroll.util.Validation;
import com.seveneleven.employeepayroll.validexception.ValidationException;
import com.seveneleven.employeepayroll.service.AuthenticationService;
import com.seveneleven.employeepayroll.session.Session;

public class EmployeeApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine().trim();
            Validation.isValidId(id);

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();
            Validation.isValidEmail(email);

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine().trim();
            Validation.isValidPhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine().trim();

            System.out.print("Create Password: ");
            String password = sc.nextLine().trim();
            UserAccount account = new UserAccount(username, password);

            Employee emp = new Employee(id, name, email, phone, account);
            emp.persist();

            System.out.println(emp);
            System.out.println("\nData persisted in file: employee_data.txt");

            System.out.println("\n========EMPLOYEE AUTHENTICATION & LOGIN=========");
            AuthenticationService auth = new AuthenticationService();
            Session session = auth.login();

            if (session != null) {
                System.out.println("\n" + session);

                if (!session.isExpired()) {
                    System.out.println("Session active and valid.");
                } else {
                    System.out.println("Session expired.");
                }
            }

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }
    }
}