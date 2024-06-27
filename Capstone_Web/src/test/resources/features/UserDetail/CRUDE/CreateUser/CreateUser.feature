Feature: Create User
  Scenario: Successfuly Create Male User
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage User detail Page button
    And I click create Button
    And I write valid male input
    And I go back to Manage User detail Page

  Scenario: Successfuly Create Female User
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage User detail Page button
    And I click create Button
    And I write valid female input
    And I go back to Manage User detail Page