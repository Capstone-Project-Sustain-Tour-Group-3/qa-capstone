Feature: Resend OTP
  As a User
  I want to post a request to server
  SO I can receive an appropriate message and status and receive OTP

  Scenario: Send OTP with valid Email
    Given I set on ResendOTP API endpoint
    When I send POST request to server with valid email
    Then I receive status code 201
    And I receive the reference id and an appropriate message

  Scenario: Send OTP with invalid Email format
    Given I set on ResendOTP API endpoint
    When I send POST request to server with invalid email format
    Then I receive status code 400
    And I dont receive the reference id and i receive an appropriate message

  Scenario: Send OTP with Unregistered Email
    Given I set on ResendOTP API endpoint
    When I send POST request to server with Unregistered Email
    Then I receive status code 400
    And I dont receive the reference id and i receive an appropriate message
