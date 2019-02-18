@BookRoundTripTicket
  Feature: To book a round trip ticket
    Scenario:
      Given URL to book from 'https://www.cleartrip.com/'
      And Select two way option
      And User wants to travel from 'Bangalore' to 'Delhi'
      And User Pick any date
      When User clicks on search button
      Then Verify user is on search result page
      And User is present with search results
      Then User clicks on book button
