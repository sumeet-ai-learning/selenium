Feature: Login

  @smoke @login
  Scenario: Successful login
    Given I am on the login page
    When I enter username "admin"
    And I enter password "password"
    And I click login
    Then I should be logged in successfully

  @negative @login
  Scenario: Invalid password
    Given I am on the login page
    When I enter username "admin"
    And I enter password "wrong123"
    And I click login
    Then an error message should be displayed

  @negative
  Scenario: Empty credentials
    Given I am on the login page
    When I click login
    Then a validation message should be shown
