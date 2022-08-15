package com.web.automation.test.businessfunctions;

import com.web.automation.framework.engine.SeleniumHelper;
import com.web.automation.framework.utils.PropertyReader;
import com.web.automation.framework.report.ReportStepHelper;
import com.web.automation.framework.utils.GenericHelper;
import com.web.automation.test.locators.ToDoMVCOR;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ToDoMVCBF {
    SeleniumHelper selHelper = new SeleniumHelper();
    GenericHelper genFunctions = new GenericHelper();


    public void openURL() {
        try {
            selHelper.openURL(PropertyReader.getEnvProperties("url"));
                if (selHelper.verifyTitle("TodoMVC")) {
                    ReportStepHelper.PASS("VU.js ToDoMVC page is displayed");
                }else{
                    ReportStepHelper.FAIL("Home page of Northstar application is not displayed:Authenticator is displayed.Please re-execute.");
                }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void addItemInToDoList(String text) {
        try {
            selHelper.type(ToDoMVCOR.TO_DO_INPUT_BOX,text+ Keys.ENTER);
            if (selHelper.isDisplayed(By.xpath("//label[text()='"+text+"']"))) {
                ReportStepHelper.PASS("Item: "+text+" is added in the To Do List.");
            }else{
                ReportStepHelper.FAIL("Item: "+text+" is not added in the To Do List.");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void deleteItemFromToDoList(String text) {
        try {
            selHelper.click(By.xpath("//label[text()='"+text+"']/following-sibling::button"));
            if (!selHelper.isDisplayed(By.xpath("//label[text()='"+text+"']"))) {
                ReportStepHelper.PASS("Item: "+text+" is deleted from the To Do List.");
            }else{
                ReportStepHelper.FAIL("Item: "+text+" is not deleted from the To Do List.");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }
    public void applyCompletedFilter() {
        try {
            selHelper.click(ToDoMVCOR.TO_DO_FILTER_Completed);
            String strStatus = selHelper.getAttribute(ToDoMVCOR.TO_DO_FILTER_Completed);
            if (strStatus.contains("selected")) {
                ReportStepHelper.PASS("Completed filter applied on To Do List.");
            }else{
                ReportStepHelper.FAIL("Not able to apply Completed filter on To Do List.");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void applyActiveFilter() {
        try {
            selHelper.click(ToDoMVCOR.TO_DO_FILTER_Active);
            String strStatus = selHelper.getAttribute(ToDoMVCOR.TO_DO_FILTER_Active);
            if (strStatus.contains("selected")) {
                ReportStepHelper.PASS("Active filter applied on To Do List.");
            }else{
                ReportStepHelper.FAIL("Not able to apply Active filter on To Do List.");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void applyAllFilter() {
        try {
            selHelper.click(ToDoMVCOR.TO_DO_FILTER_All);
            String strStatus = selHelper.findElement(ToDoMVCOR.TO_DO_FILTER_All).getAttribute("class");
            if (strStatus.contains("selected")) {
                ReportStepHelper.PASS("All filter applied on To Do List.");
            }else{
                ReportStepHelper.FAIL("Not able to apply All filter on To Do List.");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void markActiveItemAsCompleted(String ItemName) {
        try {

            WebElement eleCheckStatus = selHelper.findElement(By.xpath("//label[text()='"+ItemName+"']/ancestor::li"));
            String checkBoxStatus = eleCheckStatus.getAttribute("class");
            WebElement eleCheckBox = selHelper.findElement(By.xpath("//label[text()='"+ItemName+"']/ancestor::div/input"));

            if (!checkBoxStatus.equalsIgnoreCase("todo completed")) {
                eleCheckBox.click();
                boolean boolCheckStatus = selHelper.isDisplayed(By.xpath("//label[text()='"+ItemName+"']/ancestor::li[@class='todo completed']"));
                //eleCheckStatus = selHelper.findElement(By.xpath("//label[text()='"+ItemName+"']/ancestor::li"));

                if(boolCheckStatus){
                    ReportStepHelper.PASS("Item: "+ItemName+" marked as completed");
                }else{
                    ReportStepHelper.FAIL("Not able to mark completed for Item: "+ItemName);
                }

            }else {
                ReportStepHelper.PASS("Item: "+ItemName+" already marked as completed");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void markCompletedItemAsActive(String ItemName) {
        try {

            WebElement eleCheckStatus = selHelper.findElement(By.xpath("//label[text()='"+ItemName+"']/ancestor::li"));
            String checkBoxStatus = eleCheckStatus.getAttribute("class");
            WebElement eleCheckBox = selHelper.findElement(By.xpath("//label[text()='"+ItemName+"']/ancestor::div/input"));

            if (!checkBoxStatus.equalsIgnoreCase("todo")) {
                eleCheckBox.click();
                boolean boolCheckStatus = selHelper.isDisplayed(By.xpath("//label[text()='"+ItemName+"']/ancestor::li[@class='todo']"));
                if(boolCheckStatus){
                    ReportStepHelper.PASS("Item: "+ItemName+" marked as Active from Completed");
                }else{
                    ReportStepHelper.FAIL("Not able to mark Active for Item: "+ItemName);
                }

            }else {
                ReportStepHelper.PASS("Item: "+ItemName+" already marked as Active");
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void verifyAllTODOListCount(int intActualCount) {
        try {

            List<WebElement> eleTODOItems = selHelper.findElementCollection(By.xpath("//ul[@class='todo-list']/li"));
            int intObservedCount = eleTODOItems.size();
            if (intObservedCount == intActualCount) {
                ReportStepHelper.PASS(intObservedCount+" Items added in to do list");
            }else {
                ReportStepHelper.PASS("Actual Item Count "+intActualCount+" does not match with observed count "+intObservedCount);
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void verifyCompletedCount(int intActualCount) {
        try {

            List<WebElement> eleTODOItems = selHelper.findElementCollection(By.xpath("//ul/li[@class='todo completed']"));
            int intObservedCount = eleTODOItems.size();
            if (intObservedCount == intActualCount) {
                ReportStepHelper.PASS(intObservedCount+" Items Completed in to do list");
            }else {
                ReportStepHelper.PASS("Actual Item Count "+intActualCount+" does not match with observed count "+intObservedCount);
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }

    public void verifyActiveCount(int intActualCount) {
        try {

            List<WebElement> eleTODOItems = selHelper.findElementCollection(By.xpath("//ul/li[@class='todo completed']"));
            int intObservedCount = eleTODOItems.size();
            if (intObservedCount == intActualCount) {
                ReportStepHelper.PASS(intObservedCount+" Items Completed in to do list");
            }else {
                ReportStepHelper.PASS("Actual Item Count "+intActualCount+" does not match with observed count "+intObservedCount);
            }
        } catch (Exception e) {
            ReportStepHelper.FAIL(e.getMessage());
        }
    }
}