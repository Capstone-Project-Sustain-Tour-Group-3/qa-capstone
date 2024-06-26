#@GetContent
#Feature: Manage Content
#  As a admin
#  I want to manage content
#  So that I can access content feature
#
#  @Get-all-content
#  Scenario: As a admin I can get all content
#    Given I set API endpoint for get all content
#    When I send a GET request for get all content
#    Then I receive status code 200
#    And I received a valid data from all content
#
#  @Get-id-content
#  Scenario: As a admin I can get content by ID
#    Given I set API endpoint for get content by ID
#    When I send a GET request with valid content ID
#    Then I receive status code 200
#    And I received a valid data from selected content
#
#  @Get-invalid-content
#  Scenario: As a admin I cannot get content by invalid ID
#    Given I set API endpoint for get content by invalid ID
#    When I send a GET request with invalid content ID
#    Then I receive status code 404
#    And I received a failed get content message
