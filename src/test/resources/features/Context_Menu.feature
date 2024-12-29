# @author szucs-gabor-92 - 2024

Feature: The context menu opens a javascript alert

  As a user
  I want to navigate to the context menu page
  So that I can right click on the hot-spot and receive an alert

  @SmokeTestsInactive
  Scenario: The user can trigger a javascript alert
    Given the user navigates to the context menu page
    And the alert is not present on the page
    When the user right clicks on the hotspot
    Then the javascript alert appears with correct text
    And the alert is accepted
    And the alert disappears