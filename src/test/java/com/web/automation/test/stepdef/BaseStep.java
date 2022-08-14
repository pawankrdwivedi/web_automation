package com.web.automation.test.stepdef;

import com.web.automation.test.cucumbercontext.ScenarioContext;
import com.web.automation.test.cucumbercontext.TestContext;
import com.web.automation.test.testcases.testng.BaseTest;

public class BaseStep extends BaseTest {
    private ScenarioContext scenarioContext;
    public BaseStep(TestContext testContext)
    {
        scenarioContext = testContext.getScenarioContext();
    }
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


}
