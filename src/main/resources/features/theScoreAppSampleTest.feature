Feature: The Score App Sample Automation Test

  @sampleTest
  Scenario: Verify that the app setup and search functionalities are working as expected
    Given User launches the score app
    When User clicks on get started
    And User selects favorite league as 'NBA Basketball'
    And User selects favorite team as 'San Antonio Spurs'
    And User finalizes notification preferences
    And User searches for team 'Toronto Maple Leafs'
    And Verify that the team 'Toronto Maple Leafs' details are displayed
    And User selects Schedule tab
    And Verify that the team schedule is displayed
    And User navigates back in the app
    And Verify that the user is navigated back to search results