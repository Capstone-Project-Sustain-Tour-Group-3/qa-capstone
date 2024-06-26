Feature: Personalized Recommendation
  As a user 
  I can use personalized recommendations
  So that I can choose my preferred destination

  Scenario: Can register with valid credentials
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username for personalized recommendation
    Then I input a valid full name
    Then I input a valid email address for personalized recommendation
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I click Daftar Akun button
    Then I click Lanjutkan button