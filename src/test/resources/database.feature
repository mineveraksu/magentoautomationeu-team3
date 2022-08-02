@DatabaseTest
Feature: Database Verification

  Background:
    Given a user has read access to the Magento database

    Scenario: verify newly registered user should be in the database
      When the user query the mg_customer_entity table
      Then the user should see the newly registered user info

