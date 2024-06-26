@GetUser
Feature: Manage Admin
  As a super admin
  I want to manage admin account
  So that I can access admin detail

  @Get-all-admin
  Scenario: As a super admin I can get all admin detail
    Given I set API endpoint for get all admin detail
    When I send a GET request for get all admin detail
    Then I receive status code 200
    And I received a valid data from all admin

  @Get-id-admin
  Scenario: As a super admin I can get admin detail by ID
    Given I set API endpoint for get admin detail by ID
    When I send a GET request with valid admin ID
    Then I receive status code 200
    And I received a valid data from selected admin

  @Get-invalid-admin
  Scenario: As a super admin I cannot get admin detail by invalid ID
    Given I set API endpoint for get admin detail by invalid ID
    When I send a GET request with invalid admin ID
    Then I receive status code 404
    And I received a failed get admin message