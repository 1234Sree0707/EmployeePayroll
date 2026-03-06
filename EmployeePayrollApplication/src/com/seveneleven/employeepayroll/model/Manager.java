package com.seveneleven.employeepayroll.model;
import com.seveneleven.employeepayroll.util.PasswordUtil;

public class Manager extends User{

    public Manager(String username,String password){
        super(username,password,"MANAGER");
    }

    public boolean authenticate(String username,String password){

        return this.username.equals(username) &&
                this.passwordHash.equals(PasswordUtil.hash(password));
    }
}