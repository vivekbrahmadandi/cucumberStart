@gui @singlesignon @uat
Feature: Single sign on
  As a user
  I should be able to access HireAlchemy portal
  through Successportal using single sign on

  Scenario Outline: Check whether user is able to login and navigate successfully using success factor portal
    This scenario covers 3 test cases under Single sign on section: "Validate User Login", "Validate User Logout" and "Link To Hirealchemy"
    Given user launches portal
    And user enters company id "<companyId>"
    When user clicks on button to submit company id
    Then user should see successfactor login box
    And user enters successfactor user name "<username>"
    And user enters successfactor password "<password>"
    When user clicks on successfactor sign in button
    Then user should be logged in successfully to successfactor portal
    And user clicks on HireAlchemy tile in successfactor home page
    Then user should be navigated to "HIREalchemy" tab from successfactor page
    And user logs out from Hirealchemy
    And user switches back to successfactor "Home" tab
    Then user clicks on successfactor logout link
    Examples:
      | companyId | username                | password         |
      | singtelT1 | ZV_EDGEGRAPH_Recruiter1 | Singtel@20180720 |

