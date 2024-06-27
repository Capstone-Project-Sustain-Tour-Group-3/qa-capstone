Feature: See Content Detail
  As a User,
  I want to see content detail,
  and I click login with valid email,
  and I click Manage Content Page button,
  and I click I click Manage Content Page button
  and I click I click content detail button
  So, that I should see the content detail page

  Scenario: Successful to see content detail page with click right button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage Content Page button
    And  I click content detail button
    Then I should see the content detail page

  Scenario: Successful to detail route page with wrong button
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the enter button
    Then I should see the homepage
    When I click Manage Content Page button
    And  I click wrong content detail page
    Then I should not see content detail page




