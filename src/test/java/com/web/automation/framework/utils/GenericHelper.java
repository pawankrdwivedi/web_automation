package com.web.automation.framework.utils;

import com.web.automation.framework.exception.WebException;

import java.util.Random;

public class GenericHelper {
    int INITIAL_WAIT_TIME = Integer.parseInt(PropertyReader.getTestBedProperties("initialWaitTime"));


    public int generateRandomNumber(int size) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(size);
    }

    public void initialTimeWait() {
        wait(INITIAL_WAIT_TIME);
    }
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void killChromeInstances() throws WebException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception e) {
            throw new WebException(e.getMessage());
        }
    }

    public String getTriggeredPolicyNumber(String policyNumber) throws WebException {
        String increasedPolicyNumber = "";
        try {
            String lastChr = policyNumber.substring(policyNumber.length() - 1);
            String yearStr = policyNumber.substring(policyNumber.length() - 3, policyNumber.length() - 1);
            int year = Integer.parseInt(yearStr);
            year += 1;
            policyNumber = policyNumber.substring(0, policyNumber.length() - 3);
            increasedPolicyNumber = policyNumber + year + lastChr;
        } catch (Exception e) {
            throw new WebException(e.getMessage());
        }
        return increasedPolicyNumber;
    }
}
