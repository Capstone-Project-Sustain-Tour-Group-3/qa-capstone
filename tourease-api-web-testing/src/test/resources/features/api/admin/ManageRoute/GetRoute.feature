#@GetRoute
#Feature: Manage Route
#  As a admin
#  I want to manage user route
#  So that I can access user route
#
#  @Get-user-route
#  Scenario: As a admin I can get all route
#    Given I set API endpoint for get all route
#    When I send a GET request for get all route
#    Then I receive status code 200
#    And I received a valid data from all route
#
#  @Get-id-route
#  Scenario: As a admin I can get route by ID
#    Given I set API endpoint for get user route by ID
#    When I send a GET request with valid route ID
#    Then I receive status code 200
#    And I received a valid data from selected route
#
#  @Get-invalid-route
#  Scenario: As a admin I cannot get route by invalid ID
#    Given I set API endpoint for get route by invalid ID
#    When I send a GET request with invalid route ID
#    Then I receive status code 404
#    And I received a failed get route message
