Feature: Manage User Detail
  As a User,
  I want to manage user detail,

  Scenario: Successful fo to user detail page with click right button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage User detail Page button
    And  I click user detail button
    Then I should see the homepage user detail

  Scenario: Failed fo to user detail page with click right button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage User detail Page button
    And  I click wrong user detail button
    Then I should not see the user detail





