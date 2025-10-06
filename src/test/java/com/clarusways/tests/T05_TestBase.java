package com.clarusways.tests;

import com.clarusways.utilities.T06_DriverManager;
import com.clarusways.utilities.T07_ConfigReader;
import org.testng.annotations.AfterSuite;  // استخدم AfterSuite بدل AfterMethod
import org.testng.annotations.BeforeMethod;

public class T05_TestBase {

    @BeforeMethod
    public void setUp() {
        T06_DriverManager.getDriver().get(T07_ConfigReader.getUrl());
    }

    @AfterSuite
    public void tearDown() {
        T06_DriverManager.closeDriver();
    }
}