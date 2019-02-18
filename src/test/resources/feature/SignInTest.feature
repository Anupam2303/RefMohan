@SignInTest
Feature: Sign in Test
  Scenario Outline: Sign in test
    Given URL to sign in on 'https://www.cleartrip.com/'
    And User click on your trips
    Then Verify login section opens
    And Click on Sign in button
    Then Verify errors '<errorMessages>'
    Examples:
      | errorMessages                             |
      | There were errors in your submission      |
      | Your username is a required field         |
      | Your account password is a required field |