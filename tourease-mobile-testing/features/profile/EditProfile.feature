Feature: Edit Profile
  As a user 
  I can edit my profile
  So that I can change my personal details
  
  Scenario: Can edit profile with valid data
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
    Then I click Profil button
    Then I redirected to the profile page
    Then I click Edit Akun section
    Then I redirected to the edit page
    # Then I input a valid bio
    # Then I input a valid city
    # Then I input a valid province
    # Then I click Simpan button