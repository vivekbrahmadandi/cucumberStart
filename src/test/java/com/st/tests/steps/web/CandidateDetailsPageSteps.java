package com.st.tests.steps.web;


import com.st.tests.pages.ScenarioContext;
import com.st.tests.pages.web.CandidateDetailsPage;
import com.st.tests.pages.web.UserHomePage;
import com.taf.test.framework.helpers.WebDriverHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidateDetailsPageSteps {

    private CandidateDetailsPage candidateDetailsPage;
    private ScenarioContext scenarioContext;

    public CandidateDetailsPageSteps(CandidateDetailsPage candidateDetailsPage,ScenarioContext scenarioContext) {
        this.candidateDetailsPage = candidateDetailsPage;
        this.scenarioContext = scenarioContext;
    }

    @Then("^user should be able to see the position title in the candidate details page$")
    public void userShouldBeAbleToSeeThePositionTitleInTheCandidateDetailsPage() throws Throwable {
       assertThat(candidateDetailsPage.getPositionTitle().equalsIgnoreCase(scenarioContext.getTxtPositionName()));
    }

    @When("^user applies the freshness filter with filter level \"([^\"]*)\"$")
    public void userAppliesTheFreshnessFilterWithFilterLevel(String freshneshFilterLevel) throws Throwable {
       candidateDetailsPage.selectFreshnessElementLabel(freshneshFilterLevel);
    }

    @Then("^user should be able to see the selection of freshness filter with level \"([^\"]*)\"$")
    public void userShouldBeAbleToSeeTheSelectionOfFreshnessFilterWithLevel(String freshneshFilterLevel) throws Throwable {
        assertThat(candidateDetailsPage.isFreshnessElementLabelSelected(freshneshFilterLevel));
    }

    @And("^user clicks the refresh button on the candidate details page$")
    public void userClicksTheRefreshButtonOnTheCandidateDetailsPage() throws Throwable {
        candidateDetailsPage.clickCandidatePageRefreshBtn();
    }

    @Then("^user should be able to see the de-selection of freshness filter with level \"([^\"]*)\"$")
    public void userShouldBeAbleToSeeTheDeSelectionOfFreshnessFilterWithLevel(String freshneshFilterLevel) throws Throwable {
        assertThat(!(candidateDetailsPage.isFreshnessElementLabelSelected(freshneshFilterLevel)));
    }

    @And("^user should be on the tab \"([^\"]*)\"$")
    public void userShouldBeOnTheTab(String tabName) throws Throwable {
        assertThat(candidateDetailsPage.getSelectedTabName().equalsIgnoreCase(tabName));
    }

    @And("^user expands the filter section \"([^\"]*)\"$")
    public void userExpandsTheFilterSection(String filterText) throws Throwable {
       candidateDetailsPage.expandFilterCriteria(filterText);
    }

    @Then("^user should be able to see the relevancy score in the candidate card$")
    public void userShouldBeAbleToSeeTheRelevancyScoreInTheCandidateCard() throws Throwable {
      assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardScore()).getText().contains("%"));
    }

    @Then("^user should be able to see the candidate's name in the card$")
    public void userShouldBeAbleToSeeTheCandidateSNameInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardName()).getText().length()>=2);
    }

    @Then("^user should be able to see the candidate's job title in the card$")
    public void userShouldBeAbleToSeeTheCandidateSJobTitleInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardJobTitle()).getText().length()>=2);
    }

    @Then("^user should be able to see the candidate's current employer name in the card$")
    public void userShouldBeAbleToSeeTheCandidateSCurrentEmployerNameInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardCurrentEmployer()).getText().length()>=2);
    }

    @Then("^user should be able to see the candidate's experience in the card$")
    public void userShouldBeAbleToSeeTheCandidateSExperienceInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardExperience()).getText().length()>=2);
    }

    @Then("^user should be able to see the candidate's current job location in the card$")
    public void userShouldBeAbleToSeeTheCandidateSCurrentJobLocationInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardCurrentLocation()).getText().length()>=2);
    }

    @Then("^user should be able to see the candidate's current salary in the card$")
    public void userShouldBeAbleToSeeTheCandidateSCurrentSalaryInTheCard() throws Throwable {
        assertThat(candidateDetailsPage.getElementByby(candidateDetailsPage.getLblFirstCandidateCardCurrentCurrentSalary()).getText().length()>=2);
    }

}
