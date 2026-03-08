package com.seveneleven.employeepayroll.util;

import java.util.regex.Pattern;
import com.seveneleven.employeepayroll.validexception.ValidationException;

public class ValidationService {

    // Regex patterns
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[6-9][0-9]{9}$");

    private static final Pattern EMP_ID_PATTERN =
            Pattern.compile("^[A-Za-z]{2}-\\d{4}$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{8,}$");


    // Email Validation
    public static void validateEmail(String email) throws ValidationException {

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException(
                    "Invalid email format. Example: user@gmail.com");
        }
    }


    // Phone Validation
    public static void validatePhone(String phone) throws ValidationException {

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new ValidationException(
                    "Phone must be 10 digits starting with 6-9.");
        }
    }


    // Employee ID Validation
    public static void validateEmployeeId(String id) throws ValidationException {

        if (!EMP_ID_PATTERN.matcher(id).matches()) {
            throw new ValidationException(
                    "Employee ID must follow format: AB-1234");
        }
    }


    // Password Strength
    public static void validatePassword(String password) throws ValidationException {

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new ValidationException(
                    "Password must contain 8+ chars, uppercase, lowercase, number, special char.");
        }
    }
}