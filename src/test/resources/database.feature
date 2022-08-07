@DatabaseTest
Feature: Database Verification

  Background:
    Given a user has read access to the Magento database

    Scenario: verify newly registered user should be in the database
      When the user query the mg_customer_entity table
      Then the user should see the newly registered user info
      @Addedcreditmemo
      Scenario Outline: verify added credit memo should be in database
        When user execute the  mg_sales_flat_creditmemo where increment_id "<creditmemo id>" query
        Then user should see added creditmemo information in the database
        Examples:
        |creditmemo id|
        |100000025    |

