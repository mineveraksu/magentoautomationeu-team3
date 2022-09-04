@StoreModuleTest @RegressionTest
Feature:Store Manager can manage store

  @CreateWebsite
  Scenario: Store Manager can create a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager click create website button and fill out Website Information and click save button
    Then website created successfully

  @EditWebsite
    Scenario: Store Manager can Edit a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager select the website and edit website information and click save button
    Then website edit successfully

  @CreateStore
  Scenario: Store Manager can create a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on create store button to fill out store information
    Then the store should be created successfully

  @ViewAllStores
  Scenario: Store Manager can view all stores
    Given store manager is on the dashboard page store manager click on manage stores link
    Then the store names should display on this page.

  @EditStore
  Scenario: Store Manager can edit a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on the store name to edit store then clicks on save store button
    Then the store should be edited successfully

   @CreateStoreView
   Scenario Outline: Store Manager can create a store view
     Given store manager is on the dashboard page store manager click on manage stores link
     When  Store manager click the create store view button
     And   fill out the information field"<StoreName>""<StoreCode>"
     Then  Verify the created store view saved
     Examples:
       |StoreName          |StoreCode|
       |  team33      |   mah33     |

  @EditStoreView
  Scenario Outline: Store manager can edit store view
    Given store manager is on the dashboard page store manager click on manage stores link
    When  Store manager click the created store view link and put update name"<EditName>"
    Then  Verify the updated store view saved
    Examples:
              |EditName|
              | team3  |


  @CreateProduct
  Scenario Outline: Store Manager Can Create a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When click on add product button to fill out "<name>" "<description>" "<shortDescription>" "<sku>" "<weight>" "<price>" "<qty>" and other information information
    Then a new product created successfully

    Examples:
      | name  | description    | shortDescription | sku      | weight | price  | qty |
      | Jeans | Tommy Hilfiger | TH               | AB224488 | 300    | 199,99 | 5   |

  @UpdateProduct
  Scenario Outline: Store Manager Can Update a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When select the product "<name>" and update description "<description>"
    Then product information updated successfully
    Examples:
      | name  | description        |
      | Jeans | new season fashion |

    #delete product

  @CreateOrder
  Scenario Outline: Store Manager can create an order
    Given store manager is on the dashboard page and store manager click on orders link
    When store manager select a customer and a store "<StoreName>" and a product
    And select shipping and payment methods and submit order
    Then the order should be saved successfully
    Examples:
      |StoreName     |
      |  team33      |

  @EditOrders
  Scenario: Store Manager can edit orders
    Given  store manager is on the dashboard page and store manager click on orders link
    When  store manager search orders number and edit some information
    Then  edit orders successful

  @CancelOrders
  Scenario: Store Manager can cancel orders
    Given store manager is on the dashboard page and store manager click on orders link
    When store manager click on view link and cancel order link
    Then  cancel order successful

  @addProductCategory
  Scenario: Store Manager can add product category
    Given store manager is on the dashboard page store manager click on manage products link
    When store manager clicks categories link and check the existing product categories
    Then verify added a new product category

  @UpdateProductCategory
  Scenario: Store Manager can update a new product category
    Given store manager is on the dashboard page store manager click on manage products link
    When store manager clicks an existing product and check other existing product category
    Then verify update the product category


  @DeleteProductCategory
  Scenario: Store Manager can delete a product category
    Given store manager is on the dashboard page store manager click on manage products link
    When store manager clicks an existing product and delete the product category
    Then verify delete the product category



  @DeleteStore
  Scenario: Store Manager can delete a store
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager clicks on the store name to click on the delete store button
    Then the store should be deleted successfully

  @DeleteWebsite
  Scenario: Store Manager can delete a website
    Given store manager is on the dashboard page store manager click on manage stores link
    When store manager select the website then click on the delete website button
    Then website deleted successfully

  @DeleteProduct
  Scenario Outline: Store Manager Can Delete a Product
    Given store manager is on the dashboard page store manager click on manage products link
    When Store manager can search "<name>" product and delete the product
    Then the product delete successfully

    Examples:
      | name  |
      | Jeans |

     #add stock
#  @AddStockQuantity
#  Scenario Outline: Sales Manager can add stock quantity
#    Given Sales manager is on the dashboard page and open the manage products page
#    When sales manager selects a "<name>" in order to add a "<qty>" to the product
#    Then Sales Manager can add stock quantity successfully
#    Examples:
#      |name | qty |
#      |  Jeans  | 100 |