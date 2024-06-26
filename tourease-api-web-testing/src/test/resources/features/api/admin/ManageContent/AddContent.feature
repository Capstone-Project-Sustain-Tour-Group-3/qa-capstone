#@AddContent
#Feature: Add Content
#  As a admin
#  I want to manage content
#  So that I can access content feature
#
#  @Add-content
#  Scenario: As a admin I can add content
#    Given I set API endpoint for add content
#    When I send a POST request for add content
#    Then I receive status code 201
#    And I received a valid data from new content
#
#  @Cannot-add-content-without-data
#  Scenario: As a admin I cannot add content without body data
#    Given I set API endpoint for add content
#    When I send a POST request for add content without body data
#    Then I receive status code 400
#    And I received a failed add content message
#
#  @Cannot-add-content-invalid-url
#  Scenario: As a admin I cannot add content with invalid url format
#    Given I set API endpoint for add content
#    When I send a POST request for add content with invalid url format
#    Then I receive status code 400
#    And I received a failed add content message
