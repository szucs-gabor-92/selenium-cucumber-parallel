# @author szucs-gabor-92 - 2024

Feature: The checkboxes can be selected and deselected

  As a user
  I want to navigate to the checkboxes page
  So that I can select and deselect checkboxes

  @SmokeTests
  Scenario: The user can select and deselect checkboxes
    Given the user navigates to the checkboxes page
    And the first checkbox is not selected
    And the second checkbox is selected
    When the user clicks on the first checkbox
    And the user clicks on the second checkbox
    Then the first checkbox is selected
    And the second checkbox is not selected