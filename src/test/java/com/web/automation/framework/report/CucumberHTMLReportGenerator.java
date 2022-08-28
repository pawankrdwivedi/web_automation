package com.web.automation.framework.report;

import com.web.automation.framework.utils.DateHelper;
import com.web.automation.framework.utils.FileUtilities;
import com.web.automation.framework.utils.PropertyReader;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberHTMLReportGenerator {

    private static String JSON_REPORT_FILE = "testreport/cucumber/latest";
    private static String CUCUMBER_REPORT_LOCATION = "testreport/cucumber/latest/cucumber-json-report.json";

    public static void generateCucumberHtmlReport() {
        File reportOutputDirectory = new File(JSON_REPORT_FILE);

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(CUCUMBER_REPORT_LOCATION);
        String projectName = PropertyReader.getTestBedProperties("projectName");

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        // do not make scenario failed when step has status SKIPPED
        //configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));

        // addidtional metadata presented on main page
        configuration.addClassifications("Branch", new DateHelper().getCurrentMonth().toUpperCase() + ": Release");
        configuration.addClassifications("Browser", PropertyReader.getTestBedProperties("browserName").toUpperCase());
        //configuration.addClassifications("Environment", PropertyReader.getTestBedProperties("environment").toUpperCase());

        // optionally add metadata presented on main page via properties file
        //List<String> classificationFiles = new ArrayList<>();
        //classificationFiles.add("properties-1.properties");
        //configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
        // and here validate 'result' to decide what to do if report has failed
        FileUtilities.copyHtmlReportsInHistory();
    }


}
