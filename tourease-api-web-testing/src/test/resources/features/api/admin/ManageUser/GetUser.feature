@GetUser
Feature: Manage User
  As a admin
  I want to manage user account
  So that I can access user feature

  @Get-all-user
  Scenario: As a admin I can get all user detail
    Given I set API endpoint for get all user detail
    When I send a GET request for get all user detail
    Then I receive status code 200
    And I received a valid data from all user

  @Get-id-user
  Scenario: As a admin I can get user detail by ID
    Given I set API endpoint for get user detail by ID
    When I send a GET request with valid user ID
    Then I receive status code 200
    And I received a valid data from selected user

  @Get-invalid-user
  Scenario: As a admin I cannot get user detail by invalid ID
    Given I set API endpoint for get user detail by invalid ID
    When I send a GET request with invalid user ID
    Then I receive status code 404
    And I received a failed get user message
