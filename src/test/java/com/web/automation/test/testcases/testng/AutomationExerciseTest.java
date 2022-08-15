package com.web.automation.test.testcases.testng;

import com.web.automation.framework.engine.ReRunHelper;
import com.web.automation.framework.utils.PropertyReader;
import org.testng.annotations.Test;

public class AutomationExerciseTest extends BaseTest{
    @Test(priority = 1,retryAnalyzer = ReRunHelper.class)
    public void _001_Login_To_Para_Bank() {
        paraBank.openParaBankApplication();
        paraBank.loginToParaBank(PropertyReader.getEnvProperties("userName"),
                PropertyReader.getEnvProperties("password"));
        paraBank.transferFunds("198");
        paraBank.checkAccountActivity("198");
    }
    }
