package com.st.tests.pages.web;

import com.taf.test.framework.actions.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * This class contains all the objects related to success factor landing page.
 */
@Getter
public class SFLandingPage extends PageObject {

    /**
     * This section contains all the objects present on the landing and login page
     */

    //Company id section
    private By txtCompanyId = By.id("__input0-inner");
    private By btnSubmitCompanyId = By.id("__button0");

    //Login section
    private By lnkEnterDifferentCompanyId = By.linkText("enter a different company ID");
    private By txtSFUserName = By.id("__input1-inner");
    private By txtSFPassword = By.id("__input2-inner");
    private By btnSFLogin = By.id("__button2-inner");


    /**
     * This section contains all the actions which can be performed on the success factor landing and login page
     */
    public boolean checkWhetherEnterCompanyIdPageIsDisplayed(){
        try{
            return waitForExpectedElement(lnkEnterDifferentCompanyId,5).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickOnEnterDifferentCompanyId(){
        waitForExpectedElement(lnkEnterDifferentCompanyId).click();
    }

    public void enterCompanyId(String companyId) {
        waitForExpectedElement(txtCompanyId).sendKeys(companyId);
    }
    public void clickOnSubmitCompanyId() {
        waitForExpectedElement(btnSubmitCompanyId).click();
    }
    public boolean isTxtSFUserNameDisplayed() {
        return waitForExpectedElement(txtSFUserName).isDisplayed();
    }
    public void enterSFUserName(String userName) {
        waitForExpectedElement(txtSFUserName).sendKeys(userName);
    }
    public void enterSFPassword(String password) {
        waitForExpectedElement(txtSFPassword).sendKeys(password);
    }
    public void clickOnSFLogin() {
        waitForExpectedElement(btnSFLogin).click();
    }

    /**
     * @param companyId SF company id
     * @param userName SF user name
     * @param password SF password
     */
    public void loginToSF(String companyId,String userName,String password) {
        enterCompanyId(companyId);
        clickOnSubmitCompanyId();
        enterSFUserName(userName);
        enterSFPassword(password);
        clickOnSFLogin();

    }

}
