package com.web.automation.framework.engine;

import com.web.automation.framework.exception.QbeException;
import com.web.automation.framework.log.LogHelper;
import com.web.automation.framework.exception.QbeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.web.automation.framework.utils.PropertyReader;

public class WebDriverFactory
{
    public static WebDriver driver;
    static LogHelper logger = new LogHelper();

    public static WebDriver getDriver() throws QbeException
    {
        String browser = null;
        try {
            browser = System.getProperty("browser");
            if (browser == null) {
                browser = PropertyReader.getTestBedProperties("browserName");
            }
            switch (browser.toLowerCase().trim()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    /*options.setHeadless(true);
                    options.addArguments("user-data-dir=C:/Users/"+System.getProperty("user.name")+"/AppData/Local/Google/Chrome/User Data/Default");
                    options.addArguments("profile directory=Pawan Dwivedi");*/
                    driver = new ChromeDriver(options);
                  /* driver= WebDriverManager.chromedriver().capabilities(options).create();*/
                    break;
                case "ie":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                case "firefox":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                case "edge":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                default:
                    driver= WebDriverManager.chromedriver().create();
            }
            driver.manage().window().maximize();
        }
        catch(Exception e)
        {
            logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver. "+e.getMessage());
            throw new QbeException("Unable to create "+browser.toUpperCase()+" Wedriver. "+e.getMessage());
        }
        logger.info(browser.toUpperCase()+" Wedriver created.");
        return driver;
    }

    public static WebDriver returnDriverInstance()
    {
        return driver;
    }
}
