@RegressionTest
Feature:Store Manager can manage a order

  @CreateOrder
  Scenario : Store Manager can create an order
    Given store manager is on the dashboard page and store manager click on orders link
    When store manager click on create new orders link
    And  store manager clıck and select the store name
    And  store manager select the product name
    And  fill the product information
    Then the order should be saved successfully
#  Store Manager can edit orders
  @EditOrders
  Scenario : Store Manager can edit orders
    Given store manager is on the dashboard page and store manager click on orders link
    When  store manager search orders number and edit some information
    Then  edit orders successful


#  Store Manager can cancel orders
