@MarketingModule
Feature:Marketing Manager can manage market

  @AddNewNewsletterTemplate
  Scenario Outline: Marketing Manager can add new Newsletter template
    Given marketing manager is on the dashboard page and clicks on Newsletter Templates link
    When marketing manager clicks on Add New Template button and fill out "<Template Name>""<Template Subject>" Information and clicks save Template button
    Then a new Newsletter template "<Template Name>" added successfully
    Examples:
      | Template Name  | Template Subject       |
      | Team3 Template | Team3 Template Subject |

  @UpdateNewsletterTemplate
  Scenario Outline: Marketing Manager can update Newsletter template
    Given marketing manager is on the dashboard page and clicks on Newsletter Templates link
    When marketing manager clicks on "<Template Name>" and change email to click on save Template button
    Then The Newsletter template updated successfully
    Examples:
      | Template Name  |
      | Team3 Template |

  @DeleteNewsletterTemplate
  Scenario Outline: Marketing Manager can delete Newsletter template
    Given marketing manager is on the dashboard page and clicks on Newsletter Templates link
    When marketing manager clicks on "<Template Name>"  to click on delete Template button
    Then The Newsletter template "<Template Name>" deleted successfully
    Examples:
      | Template Name  |
      | Team3 Template |