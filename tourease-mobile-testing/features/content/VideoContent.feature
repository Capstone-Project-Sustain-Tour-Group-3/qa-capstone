Feature: Video Content
  As a user 
  I can see video content
  So that I can see an overview of the destination I will visit
  
  Scenario: Can access video content from destination
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
    Then I select the desired destination
    # Then I see video content from the destination