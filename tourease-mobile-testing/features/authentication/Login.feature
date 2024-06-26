Feature: Login
  As a user 
  I can login to an exciting account
  So that I can access the application
  
  Scenario: Can Login with valid credentials
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

  Scenario: Cannot login with empty email
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I input a valid username
    Then I input a valid password for login
    Then I cannot click Masuk Akun button

  Scenario: Cannot login with empty password
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I input a valid username
    Then I input a valid email address for login
    Then I cannot click Masuk Akun button

  Scenario: Cannot login with wrong email
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I input a invalid email address for login
    Then I input a valid password for login
    Then I click Masuk Akun button
    # Then I got an error message that the account was not found

  Scenario: Cannot login with wrong password
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I input a valid email address for login
    Then I input a invalid password for login
    Then I click Masuk Akun button

  Scenario: Can reset password
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I click forgot password
    Then I redirected to forgot password page

  Scenario: Cannot reset password
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Masuk button
    Then I am on the login page
    Then I click forgot password
    Then I redirected to forgot password page

  Scenario: Can Logout from account
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
    Then I click Keluar
    Then I click Keluar Button
    Then I redirected to login page

  Scenario: Cannot Logout from account
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
    Then I click Keluar
    Then I click Batal Button
    Then I returned to the profile page