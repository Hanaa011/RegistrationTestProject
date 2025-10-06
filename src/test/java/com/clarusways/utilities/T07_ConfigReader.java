package com.clarusways.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class T07_ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/T12_Configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getUrl() {
        return getProperty("url");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }
}