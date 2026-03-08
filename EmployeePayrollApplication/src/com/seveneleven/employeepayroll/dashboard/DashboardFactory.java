package com.seveneleven.employeepayroll.dashboard;

public class DashboardFactory {

    public static Dashboard createDashboard(String role) {

        switch (role) {

            case "EMPLOYEE":
                return new EmployeeDashboard();

            case "MANAGER":
                return new ManagerDashboard();

            default:
                throw new IllegalArgumentException("Unknown role");
        }
    }
}