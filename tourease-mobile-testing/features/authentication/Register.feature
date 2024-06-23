Feature: Register
  As a user 
  I can register for a new account
  So that I can access the application

  Scenario: Can register with valid credentials
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I click Daftar Akun button
    Then I click Lanjutkan button

  Scenario: Cannot register with empty username
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with empty username
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with empty full name
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid email address
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with empty email
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid full name
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with empty phone number
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid password
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with empty password
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid phone number
    Then I check on S&K option
    Then I cannot click Daftar Akun button

  Scenario: Cannot register with invalid OTP code
    Given I am on the splash screen page
    When I click Skip button
    Then I click Mulai button
    Then I click Daftar button
    Then I am on the register page
    Then I input a valid username
    Then I input a valid full name
    Then I input a valid email address
    Then I input a valid phone number
    Then I input a valid password
    Then I check on S&K option
    Then I click Daftar Akun button
    Then I click Lanjutkan button
    Then I input first OTP
    Then I input second OTP
    Then I input third OTP
    Then I input fourth OTP
    Then I click Kirim button
    Then I redirected to failed register page