package com.clarusways.utilities;

import com.github.javafaker.Faker;

public class T09_TestDataGenerator {
    private static Faker faker = new Faker();

    // Password Test Data
    public static String getWeakPassword() {
        return "abc";
    }

    public static String getShortPassword() {
        return "Abc123";
    }

    public static String getOnlyLowercasePassword() {
        return "aaaaaaaa";
    }

    public static String getOnlyUppercasePassword() {
        return "AAAAAAAA";
    }

    public static String getOnlyNumbersPassword() {
        return "12345678";
    }

    public static String getMediumPassword() {
        return "Password";
    }

    public static String getStrongPassword() {
        return "Password123";
    }

    public static String getVeryStrongPassword() {
        return "P@ssw0rd123!";
    }

    // Username Test Data
    public static String getValidUsername() {
        return faker.name().username().replaceAll("[^a-zA-Z0-9._-]", "").substring(0, 10);
    }

    public static String getUsernameWithSpecialChars() {
        return "User_123-Name";
    }

    // Email Test Data
    public static String getValidEmail() {
        return faker.internet().emailAddress();
    }

    public static String getEmailWithSubdomain() {
        return "user@mail.example.com";
    }

    public static String getEmailWithPlusTag() {
        return "user+tag@example.com";
    }

    public static String getInvalidEmailNoAt() {
        return "invalidemail";
    }

    public static String getInvalidEmailNoDomain() {
        return "user@";
    }

    public static String getInvalidEmailMultipleAt() {
        return "user@domain@com";
    }
}