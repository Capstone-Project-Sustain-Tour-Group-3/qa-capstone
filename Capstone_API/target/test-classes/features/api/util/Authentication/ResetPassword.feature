Feature: Reset Password
  As a User
  I want to resetpassword
  So i send PUT request to server and my password is changed

  Scenario: Send POST request with valid reference_id and match password and confirm password
    Given I set on ResetPassword OTP API endpoint
    When I send POST request to server with match valid reference_id and match password and confirm password
    Then I receive status code 200
    And  I receive a message that say that i m succeed at resetting password and my password is changed

  Scenario: Send POST request with valid reference_id and unmatch password and confirm password
    Given I set on ResetPassword OTP API endpoint
    When I send POST request to server with unmatch valid reference_id and match password and confirm password
    Then I receive status code 400
    And  I receive a message that say that i m succeed at resetting password and my password does not changed


