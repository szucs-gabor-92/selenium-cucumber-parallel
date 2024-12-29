# @author szucs-gabor-92 - 2024

Feature: The page contains elements in the shadow dom

  As a user
  I want to navigate to the shadow dom page
  So that I can see elements in the shadow dom

  @SmokeTests
  Scenario: The user can see elements in the shadow dom
    Given the user navigates to the shadow dom page
    When the page is loaded
    Then the first paragraph appears with correct text
    And the second paragraph appears with correct text