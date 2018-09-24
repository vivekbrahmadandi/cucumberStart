package com.st.tests.steps.web;


import com.taf.test.framework.helpers.UrlBuilder;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class NavigationSteps {

    @Given("^user launches hire alchemy portal$")
    public void userLaunchesHireAlchemyPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }


    @Given("^user launches portal$")
    public void userLaunchesPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }
}