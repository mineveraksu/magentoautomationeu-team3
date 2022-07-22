@RegressionTest
Feature:Store Manager Can Manage a Product

  @CreateProduct
  Scenario Outline : Store Manager Can Create a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When click on add product button to fill out "<name>" "<description>" "<shortDescription>" "<sku>" "<weight>" "<price>" "<qty>" and other information information
    Then a new product created successfully

  Examples:
    |name |description   |shortDescription|sku          |weight|price|qty|
    |Jeans|Tommy Hilfiger|TH              |AB224488     |300   |199,99|5  |




