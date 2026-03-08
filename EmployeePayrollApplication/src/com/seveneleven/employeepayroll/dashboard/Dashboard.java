package com.seveneleven.employeepayroll.dashboard;

import java.util.List;
import com.seveneleven.employeepayroll.payslip.Payslip;

public interface Dashboard {

    void display(List<Payslip> payslips);
}