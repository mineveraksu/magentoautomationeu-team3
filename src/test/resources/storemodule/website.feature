@RegressionTest
Feature:Store Manager can manage a website

  @CreateWebsite
  Scenario Outline: Store Manager can create a website
    Given store manager is on the dashboard page
    When store manager click create website button and fill out"<name>" "<code>" field and click save button
    Then website created successfully

    Examples:
      |name            |code      |
      |www.team3.com   |T003      |