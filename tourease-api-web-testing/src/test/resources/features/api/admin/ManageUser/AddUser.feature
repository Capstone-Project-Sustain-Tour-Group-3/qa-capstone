@AddUser
Feature: Manage User
  As a admin
  I want to manage user account
  So that I can access user feature

  @Add-user
  Scenario: As a admin I can add user data
    Given I set API endpoint for add user data
    When I send a POST request for add user data
    Then I receive status code 201
    And I received a valid data from new user

  @Cannot-add-user-without-data
  Scenario: As a admin I cannot add user data without body data
    Given I set API endpoint for add user data
    When I send a POST request for add user data without body data
    Then I receive status code 400
    And I received a failed add user message

  @Cannot-add-user-invalid-profile
  Scenario: As a admin I cannot add user data with invalid profile picture format
    Given I set API endpoint for add user data
    When I send a POST request for add user data with invalid profile picture format
    Then I receive status code 400
    And I received a failed add user message

  @Cannot-add-user-invalid-username
  Scenario: As a admin I cannot add user data with an already registered username
    Given I set API endpoint for add user data
    When I send a POST request for add user data with an already registered username
    Then I receive status code 400
    And I received a failed username or email already in use message

  @Cannot-add-user-invalid-email
  Scenario: As a admin I cannot add user data with an already registered email
    Given I set API endpoint for add user data
    When I send a POST request for add user data with an already registered email
    Then I receive status code 400
    And I received a failed username or email already in use message