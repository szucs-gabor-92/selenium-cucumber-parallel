# @author szucs-gabor-92 - 2024

Feature: A new element can be added and deleted

  As a user
  I want to navigate to the add or remove element page
  So that I can add and remove a new element on the page

  @SmokeTests
  Scenario Outline: The user can add new elements and remove them
    Given the user navigates to the add or remove element page
    And the user clicks on the add element button 'count' times
      | variable | value   |
      | count    | <count> |
    And the correct number of delete element buttons appears on the page
    When the user clicks on the delete button 'count' times
      | variable | value   |
      | count    | <count> |
    Then the elements disappear

    Examples:
      | count |
      | 1     |
      | 2     |
      | 3     |