@RegressionTest
Feature:Store Manager can manage a store

  @CreateStore
  Scenario Outline: Store Manager can create a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on create store button to fill out "<storeName>" and other information
    Then the store should be saved successfully

    Examples:
      |storeName|
      |blueSky  |

