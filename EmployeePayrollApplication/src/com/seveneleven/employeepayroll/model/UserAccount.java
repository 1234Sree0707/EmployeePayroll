package com.seveneleven.employeepayroll.model;
import java.util.regex.Pattern;
import com.seveneleven.employeepayroll.validexception.ValidException;
public class UserAccount {

    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}