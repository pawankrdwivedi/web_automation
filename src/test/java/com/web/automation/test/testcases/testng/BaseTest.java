package com.web.automation.test.testcases.testng;

import com.web.automation.framework.engine.SeleniumHelper;
import com.web.automation.framework.exception.WebException;
import com.web.automation.framework.report.ReportManagerHelper;
import com.web.automation.framework.report.ReportTestHelper;
import com.web.automation.framework.utils.GenericHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.test.businessfunctions.AutomationExerciseBF;
import com.web.automation.test.businessfunctions.ToDoMVCBF;
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
     * Application Business Functions
     */
    public AutomationExerciseBF paraBank = new AutomationExerciseBF();
    public ToDoMVCBF toDoMCV=new ToDoMVCBF();
    /**
     * Others
      */
    public GenericHelper genFunctions = new GenericHelper();


    @BeforeSuite
    public void createReport() {
        if (framework.equalsIgnoreCase("testng")) {
            try {
                ReportManagerHelper.createExtentReports();
            } catch (WebException e) {
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
    public void closeTest(Method caller) throws WebException {
        if (framework.equalsIgnoreCase("testng")) {
            SeleniumHelper selHelper = new SeleniumHelper();
            selHelper.quitBrowser();
        }
    }

    @AfterSuite
    public void closeDrvierAndBrowser() throws WebException {
        if (framework.equalsIgnoreCase("testng")) {
            ReportManagerHelper.closeReport();
            //genFunc.killChromeInstances();
        }
    }
}
