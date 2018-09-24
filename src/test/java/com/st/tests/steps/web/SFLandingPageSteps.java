package com.st.tests.steps.web;


import com.st.tests.pages.web.LandingPage;
import com.st.tests.pages.web.SFLandingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SFLandingPageSteps {

    private SFLandingPage sfLandingPage;

    public SFLandingPageSteps(SFLandingPage sfLandingPage) {
        this.sfLandingPage = sfLandingPage;
    }

    @And("^user enters company id \"([^\"]*)\"$")
    public void userEntersCompanyId(String companyId) throws Throwable {
        if (sfLandingPage.checkWhetherEnterCompanyIdPageIsDisplayed()) {
            sfLandingPage.clickOnEnterDifferentCompanyId();
        }
            sfLandingPage.enterCompanyId(companyId);

    }


    @When("^user clicks on button to submit company id$")
    public void userClicksOnButtonToSubmitCompanyId() throws Throwable {
        sfLandingPage.clickOnSubmitCompanyId();
    }

    @Then("^user should see successfactor login box$")
    public void userShouldSeeSuccessfactorLoginBox() throws Throwable {
        assertThat(sfLandingPage.isTxtSFUserNameDisplayed());
        assertThat(sfLandingPage.elementToBeClickable(sfLandingPage.getTxtSFUserName()));
    }

    @And("^user enters successfactor user name \"([^\"]*)\"$")
    public void userEntersSuccessfactorUserName(String username) throws Throwable {
        sfLandingPage.enterSFUserName(username);
    }

    @And("^user enters successfactor password \"([^\"]*)\"$")
    public void userEntersSuccessfactorPassword(String password) throws Throwable {
        sfLandingPage.enterSFPassword(password);
    }

    @When("^user clicks on successfactor sign in button$")
    public void userClicksOnSuccessfactorSignInButton() throws Throwable {
        sfLandingPage.clickOnSFLogin();
    }
}