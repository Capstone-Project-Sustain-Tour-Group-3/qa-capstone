Feature: Manage User Route
  As a User,
  I want to manage detail route,

  Scenario: Successful to detail route page with click right button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage detail route Page button
    And  I click detail route button
    Then I should see the homepage detail route

  Scenario: Successful to detail route page with click right button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click wrong Manage detail route Page button
    And  I click detail route button
    Then I should not see the homepage detail route





