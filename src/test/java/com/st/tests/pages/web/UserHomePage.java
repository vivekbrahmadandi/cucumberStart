package com.st.tests.pages.web;

import com.taf.test.framework.actions.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * This class contains all the objects related to user home page.
 */
@Getter
public class UserHomePage extends PageObject {

    /**
     * This section contains all the objects present on the user home page
     */
    //Common element
    private By loader = By.className("overlay-masq");
    //Top navigation bar
    private By msgToastSuccess = By.xpath("//div[@class='toast-message']");
    private By mnuHeaderDP = By.className("header-dp");
    private By imgLogo = By.id("logo");
    private By lnkPositions = By.xpath("//a[contains(string(),'Positions')]");
    private By lnkResumePool = By.xpath("//a[contains(string(),'Resume Pool')]");
    private By lnkRoles = By.xpath("//a[contains(string(),'Roles')]");
    private By lnkTemplates = By.xpath("//a[contains(string(),'Templates')]");
    private By lnkAdmin = By.xpath("//a[contains(string(),'Admin')]");
    private By subLinkAllTemplates = By.xpath("//a[contains(string(),'All Templates')]");
    private By subLinkCreateEditTemplates = By.xpath("//a[contains(string(),'Create/Edit Templates')]");
    private By btnCreate = By.xpath("//a[contains(string(),'Create')]");
    private By subLnkCreateProject = By.xpath("//a[contains(string(),'Create Project')]");
    private By subLnkCreatePosition = By.xpath("//a[contains(string(),'Create Position')]");
    private By subLnkMyProfile = By.xpath("//a[contains(string(),'My Profile')]");
    private By subLnkSource = By.xpath("//a[contains(string(),'Source')]");
    private By subLnkSettings = By.xpath("//a[contains(string(),'Settings')]");
    private By subLnkLogout = By.xpath("//a[contains(string(),'Logout')]");

    //Position search section
    private By txtSearchPosition = By.xpath("//input[@ng-model='position_form.search_key']");


    /**
     * This section contains all the actions which can be performed on the user home page
     */
    public String getMnuHeaderDPInitials() {
        return waitForExpectedElement(mnuHeaderDP).getAttribute("data-username");
    }

    public boolean isImgLogoDisplayed() {
        return waitForExpectedElement(imgLogo).isDisplayed();
    }

    public String getMsgToastSuccessText() {
        return waitForExpectedElement(msgToastSuccess).getText();
    }

    public boolean logOut() {
        try {

            invisibilityOfElementLocated(loader);
            elementToBeClickable(mnuHeaderDP);
            waitForExpectedElement(mnuHeaderDP).click();
            waitForExpectedElement(subLnkLogout).click();
            getWebDriver().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean navigateToPages(String pageName) {
        boolean clickPerformed = false;
        switch (pageName.toLowerCase()) {
            case "positions":
                waitForExpectedElement(lnkPositions).click();
                clickPerformed = true;
                break;
            case "resume pool":
                waitForExpectedElement(lnkResumePool).click();
                clickPerformed = true;
                break;
            case "admin":
                waitForExpectedElement(lnkAdmin).click();
                clickPerformed = true;
                break;
            default:
                System.out.println("Provided page doesn't exist");
                break;
        }
        return clickPerformed;
    }

    public void switchToHireAlchemyPage(String title) {
        getBrowserByPageTitle(title);
    }

    public void searchPosition(String positionDetail) {
        waitClearEnterText(txtSearchPosition, positionDetail);
    }

    public void clickOnfirstPositionByText(String positionDetail) {
        try {
            elementToBeClickable(By.xpath("(//h4[@class='position-name']//a[contains(text(),'" + positionDetail + "')])[1]"));
            waitForExpectedElement(By.xpath("(//h4[@class='position-name']//a[contains(text(),'" + positionDetail + "')])[1]")).click();}

        catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public boolean isPositionWithIdIsDisplayed (String positionId){
            try {
                return getWebDriver().findElement(By.xpath("//h4[@class='position-name']//a[contains(text(),'" + positionId + "')]")).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
        public String getPositionNameByPositionId (String positionId){
            try {
                return (getWebDriver().findElement(By.xpath("//h4[@class='position-name']//a[contains(text(),'" + positionId + "')]")).getText().split(" = ", 2))[1];
            } catch (Exception e) {
                return "Positon not found";
            }
        }

    }
