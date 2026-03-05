package com.seveneleven.employeepayroll.model;
import java.io.FileWriter;
import java.io.IOException;
public class Employee {
	
    private String empId;
    private String name;
    private String email;
    private String phone;

    private UserAccount account;
    
    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    @Override
    public String toString() {

        return "\nEmployee Registered Successfully:\n" +
                "Employee ID : " + empId +
                "\nName : " + name +
                "\nEmail : " + email +
                "\nPhone : " + phone +
                "\nUsername : " + account.getUsername();
    }

    public void persist() throws IOException {

        FileWriter fw = new FileWriter("employee_data.txt", true);

        fw.write(empId + "," + name + "," + email + "," + phone + "," + account.getUsername() + "\n");

        fw.close();
    }
}
