Feature: Verify OTP
  As a User
  I want to check my OTP to server
  So i send POST request to server and i receive an appropriate message

  Scenario: Send POST request with match reference_id and OTP
    Given I set on VerifyOTP API endpoint
    When I send POST request to server with match reference_id and OTP
    Then I receive status code 201
    And  I receive an OTP and a message that say that i m succeed

  Scenario: Send POST request with unmatch reference_id and OTP
    Given I set on VerifyOTP API endpoint
    When I send POST request to server with unmatch reference_id and OTP
    Then I receive status code 400
    And  I dont receive an OTP and receive a message that say that i m succeed

