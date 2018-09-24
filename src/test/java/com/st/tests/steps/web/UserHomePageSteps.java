package com.st.tests.steps.web;


import com.st.tests.pages.ScenarioContext;
import com.st.tests.pages.web.UserHomePage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UserHomePageSteps {

    private UserHomePage userHomePage;
    private ScenarioContext scenarioContext;

    public UserHomePageSteps(UserHomePage userHomePage, ScenarioContext scenarioContext) {
        this.userHomePage = userHomePage;
        this.scenarioContext = scenarioContext;
    }

    @Then("^user is able to see the navigation bar and logo$")
    public void userIsAbleToSeeTheNavigationBarAndLogo() throws Throwable {
        assertThat(userHomePage.isImgLogoDisplayed());
    }


    @And("^user is also able to see the drop down button with his/her \"([^\"]*)\"$")
    public void userIsAlsoAbleToSeeTheDropDownButtonWithHisHer(String initials) throws Throwable {
        assertThat(userHomePage.getMnuHeaderDPInitials()).isEqualToIgnoringCase(initials);
    }
    @And("^user logs out from Hirealchemy$")
    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        assertThat(userHomePage.logOut());
    }

    @Then("^user is able to login successfully$")
    public void userIsAbleToLoginSuccessfully() throws Throwable {
        assertThat(userHomePage.getMsgToastSuccessText()).isEqualToIgnoringCase("Login successful");
    }

    @Given("^user navigates to \"([^\"]*)\" page$")
    public void userNavigatesToPage(String pageName) throws Throwable {
            assertThat(userHomePage.navigateToPages(pageName));
            }

    @Then("^user should be navigated to \"([^\"]*)\" tab from successfactor page$")
    public void userShouldBeNavigatedToTabFromSuccessfactorPage(String title) throws Throwable {
        userHomePage.switchToHireAlchemyPage(title);
        userIsAbleToSeeTheNavigationBarAndLogo();

    }


    @And("^user enters position id \"([^\"]*)\" in position search box$")
    public void userEntersPositionIdInPositionSearchBox(String positionId) throws Throwable {
        userHomePage.searchPosition(positionId);
    }

    @Then("^user should be able to see the position related to \"([^\"]*)\"$")
    public void userShouldBeAbleToSeeThePositionRelatedTo(String positionId) throws Throwable {
        assertThat(userHomePage.isPositionWithIdIsDisplayed(positionId));
        scenarioContext.setTxtPositionName(userHomePage.getPositionNameByPositionId(positionId));
    }


    @When("^user clicks on first item in displayed position list related to position id \"([^\"]*)\"$")
    public void userClicksOnFirstItemInDisplayedPositionListRelatedToPositionId(String positionId) throws Throwable {
       userHomePage.clickOnfirstPositionByText(positionId);
    }
}
