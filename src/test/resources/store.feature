@StoreModuleTest
Feature:Store Manager can manage store

  @CreateWebsite
  Scenario: Store Manager can create a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager click create website button and fill out Website Information and click save button
    Then website created successfully
    #edit website

  @CreateStore
  Scenario: Store Manager can create a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on create store button to fill out store information
    Then the store should be created successfully


    #edit store
    #Store Manager can view all stores
  @ViewAllStores
  Scenario: Store Manager can view all stores
    Given store manager is on the dashboard page store manager click on manage stores link
    Then the store names should display on this page.



  @EditStore
  Scenario: Store Manager can edit a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on the store name to edit store then clicks on save store button
    Then the store should be edited successfully

    #create store view

    #update store view

  @DeletedStore
  Scenario: Store Manager can delete a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on the store name to click on the delete store button
    Then the store should be deleted successfully

  @CreateProduct
  Scenario Outline: Store Manager Can Create a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When click on add product button to fill out "<name>" "<description>" "<shortDescription>" "<sku>" "<weight>" "<price>" "<qty>" and other information information
    Then a new product created successfully

    Examples:
      | name  | description    | shortDescription | sku      | weight | price  | qty |
      | Jeans | Tommy Hilfiger | TH               | AB224488 | 300    | 199,99 | 5   |
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


   #delete website
  @DeleteWebsite
  Scenario: Store Manager can delete a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager select the website then click on the delete website button
    Then website deleted successfully
