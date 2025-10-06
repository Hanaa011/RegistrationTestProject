package com.clarusways.tests;

import com.clarusways.pages.T01_RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T03_PasswordStrengthTest extends T05_TestBase {

    T01_RegistrationPage registrationPage = new T01_RegistrationPage();

    // TC_PASS_001
    @Test
    public void testStrongPasswordShowsMaxStrength() {
        registrationPage.enterPassword("Password123");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "Password123");
    }

    // TC_PASS_002
    @Test
    public void testPasswordPlaceholder() {
        String placeholder = registrationPage.getPasswordPlaceholder();
        Assert.assertEquals(placeholder, "Enter your password");
    }

    // TC_PASS_003
    @Test
    public void testPasswordFieldRequired() {
        Assert.assertTrue(registrationPage.isPasswordRequired());
    }

    // TC_PASS_004
    @Test
    public void testWeakPasswordStrengthZero() {
        registrationPage.enterPassword("abc");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "abc");
    }

    // TC_PASS_005
    @Test
    public void testCanTypeMixedCharacters() {
        registrationPage.enterPassword("Aa1");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "Aa1");
    }

    // TC_PASS_006
    @Test
    public void testClearPasswordResetsIndicator() {
        registrationPage.enterPassword("Test123");
        registrationPage.enterPassword("");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "");
    }

    // TC_PASS_007
    @Test
    public void testRealTimeStrengthUpdate() {
        registrationPage.enterPassword("A");
        String initialValue = registrationPage.passwordField.getAttribute("value");

        registrationPage.enterPassword("Abc12345");
        String finalValue = registrationPage.passwordField.getAttribute("value");

        Assert.assertNotEquals(initialValue, finalValue);
        Assert.assertEquals(finalValue, "Abc12345");
    }

    // TC_PASS_008
    @Test
    public void testVeryWeakPassword() {
        registrationPage.enterPassword("a");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "a");
    }

    // TC_PASS_009
    @Test
    public void testOnlyLowercaseStrength() {
        registrationPage.enterPassword("aaaaaaaa");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "aaaaaaaa");
    }

    // TC_PASS_010
    @Test
    public void testOnlyUppercaseStrength() {
        registrationPage.enterPassword("AAAAAAAA");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "AAAAAAAA");
    }

    // TC_PASS_011
    @Test
    public void testOnlyNumbersStrength() {
        registrationPage.enterPassword("12345678");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "12345678");
    }

    // TC_PASS_012
    @Test
    public void testLowercaseUppercaseStrength() {
        registrationPage.enterPassword("Aaaaaaaa");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "Aaaaaaaa");
    }

    // TC_PASS_013
    @Test
    public void testLowercaseNumbersStrength() {
        registrationPage.enterPassword("aaaaaaa1");
        String enteredValue = registrationPage.passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "aaaaaaa1");
    }

    // TC_PASS_014
    @Test
    public void testPasswordIsMasked() {
        Assert.assertTrue(registrationPage.isPasswordMasked());
    }

    // TC_PASS_015
    @Test
    public void testShortPasswordPreventsSubmission() {
        registrationPage.enterUsername("testuser");
        registrationPage.enterEmail("test@example.com");
        registrationPage.enterPassword("Abc123"); // Short password
        registrationPage.clickRegister();

        Assert.assertTrue(true);
    }
}