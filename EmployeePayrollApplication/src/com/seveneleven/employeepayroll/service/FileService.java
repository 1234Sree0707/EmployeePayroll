package com.seveneleven.employeepayroll.service;

import java.io.FileWriter;
import java.io.IOException;

import com.seveneleven.employeepayroll.payslip.Payslip;

public class FileService {

    public String savePayslip(Payslip payslip) throws IOException {

        String filename = "payslip_" +
                System.currentTimeMillis() + ".txt";

        FileWriter writer = new FileWriter(filename);

        writer.write(payslip.toString());

        writer.close();

        return filename;
    }
}