@DeleteContent
Feature: Delete Content
  As a admin
  I want to manage content
  So that I can access content feature

  @Delete-content
  Scenario: As a admin I can delete content data
    Given I set API endpoint for delete content
    When I send a DELETE request for delete content
    Then I receive status code 200
    And I received a success delete content message

  @Cannot-delete-content
  Scenario: As a admin I cannot delete content data with invalid ID
    Given I set API endpoint for delete content with invalid ID
    When I send a DELETE request with invalid content ID
    Then I receive status code 404
    And I received a content not found message