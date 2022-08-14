package com.web.automation.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static String propertiesFolder = "src/test/resources/properties/";

    private static FileReader getPropertiesFromFile(String filePath) throws FileNotFoundException {
        File propFile = new File(filePath);
        return new FileReader(propFile.getAbsolutePath());
    }

    public static String getTestBedProperties(String propertyName) {
        Properties prop = new Properties();
        try {
            prop.load(getPropertiesFromFile(propertiesFolder + "TestBed.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public static String getPropertyValue(String type, String propertyName) {
        String environment;
        String application;

        application = System.getProperty("application");
        if (application == null) {
            application = getTestBedProperties("application").toUpperCase();
            System.setProperty("application", application);
        }
        Properties prop = new Properties();
        try {
            prop.load(getPropertiesFromFile(propertiesFolder + type + "/" + application + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public static String getEnvProperties(String propertyName) {

        return getPropertyValue("env", propertyName);
    }

    public static String getApiProperties(String propertyName) {

        return getPropertyValue("api", propertyName);
    }
}