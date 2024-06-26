#@DeleteUser
#Feature: Delete User
#  As a admin
#  I want to manage user account
#  So that I can access user feature
#
#  @Delete-user
#  Scenario: As a admin I can delete user data
#    Given I set API endpoint for delete user data
#    When I send a DELETE request for delete user data
#    Then I receive status code 200
#    And I received a success delete user message
#
#  @Cannot-delete-user
#  Scenario: As a admin I cannot delete user data with invalid ID
#    Given I set API endpoint for delete user data with invalid ID
#    When I send a DELETE request with invalid user ID
#    Then I receive status code 404
#    And I received an account not found message