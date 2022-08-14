package com.web.automation.framework.report;

import static com.web.automation.framework.report.ReportManagerHelper.extentReports;
import com.aventstack.extentreports.ExtentTest;


import java.util.HashMap;
import java.util.Map;


public class ReportTestHelper
{
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();


    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extentReports.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
