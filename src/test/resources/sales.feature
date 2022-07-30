@SalesModuleTest
Feature:Sales Module Functions

  @CreateNewOrder
  Scenario Outline: Sales Manager can create a new order
    Given Sales manager is on the dashboard page and clicks on Orders link
    When sales manager selects a "<store name>" in order to add a "<product name>" to order
    Then Sales Manager created a new order successfully
    Examples:
    |store name|product name             |
    |English   |Black Nolita Cami-Black-S|

  @ViewInvoicesAndAddComments
  Scenario Outline: Sales Manager should be able to view invoices and add comments to invoice history
    Given sales manager is on the dashboard page and click on invoices link
    When sales manager click edit button and click comment text and added comment to "<commentText>" filed
    Then view invoices successfully and added comments to invoice history successfully
    Examples:
      |commentText                 |
      |Rest of the payment cleared |

    @UpdateShipments
    Scenario Outline: Sales Manager can update shipments
      Given Sales manager is on the dashboard page and clicks on shipmentsOption
      When Sales Manager click view icon and fill out "<commentHistory>" information and click on submit comment button
      And Sales Manager edit shipping and tracking information and fill out "<number>" and click on add button
      Then the shipments update successfully

    Examples:
      |commentHistory     |number     |
      |Shipped successfully|12345678  |

  @AddTaxRules
  Scenario Outline: Sales Manager can add and update tax rules
    Given Sales manager is on the dashboard page and clicks on Manage Tax Rules
    When Sales Manager click Add New Tax Rule  icon and fill out "<Name>" "<Priority>" "<SortOrder>" information and click on Save Rule button
    Then a new Tax Rule created successfully

    Examples:
      |  Name  |Priority | SortOrder |
      | Team3  | 3       |       4   |

    @UpdateTaxRules
    Scenario Outline: Sales Manager can update tax rules
      Given Sales manager is on the dashboard page and clicks on Manage Tax Rules
      When Sales Manager click Add New Tax Rule icon and fill out "<Number>"information and edit tax rules
      Then the new Tax Rule update successfully
      Examples:
        |  Number |
        | 5  |


  @ViewRefundsInTheReports
  Scenario: Sales Manager should be able to view refunds in the Reports
    Given sales manager click on refunds link
    When  sales manager entering the refunds period and shows refunds
    Then  sales manager view refunds reports successful

