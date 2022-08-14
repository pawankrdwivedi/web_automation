package com.web.automation.test.testcases.testng;

import com.web.automation.framework.engine.SeleniumHelper;
import com.web.automation.framework.exception.QbeException;
import com.web.automation.framework.report.ReportManagerHelper;
import com.web.automation.framework.report.ReportTestHelper;
import com.web.automation.framework.utils.GenericHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.framework.engine.SeleniumHelper;
import com.web.automation.framework.exception.QbeException;
import com.web.automation.framework.report.ReportManagerHelper;
import com.web.automation.framework.report.ReportTestHelper;
import com.web.automation.framework.utils.GenericHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.test.businessfunctions.ParaBankBF;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class BaseTest {

    /**
     * Properties
     */
    String framework = PropertyReader.getTestBedProperties("framework");
    /**
     * Test Data
     */
    public HashMap<String, String> testData = new HashMap<>();
    /**
     * Console Business Functions
     */
    public ParaBankBF paraBank = new ParaBankBF();
    /**
     * Others
      */
    public GenericHelper genFunctions = new GenericHelper();


    @BeforeSuite
    public void createReport() {
        if (framework.equalsIgnoreCase("testng")) {
            try {
                ReportManagerHelper.createExtentReports();
            } catch (QbeException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeMethod
    public void startTest(Method caller) {
        if (framework.equalsIgnoreCase("testng")) {
            ReportTestHelper.startTest(caller.getName(), "");
        }
    }

    @AfterMethod
    public void closeTest(Method caller) throws QbeException {
        if (framework.equalsIgnoreCase("testng")) {
            SeleniumHelper selHelper = new SeleniumHelper();
            selHelper.quitBrowser();
        }
    }

    @AfterSuite
    public void closeDrvierAndBrowser() throws QbeException {
        if (framework.equalsIgnoreCase("testng")) {
            ReportManagerHelper.closeReport();
            //genFunc.killChromeInstances();
        }
    }
}