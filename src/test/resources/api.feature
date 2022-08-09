@ApiTest
Feature: Get Post Put request Api Test For Magento Public Module

  Background:
    Given authorization and base url

  Scenario: User should be able to get all categories information


  Scenario Outline: User should be able to create a customer group
    When user should be able to send post request for creating a "<customer group>"
    Then a new "<customer group>" should be created
    Examples:
      | customer group  |
      | Asian Customers |

  Scenario: User should be able to update a customer group
    When user should be able to send put request for updating a "<customer group>"
    Then a customer group should be updated
