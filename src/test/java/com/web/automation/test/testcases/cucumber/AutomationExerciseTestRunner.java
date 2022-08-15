package com.web.automation.test.testcases.cucumber;

import com.web.automation.framework.reader.FileUtils;
import courgette.api.*;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        rerunAttempts = 1,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTitle = "Test Automation Execution Report",
        reportTargetDir = "testreport/cucumber/latest",
        environmentInfo = "browser=Chrome",

        plugin = {CourgettePlugin.EXTENT_REPORTS},
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features/AutomationExercise.feature",
                glue = "com/web/automation/test/stepdef",
                tags = "@Sample",
                publish = false
        ))
public class AutomationExerciseTestRunner extends TestNGCourgette {
    @AfterClass
    public void copyReports() {
        FileUtils.copyCourgetteReportsInHistory();
    }
}

