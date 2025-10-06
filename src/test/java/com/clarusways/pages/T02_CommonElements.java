package com.clarusways.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.clarusways.utilities.T06_DriverManager;

public class T02_CommonElements {

    public T02_CommonElements() {
        PageFactory.initElements(T06_DriverManager.getDriver(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement pageHeader;

    @FindBy(className = "alert-success")
    public WebElement successAlert;

    @FindBy(className = "alert-danger")
    public WebElement errorAlert;

    @FindBy(className = "alert-warning")
    public WebElement warningAlert;

    @FindBy(className = "container")
    public WebElement mainContainer;

    @FindBy(tagName = "body")
    public WebElement pageBody;

    // Common methods
    public String getPageTitle() {
        return T06_DriverManager.getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return T06_DriverManager.getDriver().getCurrentUrl();
    }

    public boolean isSuccessAlertDisplayed() {
        try {
            return successAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorAlertDisplayed() {
        try {
            return errorAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessage() {
        return isSuccessAlertDisplayed() ? successAlert.getText() : "";
    }

    public String getErrorMessage() {
        return isErrorAlertDisplayed() ? errorAlert.getText() : "";
    }
}