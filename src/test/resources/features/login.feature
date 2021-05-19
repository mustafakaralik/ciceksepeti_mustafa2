Feature: User should be able to

  Background:
    Given the user is on home page

  Scenario: Try to Login as unauthorized
    When the user should not be able to login with invalid "username" valid "password"
    Then error message should be displayed