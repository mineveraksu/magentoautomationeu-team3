@SalesModuleTest
Feature:Sales Module Functions

  @CreateNewOrder
  Scenario: Sales Manager can create a new order
    Given Sales manager is on the dashboard page and clicks on Orders link

  @ViewInvoicesAndAddComments
  Scenario Outline: Sales Manager should be able to view invoices and add comments to invoice history
    Given sales manager is on the dashboard page and click on invoices link
    When sales manager click edit button and click comment text and added comment to "<commentText>" filed
    Then view invoices successfully and added comments to invoice history successfully
    Examples:
      |commentText                 |
      |Rest of the payment cleared |