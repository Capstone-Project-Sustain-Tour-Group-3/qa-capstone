Feature: Search Destination
  As a user 
  I can search destination
  So that I can see what destinations are available
  
  Scenario: Can search available destinations
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I input a valid username
    Then I input a valid email address for login
    Then I input a valid password for login
    Then I click Masuk Akun button
    Then I redirected to the home page
    Then I click Destinasi button
    Then I redirected to the destination page
    # Then I click Cari Destinasi section
    # Then I input the destination I want
    Then I select the desired destination