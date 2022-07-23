@StoreModuleTest
Feature:Store Manager can manage store

  @CreateWebsite
  Scenario Outline: Store Manager can create a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager click create website button and fill out"<name>" "<code>" field and click save button
    Then website created successfully

    Examples:
      |name                    |code      |
      |www.team66663.com   |t066603      |

    #edit website
    #delete website

  @CreateStore
  Scenario: Store Manager can create a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on create store button to fill out store information
    Then the store should be saved successfully

    #edit store
    #create store view
    #update store view
    #delete store
  @CreateProduct
  Scenario Outline: Store Manager Can Create a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When click on add product button to fill out "<name>" "<description>" "<shortDescription>" "<sku>" "<weight>" "<price>" "<qty>" and other information information
    Then a new product created successfully

    Examples:
      |name |description   |shortDescription|sku          |weight|price |qty|
      |Jeans|Tommy Hilfiger|TH              |AB224488     |300   |199,99|5  |
    
    #update product
    #delete product

  @CreateOrder
  Scenario: Store Manager can create an order
    Given store manager is on the dashboard page and store manager click on orders link
    When store manager click on create new orders link
    And  store manager clıck and select the store name
    And  store manager select the product name
    And  fill the product information
    Then the order should be saved successfully
   #edit orders
  @EditOrders
  Scenario: Store Manager can edit orders
    Given store manager is on the dashboard page and store manager click on orders link
    When  store manager search orders number and edit some information
    Then  edit orders successful
    #cancle orders
