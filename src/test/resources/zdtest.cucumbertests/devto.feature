Feature: basic dev to functionalities
  Scenario: Select first podcast and play it
    Given DevTo main page is open
    When User clicks on podcasts
    And User selects first podcast
    Then User can see its title
    And User can play it

  Scenario: Select first video page
    Given DevTo main page is open
    When User clicks on videos
    And User selects first video
    Then User is redirected to the first video page

   Scenario: Search "testing" in search bar and check if first three results contain word "testing"
     Given DevTo main page is open
     When User search "testing"
     Then Top result should contain the word "testing"