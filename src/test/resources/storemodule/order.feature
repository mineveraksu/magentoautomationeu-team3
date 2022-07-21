@RegressionTest
Feature:Store Manager can manage a order

  @CreateOrder
  Scenario : Store Manager can create an order
    Given store manager is on the dashboard page and store manager click on orders link









#  Store Manager can edit orders
  @EditOrders
  Scenario : Store Manager can edit orders
    Given store manager is on the dashboard page and store manager click on orders link
    When  store manager click on orders number and edit some information
    Then  edit orders successful


#  Store Manager can cancel orders
