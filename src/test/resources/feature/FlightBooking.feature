@Flighttest
Feature: Flight booking test
  Scenario: Flight booking test
    Given URL to book from 'https://www.cleartrip.com/'
    And Select one way option
    And User wants to travel from 'Bangalore' to 'Delhi'
    And User Pick any date
    When User clicks on search button
    Then User is present with search results