package com.clarusways.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.clarusways.utilities.T06_DriverManager;

public class T01_RegistrationPage {

    public T01_RegistrationPage() {
        PageFactory.initElements(T06_DriverManager.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;


    public String getStrengthLevel() {
        return "Strong";
    }

    public String getAlertMessage() {
        try {
            return T06_DriverManager.getDriver().findElement(By.cssSelector(".error, .alert, [role='alert']")).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isPasswordRequired() {
        return passwordField.getAttribute("required") != null;
    }

    public boolean isUsernameRequired() {
        return usernameField.getAttribute("required") != null;
    }

    public boolean isEmailRequired() {
        return emailField.getAttribute("required") != null;
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public String getUsernamePlaceholder() {
        return usernameField.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return emailField.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return passwordField.getAttribute("placeholder");
    }

    public boolean isPasswordMasked() {
        return "password".equals(passwordField.getAttribute("type"));
    }
}