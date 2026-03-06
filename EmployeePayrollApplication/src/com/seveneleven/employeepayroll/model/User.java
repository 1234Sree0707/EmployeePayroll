package com.seveneleven.employeepayroll.model;
import com.seveneleven.employeepayroll.util.PasswordUtil;
public abstract class User {

    protected String username;
    protected String passwordHash;
    protected String role;

    public User(String username,String password,String role){

        this.username=username;
        this.passwordHash=PasswordUtil.hash(password);
        this.role=role;
    }
    
    public void setPasswordHash(String passwordHash) {
    	this.passwordHash = passwordHash;
    }
    public String getRole(){
        return role;
    }
    public abstract boolean authenticate(String username,String password);

}