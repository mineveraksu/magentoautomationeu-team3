@RegressionTest
Feature:Store Manager can manage a order

  @CreateOrder
  Scenario : Store Manager can create a order
    Given store manager is on the dashboard page


  #edit orders
  @EditOrders
  Scenario: Store Manager can edit orders
    Given store manager is on the dashboard page
    When  store manager search added order and edit some information
    Then  the edited information should be saved successful
