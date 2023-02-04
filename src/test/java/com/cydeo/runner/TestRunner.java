package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/json/cucumber-report.json"}, 
		features = {"src/test/resources/features" },
		glue = { "com/cydeo/stepdefs" },
		tags = "@smoke",
		dryRun = false, monochrome = true, publish =false)

public class TestRunner {

	@AfterClass
	public static void reportSetup() throws IOException {

		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target\\json\\cucumber-report.json");
		//jsonFiles.add("cucumber-report-2.json");

		String buildNumber = "1";
		String projectName = "My_Project_Name";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Firefox");
		configuration.addClassifications("Branch", "release/1.0");

//		// optionally add metadata presented on main page via properties file
//		List<String> classificationFiles = new ArrayList<>();
//		classificationFiles.add("properties-1.properties");
//		//classificationFiles.add("properties-2.properties");
//		configuration.addClassificationFiles(classificationFiles);
//
//		// optionally specify qualifiers for each of the report json files
//		        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//		        configuration.setQualifier("cucumber-report-1","First report");
//		        //configuration.setQualifier("cucumber-report-2","Second report");

		        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
		        Reportable result =reportBuilder.generateReports();
		// and here validate 'result' to decide what to do if report has failed

	}
}
