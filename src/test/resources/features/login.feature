Feature: User should be able to

  Background:
    Given the user is on home page
  @emin
  Scenario: Try to Login as unauthorized
    When the user should not be able to login with invalid "email" valid "password"
    Then error message should be displayed


  Scenario: Try to Login as unauthorized
    And the user should not be able to login with blank "email"
    Then Required field message should be displayed under "email" textBox


