package com.st.tests.pages.web;

import com.taf.test.framework.actions.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class contains all the objects related to candidate details page.
 */
@Getter
public class CandidateDetailsPage extends PageObject {

    /**
     * This section contains all the objects present on the candidate details page
     */
    //Common element
    private By loader = By.className("overlay-masq");
    private By refreshSpinner = By.cssSelector("i.refresh-icon-spinning-animation");
    //Candidate details section
    private By tabSelectedTab = By.cssSelector("li.nav-tabs__item--active>a");
    private By cardCandidateDetailsCard = By.cssSelector("div.candidate-card");
    private By lblPositionTitle = By.cssSelector("section.project-details>div>div>h2");
    private By btnRefreshCandidates = By.cssSelector("button[title='Refresh']");

    //Candidate details filters section
    private By btnFilterCriteria(String filterText){
        return By.xpath("//h3[@class='filter-title'][contains(text(),'"+filterText+"')]");
    }
    private By lblFreshnessLabels = By.cssSelector("span.freshness-bucket");


    //Specific card details to check the format and data --- for all other purpose generics should be utilised
    private By lblFirstCandidateCardScore = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@class,'candidate__score')]");
    private By lblFirstCandidateCardName = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@class,'candidate__name')]");
    private By lblFirstCandidateCardJobTitle = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@ng-bind,'resume_title')]");
    private By lblFirstCandidateCardCurrentEmployer = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@ng-bind,'current_employer')]");
    private By lblFirstCandidateCardExperience = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@ng-bind,'exp_years')]");
    private By lblFirstCandidateCardCurrentLocation = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@ng-bind,'location')]");
    private By lblFirstCandidateCardCurrentCurrentSalary = By.xpath("(//div[contains(@class,'candidate-card')])[1]//span[contains(@ng-bind,'current_salary')]");


    /**
     * This section contains all the actions which can be performed on the candidate details page
     */
    public String getSelectedTabName(){
        invisibilityOfElementLocated(loader);
        return getWebDriver().findElement(tabSelectedTab).getAttribute("title");
    }
    public List<WebElement> getCandidateCardsDisplayed(){
        return getWebDriver().findElements(cardCandidateDetailsCard);
    }
    public boolean areCandidateCardsDisplayed(){
        boolean areCandidateCardsDisplayed = false;
        try{
            List<WebElement> cardList = getWebDriver().findElements(cardCandidateDetailsCard);
            areCandidateCardsDisplayed = true;
            return areCandidateCardsDisplayed;
        }
        catch(Exception e){
            areCandidateCardsDisplayed = false;
            return areCandidateCardsDisplayed;
        }
    }

    public String getPositionTitle(){
        return waitForExpectedElement(lblPositionTitle).getText().trim();
    }

    public void expandFilterCriteria(String filterText){
        waitForExpectedElement(btnFilterCriteria(filterText)).click();
    }
    public WebElement getFreshnessElementLabel(String freshnessLevel){
        List<WebElement> freshnessElements = getWebDriver().findElements(lblFreshnessLabels);
        WebElement freshnessElement = null;
        for (WebElement element:freshnessElements) {
            if(element.getText().equalsIgnoreCase(freshnessLevel)){
                freshnessElement = element;
            }

        }
        return freshnessElement;
    }

    public void selectFreshnessElementLabel(String freshnessLevel){
        getFreshnessElementLabel(freshnessLevel).click();
    }

    public boolean isFreshnessElementLabelSelected(String freshnessLevel){
        return getFreshnessElementLabel(freshnessLevel).getAttribute("class").contains("bucket-selected");
    }

    public void clickCandidatePageRefreshBtn(){
        waitForExpectedElement(btnRefreshCandidates).click();
        try {
            invisibilityOfElementLocated(refreshSpinner);
        }
        catch (Exception e){}
    }

    public WebElement getElementByby(By by){
        return waitForExpectedElement(by);
    }
}
