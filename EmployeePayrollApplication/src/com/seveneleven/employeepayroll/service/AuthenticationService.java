package com.seveneleven.employeepayroll.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.seveneleven.employeepayroll.model.*;
import com.seveneleven.employeepayroll.session.Session;
import com.seveneleven.employeepayroll.util.PasswordUtil;

public class AuthenticationService {

    private final Map<String, User> users = new HashMap<>();

    public AuthenticationService() {
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("employee_data.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty())
                    continue;

                String[] data = line.split(",");

                if (data.length < 6) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String id = data[0].trim();
                String name = data[1].trim();
                String email = data[2].trim();
                String phone = data[3].trim();
                String username = data[4].trim();
                String passwordHash = data[5].trim();

                RegularEmployee emp = new RegularEmployee(username, "temp");

                emp.setPasswordHash(passwordHash);

                users.put(username, emp);
            }

        } catch (IOException e) {
            System.out.println("Error loading users from file.");
            e.printStackTrace();
        }
    }

    public Session login(Scanner sc) {

        System.out.print("Enter Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        User user = users.get(username);

        // If username does not exist
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }

        if (user.authenticate(username, password)) {

            System.out.println("\nLogin Successful!");
            System.out.println("Role: " + user.getRole());

            showDashboard(user.getRole());

            return new Session(username);
        }

        // Debug info (optional)
        System.out.println("Stored hash: " + user.getPasswordHash());
        System.out.println("Entered hash: " + PasswordUtil.hash(password));

        System.out.println("Invalid Credentials");
        return null;
    }

    private void showDashboard(String role) {

        System.out.println("\n===== DASHBOARD =====");

        switch (role) {

            case "EMPLOYEE":
                System.out.println("Employee Dashboard");
                System.out.println("View Payslip | Update Profile");
                break;

            case "MANAGER":
                System.out.println("Manager Dashboard");
                System.out.println("Approve Leave | View Reports");
                break;

            default:
                System.out.println("Unknown Role");
        }
    }
}

