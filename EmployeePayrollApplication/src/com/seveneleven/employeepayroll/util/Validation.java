package com.seveneleven.employeepayroll.util;

import com.seveneleven.employeepayroll.validexception.ValidationException;

public class Validation {

    public static void isValidEmail(String email) throws ValidationException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(regex)) {
            throw new ValidationException("Invalid Email format!");
        }
    }

    public static void isValidPhone(String phone) throws ValidationException {
        String regex = "^[6-9][0-9]{9}$";
        if (!phone.matches(regex)) {
            throw new ValidationException("Invalid Phone number!");
        }
    }

    public static void isValidId(String id) throws ValidationException {
        String regex = "^[A-Za-z]{2}-\\d{4}$";
        if (!id.matches(regex)) {
            throw new ValidationException("Invalid Employee ID format!");
        }
    }
}