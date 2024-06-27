Feature: Register to Account
  As a User
  I want to register my account
  So my account can be registered

  Scenario: Register an account with valid input and valid fullname
    Given I set on the register endpoint
    When I send valid email and valid input and valid input
    And I receive status code 201
    Then Check that I receive appropriate data for valid register request

  Scenario: Register an account with conflict email
    Given I set on the register endpoint
    When I send valid with valid input but the email has conflict
    And I receive status code 409
    Then My account is not registered

  Scenario: Register an account with conflict username
    Given I set on the register endpoint
    When I send valid with valid input but the username has conflict
    And I receive status code 409
    Then My account is not registered

  Scenario: Register an account with wrong email format
    Given I set on the register endpoint
    When I send valid with valid with wrong email format
    And I receive status code 400
    Then My account is not registered




