package com.web.automation.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.web.automation.framework.engine.WebDriverFactory;
import com.web.automation.framework.exception.WebException;
import com.web.automation.framework.utils.DateHelper;
import com.web.automation.framework.utils.PropertyReader;

public class ReportManagerHelper extends WebDriverFactory
{
    public static final ExtentReports extentReports = new ExtentReports();
    static DateHelper fmtDate=new DateHelper();
    public synchronized static ExtentReports createExtentReports() throws WebException
    {
        try {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testreport/" + PropertyReader.getTestBedProperties("framework") + "/ExtentReport_" + fmtDate.getUniqueString() + ".html");
            reporter.config().setReportName("Automation Report");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Browser", PropertyReader.getTestBedProperties("browserName").toUpperCase());
        } catch(Exception e) {
            throw new WebException(e.getMessage());
        }
        return extentReports;
    }

    public static void closeReport() throws WebException
    {
        try{
            extentReports.flush();
        }
        catch(Exception e)
        {
            throw new WebException(e.getMessage());
        }
    }
}
