package com.st.tests.steps.web;


import com.st.tests.pages.web.SFHomePage;
import com.st.tests.pages.web.UserHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SFHomePageSteps {

    private SFHomePage sfHomePage;

    public SFHomePageSteps(SFHomePage sfHomePage) {
        this.sfHomePage = sfHomePage;
    }

    @Then("^user should be logged in successfully to successfactor portal$")
    public void userShouldBeLoggedInSuccessfullyToSuccessfactorPortal() throws Throwable {
        assertThat(sfHomePage.isHomeIconDisplayed());
    }

    @And("^user clicks on HireAlchemy tile in successfactor home page$")
    public void userClicksOnHireAlchemyTileInSuccessfactorHomePage() throws Throwable {
        sfHomePage.clickOnHireAlchemyButton();
    }

    @And("^user switches back to successfactor \"([^\"]*)\" tab$")
    public void userSwitchesBackToSuccessfactorTab(String title) throws Throwable {
        sfHomePage.switchToSFHomePage(title);
    }

    @Then("^user clicks on successfactor logout link$")
    public void userClicksOnSuccessfactorLogoutLink() throws Throwable {
        sfHomePage.logoutFromSF();
    }
}
