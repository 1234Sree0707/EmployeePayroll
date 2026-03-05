package com.seveneleven.employeepayroll.app;
import java.util.Scanner;
import java.io.IOException;
import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.UserAccount;
import com.seveneleven.employeepayroll.util.Validation;
import com.seveneleven.employeepayroll.validexception.ValidationException;
public class EmployeeApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        try {

            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
           Validation.isValidId(id);
        	  
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
           Validation.isValidEmail(email);
        	   

            //take phone no. as input
            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();
            Validation.isValidPhone(phone);
            

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();
            UserAccount account = new UserAccount(username, password);

            Employee emp = new Employee(id, name, email, phone, account);

            emp.persist();
            System.out.println(emp);

            System.out.println("\nData persisted in file: employee_data.txt");

        }
        catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }

        sc.close();
    }
}