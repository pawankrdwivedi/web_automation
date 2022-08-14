package com.web.automation.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.web.automation.framework.engine.WebDriverFactory;
import com.web.automation.framework.exception.QbeException;
import com.web.automation.framework.utils.DateHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.framework.exception.QbeException;

public class ReportManagerHelper extends WebDriverFactory
{
    public static final ExtentReports extentReports = new ExtentReports();
    static DateHelper fmtDate=new DateHelper();
    public synchronized static ExtentReports createExtentReports() throws QbeException
    {
        try {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testreport/" + PropertyReader.getTestBedProperties("framework") + "/ExtentReport_" + fmtDate.getUniqueString() + ".html");
            reporter.config().setReportName("Automation Report");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Browser", PropertyReader.getTestBedProperties("browserName").toUpperCase());
        } catch(Exception e) {
            throw new QbeException(e.getMessage());
        }
        return extentReports;
    }

    public static void closeReport() throws QbeException
    {
        try{
            extentReports.flush();
        }
        catch(Exception e)
        {
            throw new QbeException(e.getMessage());
        }
    }
}
