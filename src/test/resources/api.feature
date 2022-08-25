@ApiTest
Feature: Get Post Put request Api Test For Magento Public Module

  Background:
    Given authorization and base url

  Scenario: User should be able to get all categories information


  Scenario Outline: User should be able to create a customer group
    When user should be able to send post request for creating a "<customer group>"
    Then a new "<customer group>" should be created
    Examples:
      | customer group  |
      | Asian Customers |


  Scenario Outline: User should be able to update a customer group
    When user should be able to send put request for updating a "<customer group>"
    Then a customer group should be updated
    Examples:
      | customer group  |
      | Turkish Customers |

    #user should be able to Get a customer group
  Scenario: user should be able to get one customer information
    When user should be able to send get request for one customer group information
    Then user should be get information about the customer group



    #Post,Get and Put one category lk
#  Scenario Outline: User should be able to create one category
#    When user should be able to send post request for creating one "<category>"
#    Then user should be created a new "<category>"
#    Examples:
#    |category|
#    |Jeans   |

      Scenario Outline: User should be able to update one category
        When user should be able to send put request for updating one "<category Name>"
        Then one category should be updated
        Examples:
          |category Name|
          |Iphone       |

  Scenario: User should be able to get one category information
    When user should be able to send request for get specific information
    Then user should be get information about the category

    #user update customer
    Scenario Outline: User should be update customer
      When user should be able to send put request for update customer"<value>"
      Then customer should be updated
      Examples:
      |value  |
      |team33 |


  Scenario Outline: User should be able to create a product
    When user should be able to send post request for creating a new product using "<entityTypeId>","<attributeSetId>","<typeId>","<sku>"
    Then a product with "<entityTypeId>","<attributeSetId>","<typeId>","<sku>" should be created
    Examples:
      | entityTypeId   ||attributeSetId| |typeId  | |sku           |
      |4               ||        12    | |  simple| |deel_optiplex |


