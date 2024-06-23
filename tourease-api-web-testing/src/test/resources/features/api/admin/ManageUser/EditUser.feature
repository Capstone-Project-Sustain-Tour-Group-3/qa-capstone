@EditUser
Feature: Manage User
  As a admin
  I want to manage user account
  So that I can access user feature

  @Edit-user
  Scenario: As a admin I can edit user data
    Given I set API endpoint for edit user data
    When I send a PUT request for edit user data
    Then I receive status code 200
    And I received a success edit message

  @Cannot-edit-user-without-data
  Scenario: As a admin I cannot edit user data without body data
    Given I set API endpoint for edit user data
    When I send a PUT request for edit user data without body data
    Then I receive status code 400
    And I received a failed edit user message

  @Cannot-edit-user-invalid-profile
  Scenario: As a admin I cannot edit user data with invalid profile picture format
    Given I set API endpoint for edit user data
    When I send a PUT request for edit user data with invalid profile picture format
    Then I receive status code 400
    And I received a failed edit user message

  @Cannot-edit-user-invalid-username
  Scenario: As a admin I cannot edit user data with an already registered username
    Given I set API endpoint for edit user data
    When I send a PUT request for edit user data with an already registered username
    Then I receive status code 409
    And I received a failed username or email already in use message

  @Cannot-edit-user-invalid-email
  Scenario: As a admin I cannot edit user data with an already registered email
    Given I set API endpoint for edit user data
    When I send a PUT request for edit user data with an already registered email
    Then I receive status code 409
    And I received a failed username or email already in use message

  @Edit-invalid-user
  Scenario: As a admin I cannot edit user detail by invalid ID
    Given I set API endpoint for edit user detail by invalid ID
    When I send a PUT request with invalid user ID
    Then I receive status code 404
    And I received an account not found message
