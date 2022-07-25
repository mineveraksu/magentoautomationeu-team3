@SalesModuleTest
Feature:Sales Module Functions

  @CreateNewOrder
  Scenario: Sales Manager can create a new order
    Given Sales manager is on the dashboard page and clicks on Orders link




    @UpdateShipments
    Scenario Outline: Sales Manager can update shipments
      Given Sales manager is on the dashboard page and clicks on ShipmentsOption
      When Sales Manager click view icon and fill out "<Comment History>" information and click submit comment button
      And Sale Manager edit shipping and tracking information and fill out "<Number>" and click add button
      Then the shipments update successfully

      Examples:
      |Comment History     |Number  |
      |Shipped successfully|12345678|