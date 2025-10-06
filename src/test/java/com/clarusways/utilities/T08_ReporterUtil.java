package com.clarusways.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T08_ReporterUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = testName + "_" + timeStamp + ".png";
            String filePath = "test-results/T15_Screenshots/" + fileName;

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);

            destination.getParentFile().mkdirs();

            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return filePath;

        } catch (IOException e) {
            e.printStackTrace();
            return "Screenshot failed: " + e.getMessage();
        }
    }

    public static void createAllureEnvironmentFile() {
        try {
            String content = "Browser=" + T07_ConfigReader.getBrowser() + "\n" +
                    "URL=" + T07_ConfigReader.getUrl() + "\n" +
                    "Environment=Test\n" +
                    "Tester=Clarusways Team";

            File file = new File("test-results/T14_AllureResults/environment.properties");
            file.getParentFile().mkdirs();
            Files.write(file.toPath(), content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}