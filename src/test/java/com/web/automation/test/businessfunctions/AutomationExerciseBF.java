package com.web.automation.test.businessfunctions;

import com.web.automation.framework.engine.SeleniumHelper;
import com.web.automation.framework.report.ReportStepHelper;
import com.web.automation.framework.utils.GenericHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.test.locators.AutomationExerciseOR;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AutomationExerciseBF {
    SeleniumHelper selHelper = new SeleniumHelper();
    GenericHelper genFunctions = new GenericHelper();


    public void openParaBankApplication() {
        selHelper.openURL(PropertyReader.getEnvProperties("url"));
        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.HEADER_PANEL)) {
            ReportStepHelper.PASS("Para Bank Home Page is displayed.");
        } else {
            ReportStepHelper.FAIL("Para Bank Home Page is not displayed");
        }
    }

    public void loginToParaBank(String userName, String password) {
        try{
        selHelper.type(AutomationExerciseOR.USERNAME, userName);
        selHelper.type(AutomationExerciseOR.PASSWORD, password);
        selHelper.click(AutomationExerciseOR.LOG_IN_BUTTON);

        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.LOG_OUT_LINK)) {
            ReportStepHelper.PASS("'Para Bank Home Page' is displayed.");
        } else {
            ReportStepHelper.FAIL("'Para Bank Home Page' is not displayed");
        }
        }catch(Exception e)
        {
            ReportStepHelper.FAIL("Error in Login to Para Bank: "+e.getMessage());
        }
    }

    public void transferFunds(String amount) {
        selHelper.click(AutomationExerciseOR.TRANSFER_FUNDS_LINK);
        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.TRANSFER_FUNDS_HEADER)) {
            ReportStepHelper.PASS("'Transfer Funds' page is displayed.");
        } else {
            ReportStepHelper.FAIL("'Transfer Funds' page is not displayed");
        }
        selHelper.type(AutomationExerciseOR.TRANSFER_AMOUNT, amount);
        selHelper.click(AutomationExerciseOR.TRANSFER_BUTTON);
        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.TRANSFER_COMPLETE_HEADER)) {
            ReportStepHelper.PASS("'Transfer Complete' page is displayed.");
        } else {
            ReportStepHelper.FAIL("'Transfer Complete' page is not displayed");
        }
    }

    public void checkAccountActivity(String amount) {
        selHelper.click(AutomationExerciseOR.ACCOUNT_OVERVIEW_LINK);
        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.ACCOUNTS_OVERVIEW_HEADER)) {
            ReportStepHelper.PASS("'Accounts Overview' page is displayed.");
        } else {
            ReportStepHelper.FAIL("'Accounts Overview' page is not displayed");
        }
        selHelper.click(AutomationExerciseOR.ACCOUNTS_LINK);
        if (selHelper.waitTillElementIsDisplayed(AutomationExerciseOR.ACCOUNT_ACTIVITY_HEADER)) {
            ReportStepHelper.PASS("'Account Activity' page is displayed.");
        } else {
            ReportStepHelper.FAIL("'Account Activity' page is not displayed");
        }
        selHelper.click(AutomationExerciseOR.GO_BUTTON);
        List<WebElement> rowElement=selHelper.findChildElementCollection(selHelper.findElement(AutomationExerciseOR.TRANSACTION_TABLE), AutomationExerciseOR.TABLE_ROW);
        boolean bFlag=false;
        for(WebElement row:rowElement) {
            List<WebElement> columnList = selHelper.findChildElementCollection(row, AutomationExerciseOR.TABLE_COLUMN);
            if (columnList.get(2).getText().contains(amount)) {
                ReportStepHelper.PASS("On Date: "+columnList.get(0).getText()+" "+columnList.get(1).getText()+" for Amount: "+columnList.get(2).getText());
                bFlag=true;
                break;
            }
            if(!bFlag){
                ReportStepHelper.PASS("No Account Activity is done for Amount: $ "+amount);
            }
        }
    }

}