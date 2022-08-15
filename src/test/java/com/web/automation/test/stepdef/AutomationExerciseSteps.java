package com.web.automation.test.stepdef;

import com.web.automation.test.cucumbercontext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class AutomationExerciseSteps extends BaseStep{
    public AutomationExerciseSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("^user open Para Bank home page.$")
    public void openparaBankHomePage() {
        paraBank.openParaBankApplication();
    }
    @And("^user login using credentials.$")
    public void loginToParaBank() {
        paraBank.loginToParaBank("pawankrdwivedi","Pawan@1981");
    }
}
