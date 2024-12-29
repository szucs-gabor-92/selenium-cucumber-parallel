# @author szucs-gabor-92 - 2024

Feature: The login and logout functionality works

  As a user
  I want to navigate to the login page
  So that I can fill out the login information and log in

  @SmokeTests
  Scenario Outline: The user can log in
    Given the user navigates to the login page
    And the user fills out the username field with 'username'
      | variable | value      |
      | username | <username> |
    And the user fills out the password field with 'password'
      | variable | value      |
      | password | <password> |
    When the user clicks on the login button
    Then the error message 'error' appears
      | variable | value   |
      | error    | <error> |

    Examples:
      | username | password             | error                        |
      | test     | SuperSecretPassword! | Your username is invalid!\n× |
      | tomsmith | SuperSecretPassword  | Your password is invalid!\n× |

  @SmokeTests
  Scenario Outline: The user can log out
    Given the user navigates to the login page
    And the user fills out the username field with 'username'
      | variable | value      |
      | username | <username> |
    And the user fills out the password field with 'password'
      | variable | value      |
      | password | <password> |
    And the user clicks on the login button
    And the user is successfully logged in
    When the user clicks on the logout button
    Then the user is successfully logged out

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |