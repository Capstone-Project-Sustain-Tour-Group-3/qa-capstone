#@DeleteUser
#Feature: Delete Route
#  As a admin
#  I want to manage user route
#  So that I can access user route
#
#  @Delete-route
#  Scenario: As a admin I can delete route
#    Given I set API endpoint for delete route
#    When I send a DELETE request for delete route
#    Then I receive status code 200
#    And I received a success delete route message
#
#  @Cannot-delete-route
#  Scenario: As a admin I cannot delete route with invalid ID
#    Given I set API endpoint for delete route with invalid ID
#    When I send a DELETE request with invalid route ID
#    Then I receive status code 404
#    And I received a route not found message