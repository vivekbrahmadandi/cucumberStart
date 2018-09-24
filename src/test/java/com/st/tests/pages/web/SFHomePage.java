package com.st.tests.pages.web;

import com.taf.test.framework.actions.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * This class contains all the objects related to user home page.
 */
@Getter
public class SFHomePage extends PageObject {

    /**
     * This section contains all the objects present on the SF user home page
     */

    //SF Top navigation bar
    private By imgHomeIcon = By.id("bizXShellHomeIcon-img");

    //SF page body
    private By btnHireAlchemy = By.xpath("//div[@aria-label='Admin Centre']//following::li");
    private By mnuUserLinks = By.id("utilityLinksMenuId-inner");
    private By lnkLogoutFromSF = By.linkText("Log out");


    /**
     * This section contains all the actions which can be performed on the SF user home page
     */
    public boolean isHomeIconDisplayed(){return waitForExpectedElement(imgHomeIcon).isDisplayed();}
    public void clickOnHireAlchemyButton() {waitForExpectedElement(btnHireAlchemy).click();}

    public void switchToSFHomePage(String title){
        getBrowserByPageTitle(title);
        getWebDriver().switchTo().defaultContent();
    }

    public void clickOnMnuUserLinks(){waitForExpectedElement(mnuUserLinks).click();}
    public void clickOnLnkLogoutFromSF(){waitForExpectedElement(lnkLogoutFromSF).click();}

    public void logoutFromSF(){
        clickOnMnuUserLinks();
        clickOnLnkLogoutFromSF();



    }

}
