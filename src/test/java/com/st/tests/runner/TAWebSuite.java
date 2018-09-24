package com.st.tests.runner;



import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/web",tags = {"@uat"},plugin = {"pretty","com.epam.reportportal.cucumber.ScenarioReporter","json:target/cucumber-report/TAWebSuite/cucumber.json",
        "rerun:target/cucumber-report/TAWebSuite/rerun.txt","html:target/cucumber-reports"},glue = "com.st.tests.steps.web",monochrome = true)
public class TAWebSuite {
}