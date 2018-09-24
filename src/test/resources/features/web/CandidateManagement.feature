@gui @candidatemanagement @uat
Feature: Candidate management
  As a user
  I should be able to see and manage required information
  on the candidate listing page

  Scenario Outline: Check whether candidate list is being displayed correctly for a position
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
    And user enters position id "<positionId>" in position search box
    Then user should be able to see the position related to "<positionId>"
    When user clicks on first item in displayed position list related to position id "<positionId>"
    Then user should be able to see the position title in the candidate details page
    And user should be on the tab "Initial Pool"
    And user expands the filter section "Freshness"
    When user applies the freshness filter with filter level "<freshnessFilterLevel>"
    Then user should be able to see the selection of freshness filter with level "<freshnessFilterLevel>"
    And user clicks the refresh button on the candidate details page
    Then user should be able to see the de-selection of freshness filter with level "<freshnessFilterLevel>"
    And user logs out from Hirealchemy
    And user switches back to successfactor "Home" tab
    Then user clicks on successfactor logout link
    Examples:
      | companyId | username                | password         | positionId | freshnessFilterLevel |
      | singtelT1 | ZV_EDGEGRAPH_Recruiter1 | Singtel@20180720 | 81801      | 1 year               |

  Scenario Outline: Check whether candidate card has all the required fields with values
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
    And user enters position id "<positionId>" in position search box
    Then user should be able to see the position related to "<positionId>"
    When user clicks on first item in displayed position list related to position id "<positionId>"
    Then user should be able to see the position title in the candidate details page
    Then user should be able to see the relevancy score in the candidate card
    Then user should be able to see the candidate's name in the card
    Then user should be able to see the candidate's job title in the card
    Then user should be able to see the candidate's current employer name in the card
    Then user should be able to see the candidate's experience in the card
    Then user should be able to see the candidate's current job location in the card
    Then user should be able to see the candidate's current salary in the card
    And user logs out from Hirealchemy
    And user switches back to successfactor "Home" tab
    Then user clicks on successfactor logout link
    Examples:
      | companyId | username                | password         | positionId | freshnessFilterLevel |
      | singtelT1 | ZV_EDGEGRAPH_Recruiter1 | Singtel@20180720 | 81801      | 1 year               |
