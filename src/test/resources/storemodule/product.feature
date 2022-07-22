@RegressionTest
Feature:Store Manager can manage a product

  @CreateProduct
  Scenario Outline : Store Manager Can Create a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When click on add product button to fill out "<name>" "<description>" "<shortDescription>" "<SKU>" and other information information
    Then a new product created successfully

    Examples:
      | name  | description    | shortDescription | SKU      |
      | Jeans | Tommy Hilfiger | TH               | AB224488 |
