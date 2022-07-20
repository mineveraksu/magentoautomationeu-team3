@RegressionTest
Feature:Store Manager can manage a website

  @CreateWebsite
  Scenario Outline: Store Manager can create a website
    Given store manager is on the dashboard page
    And store manager click on manage stores link
    When store manager click create website button and fill out"<name>" "<code>" field and click save button
    Then website created successfully

    Examples:
      |name            |code      |
      |www.team3.com   |t003      |