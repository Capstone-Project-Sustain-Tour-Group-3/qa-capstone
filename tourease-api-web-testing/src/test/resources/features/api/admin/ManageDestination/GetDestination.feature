@GetRoute
Feature: Manage Destination
  As a admin
  I want to manage destination
  So that I can access destination feature

  @Get-destination
  Scenario: As a admin I can get all destination
    Given I set API endpoint for get all destination
    When I send a GET request for get all destination
    Then I receive status code 200
    And I received a valid data from all destination

  @Get-id-destination
  Scenario: As a admin I can get destination by ID
    Given I set API endpoint for get destination by ID
    When I send a GET request with valid destination ID
    Then I receive status code 200
    And I received a valid data from selected destination

  @Get-invalid-route
  Scenario: As a admin I cannot get destination by invalid ID
    Given I set API endpoint for get destination by invalid ID
    When I send a GET request with invalid destination ID
    Then I receive status code 404
    And I received a failed get destination message