#@Authentication
#Feature: Authentication
#  As a admin
#  I want to perform authentication
#  So that I can access all feature
#
#  @Login
#  Scenario: As a admin I can login with valid credentials
#    Given I set API endpoint for login
#    When I send a POST request with valid user credentials
#    Then I receive status code 200
#    And I successfully logged in to the account
#
#  @Invalid-username
#  Scenario: As a admin I cannot login with invalid username
#    Given I set API endpoint for login
#    When I send a POST request with invalid username
#    Then I receive status code 409
#    And I received a failed admin login message
#
#  @Invalid-password
#  Scenario: As a admin I cannot login with invalid password
#    Given I set API endpoint for login
#    When I send a POST request with invalid password
#    Then I receive status code 409
#    And I received a failed admin login message
#
#  @Logout
#  Scenario: As a admin I can logout from the account
#    Given I set API endpoint for logout
#    When I send a DELETE request for logout
#    Then I receive status code 200
#    And I successfully logged out from the account
