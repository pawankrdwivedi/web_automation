package com.web.automation.test.locators;

import org.openqa.selenium.By;

public class AutomationExerciseOR {
    //By.id
    public static final By HEADER_PANEL=By.id("headerPanel");
    //By.xpath
    public static final By USERNAME=By.xpath("//input[@name='username']");
    public static final By PASSWORD=By.xpath("//input[@name='password']");
    public static final By LOG_IN_BUTTON=By.xpath("//input[@value='Log In']");
    /**
     * Menu Bar
     */
    public static final By TRANSFER_FUNDS_LINK=By.xpath("//a[text()='Transfer Funds']");
    public static final By TRANSFER_FUNDS_HEADER=By.xpath("//h1[text()='Transfer Funds']");
    public static final By TRANSFER_AMOUNT=By.name("amount");
    public static final By TRANSFER_BUTTON=By.xpath("//input[@value='Transfer']");
    public static final By TRANSFER_COMPLETE_HEADER=By.xpath("//h1[text()='Transfer Complete!']");

    public static final By ACCOUNT_OVERVIEW_LINK=By.xpath("//a[text()='Accounts Overview']");
    public static final By ACCOUNTS_OVERVIEW_HEADER=By.xpath("//h1[text()='Accounts Overview']");
    public static final By ACCOUNTS_LINK=By.xpath("//a[contains(@href,'14343')]");
    public static final By ACCOUNT_ACTIVITY_HEADER=By.xpath("//h1[text()='Account Activity']");
    public static final By GO_BUTTON=By.xpath("//input[@value='Go']");

    public static final By TRANSACTION_TABLE=By.id("transactionTable");
    public static final By TABLE_ROW=By.xpath("//tr[@class='ng-scope']");
    public static final By TABLE_COLUMN=By.xpath(".//td");//[contains(@class,'ng-scope')]");



    public static final By LOG_OUT_LINK=By.xpath("//a[text()='Log Out']");




}
