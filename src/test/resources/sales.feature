@SalesModuleTest
Feature:Sales Module Functions

  @CreateNewOrder
  Scenario Outline: Sales Manager can create a new order
    Given Sales manager is on the dashboard page and clicks on Orders link
    When sales manager selects a "<store name>" in order to add a "<product name>" to order
    Then Sales Manager created a new order successfully
    Examples:
      | store name | product name              |
      | English    | Black Nolita Cami-Black-S |

  @CreateNewRefund
  Scenario: Sales manager should be able to create new refund for database
    Given  Sales manager is on the dashboard page and clicks on Orders link
    When  Sales manager created new refund
    Then  add new refund successful

  @UpdateOrderWithInStorePickup
  Scenario: Sales manager should able to update orders with in store pickup
    Given Sales manager is on the dashboard page and clicks on Orders link
    When Sale manager update order with in store pickup
    Then Successfully update orders

  @ViewInvoicesAndAddComments
  Scenario Outline: Sales Manager should be able to view invoices and add comments to invoice history
    Given sales manager is on the dashboard page and click on invoices link
    When sales manager click edit button and click comment text and added comment to "<commentText>" filed
    Then view invoices successfully and added comments to invoice history successfully
    Examples:
      | commentText                 |
      | Rest of the payment cleared |

  @UpdateShipments
  Scenario Outline: Sales Manager can update shipments
    Given Sales manager is on the dashboard page and clicks on shipmentsOption
    When Sales Manager click view icon and fill out "<commentHistory>" information and click on submit comment button
    And Sales Manager edit shipping and tracking information and fill out "<number>" and click on add button
    Then the shipments update successfully

    Examples:
      | commentHistory       | number   |
      | Shipped successfully | 12345678 |

  @AddTaxRules
  Scenario Outline: Sales Manager can add and update tax rules
    Given Sales manager is on the dashboard page and clicks on Manage Tax Rules
    When Sales Manager click Add New Tax Rule  icon and fill out "<Name>" "<Priority>" "<SortOrder>" information and click on Save Rule button
    Then a new Tax Rule created successfully

    Examples:
      | Name  | Priority | SortOrder |
      | Team3 | 3        | 4        |

  @UpdateTaxRules
  Scenario Outline: Sales Manager can update tax rules
    Given Sales manager is on the dashboard page and clicks on Manage Tax Rules
    When Sales Manager click Add New Tax Rule icon and fill out "<Number>"information and edit tax rules
    Then the new Tax Rule update successfully
    Examples:
      | Number |
      | 5      |


  @ViewRefundsInTheReports
  Scenario: Sales Manager should be able to view refunds in the Reports
    Given sales manager click on refunds link
    When  sales manager entering the refunds period and shows refunds
    Then  sales manager view refunds reports successful
    @ViewCreditMemo
    Scenario: Sales manager can view credit memo
      Given sales manager is on the dashboard and click credit memo link
      When  manager click the view button and view credit memo information
      Then verify view credit memo
      @AddCreditMemo
      Scenario: Sales manager can add credit memo
        Given Sales manager is on the dashboard page and clicks on Orders link
        When  Sales manager click pending and invoice button to create credit memo
        Then  Verify added credit memo



@ManageOpenAndViewShoppingCart
  Scenario: Sales Manager should be able to manage view shopping cart for customers
  Given Sales manager is on the dashboard page and click on the manage customers link
  When Sales manager open a customer and open his shopping cart
  Then Sales manager can view shopping cart


  @ManageUpdateShoppingCart
  Scenario Outline: Sales Manager should be able to manage update an existing shopping cart for customers.
    Given Sales manager is on the dashboard page and click on the manage customers link
    When Sales manager open a customer and open his shopping cart
    And Sales manager edit the shopping cart
    Then The shopping cart should be edited successfully
    Examples:
      | quantity |
      | 5        |

  @DeleteShoppingCart
  Scenario: Sales Manager should be able to delete shopping cart
    Given Sales manager is on the dashboard page and click on the manage customers link
    When Sales manager open a customer and open his shopping cart
    And Sales manager delete the shopping cart
    Then The shopping cart should be deleted successfully


  @DeleteOrder
  Scenario: Sales Manager can delete a new order
    Given Sales manager is on the dashboard page and clicks on Orders link
    When sales manager click on the pending order to click on the Cancel Button
    Then Sales Manager deleted a order successfully

    @ViewCreditMemos
    Scenario: Sales Manager should be able to view credit memos by filters.
    Given Sales manager is on the dashboard page and clicks on credit memos link
    When Sale manager filter credit memos
    Then the result of the filter should be displayed
