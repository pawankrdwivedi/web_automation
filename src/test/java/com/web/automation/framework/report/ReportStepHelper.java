package com.web.automation.framework.report;

import com.aventstack.extentreports.Status;
import com.web.automation.test.stepdef.CucumberHooks;
import com.web.automation.test.stepdef.CucumberHooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import com.web.automation.framework.utils.PropertyReader;

public class ReportStepHelper extends ReportManagerHelper {
    static String framework = PropertyReader.getTestBedProperties("framework");
    static String takeAllSnapshots = PropertyReader.getTestBedProperties("takeAllSnapshots");

    public static void PASS(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            if (takeAllSnapshots.equalsIgnoreCase("yes")) {
                String base64Screenshot = "data:image/png;base64,"
                        + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                ReportTestHelper.getTest().log(Status.PASS, description,
                        ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia()
                                .get(ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().size() - 1));
            } else {
                ReportTestHelper.getTest().log(Status.PASS, description);
            }
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
    }

    public static void FAIL(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            String base64Screenshot = "data:image/png;base64,"
                    + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ReportTestHelper.getTest().log(Status.FAIL, description,
                    ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia()
                            .get(ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().size() - 1));
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
        Assert.fail(description);
    }

    public static void INFO(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            if (takeAllSnapshots.equalsIgnoreCase("yes")) {
                String base64Screenshot = "data:image/png;base64,"
                        + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                ReportTestHelper.getTest().log(Status.INFO, description,
                        ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia()
                                .get(ReportTestHelper.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().size() - 1));
            }
            else
            {
                ReportTestHelper.getTest().log(Status.INFO,description);
            }
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
    }

    public static void PASS_NO_UI(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            ReportTestHelper.getTest().log(Status.PASS, description);
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
    }

    public static void FAIL_NO_UI(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            ReportTestHelper.getTest().log(Status.FAIL, description);
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
        Assert.fail(description);
    }

    public static void INFO_NO_UI(String description) {
        if (framework.equalsIgnoreCase("testng")) {
            ReportTestHelper.getTest().log(Status.INFO, description);
        }
        else if((framework.equalsIgnoreCase("cucumber"))){
            CucumberHooks.eachScenario.log(description);
        }
    }
}