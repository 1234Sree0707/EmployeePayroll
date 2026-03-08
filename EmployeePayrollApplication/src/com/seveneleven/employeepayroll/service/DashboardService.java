package com.seveneleven.employeepayroll.service;

import java.util.List;

import com.seveneleven.employeepayroll.dashboard.*;
import com.seveneleven.employeepayroll.payslip.Payslip;

public class DashboardService {

    public void showDashboard(String role, List<Payslip> payslips) {

        Dashboard dashboard = DashboardFactory.createDashboard(role);

        System.out.println("Loaded Dashboard Type: " + dashboard.getClass().getSimpleName());

        dashboard.display(payslips);
    }
}