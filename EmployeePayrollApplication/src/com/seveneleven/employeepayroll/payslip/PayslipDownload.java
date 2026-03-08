package com.seveneleven.employeepayroll.payslip;

public final class PayslipDownload {

    private final Payslip payslip;
    private final long expiryTime;

    public PayslipDownload(Payslip payslip, long expiryTime) {
        this.payslip = payslip;
        this.expiryTime = expiryTime;
    }

    public Payslip getPayslip() {
        return payslip;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}