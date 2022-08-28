package com.web.automation.test.testcases.cucumber;

import com.web.automation.framework.report.CucumberHTMLReportGenerator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ToDoMVC.feature"},
        glue = {"com/web/automation/test/stepdef"},
        tags = "@Test",
        publish = false,
        plugin= {"json:testreport/cucumber/latest/cucumber-json-report.json"} ,
        monochrome= true
)

public class ToDoMVCJunitRunner {

    @AfterClass
    public static void generateReport() {
        CucumberHTMLReportGenerator.generateCucumberHtmlReport();
    }
}


