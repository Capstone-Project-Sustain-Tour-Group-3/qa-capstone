Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage

  Scenario: Failed to login with valid credentials
    Given I am on the login page
    When I enter a wrong username
    And I enter a valid password
    And I click the enter button
    Then I should not see the homepage

  Scenario: Failed to login with valid credentials
    Given I am on the login page
    When I enter a valid username
    And I enter a wrong password
    And I click the enter button
    Then I should not see the homepage


