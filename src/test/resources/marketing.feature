@MarketingModule
Feature:Marketing Manager can manage market

  @AddNewNewsletterTemplate
  Scenario: Marketing Manager can add new Newsletter template
    Given marketing manager is on the dashboard page and clicks on Newsletter Templates link
    When marketing manager clicks on Add New Template button and fill out New Newsletter Template Information and clicks save Template button
    Then a new Newsletter template added successfully
    #edit website