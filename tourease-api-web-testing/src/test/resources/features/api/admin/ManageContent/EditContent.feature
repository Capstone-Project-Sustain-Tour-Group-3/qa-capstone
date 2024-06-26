#@EditContent
#Feature: Manage Content
#  As a admin
#  I want to manage content
#  So that I can access content feature
#
#  @Edit-content
#  Scenario: As a admin I can edit content
#    Given I set API endpoint for edit content
#    When I send a PUT request for edit content
#    Then I receive status code 200
#    And I received a success edit message
#
#  @Cannot-edit-content-without-data
#  Scenario: As a admin I cannot edit content without body data
#    Given I set API endpoint for edit content
#    When I send a PUT request for edit content without body data
#    Then I receive status code 400
#    And I received a failed edit content message
#
#  @Cannot-edit-content-invalid-url
#  Scenario: As a admin I cannot add content with invalid url format
#    Given I set API endpoint for add content
#    When I send a PUT request for edit content with invalid url format
#    Then I receive status code 400
#    And I received a failed add content message
#
#  @Edit-invalid-content
#  Scenario: As a admin I cannot edit content by invalid ID
#    Given I set API endpoint for edit content by invalid ID
#    When I send a PUT request with invalid content ID
#    Then I receive status code 404
#    And I received a content not found message