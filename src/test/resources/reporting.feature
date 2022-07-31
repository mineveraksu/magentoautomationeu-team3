@ReportingModuleTest
Feature:Reporting Module Functions

    @SeeProducts-MostViewedProductsReport
    Scenario: Reporting Manager should be able to see Products - Products Most Viewed Report
      Given Reporting manager is on the dashboard page and clicks on mostViewed link
      When reporting manager select period field and click showReports button after filling infos
      Then most viewed products report displayed successfully


  @SeeSales-TotalInvoicedVsPaidReport
  Scenario Outline: Reporting Manager should be able to see sales- Total Invoiced Vs Paid Report
    Given Reporting manager is on the dashboard page and clicks on Invoiced Option
    When Reporting Manager Navigate to Total Invoiced vs Paid Report page and select period and date "<fromDate>" "<toDate>" and click show Report button
    Then Total Invoiced Vs Paid report view successfully

    Examples:
      |fromDate  |toDate    |
      |01/01/2013|07/30/2022|

  @SeeSales-TotalShippedReport
  Scenario Outline: Reporting Manager should be able to see sales- Total Shipped Report
    Given Reporting manager is on the dashboard page and clicks on Shipping Option
    When Reporting Manager Navigate to Total Shipped Report page and select period and date "<fromDate>" "<toDate>" and click show Report button
    Then Total Shipped report view successfully

    Examples:
      |fromDate  |toDate    |
      |01/01/2013|07/30/2022|


  @SeeTotalOrderedReport
  Scenario: Reporting Manager should be able to see Sales -Total Ordered Report
    Given  Reporting manager is on the dashboard page and clicks on Orders link
    When   Reporting manager choose orders reported period and see report
    And    Reporting manager see total ordered report under the Sales


    @SeeProducts-ProductsOrderedReport
    Scenario Outline: Reporting Manager should be able to see Products - Products Ordered Report
      Given Reporting manager is on the dashboard page and clicks on Products Ordered link
      When Reporting Manager Navigate to products ordered report page and select period and date "<fromDate>" "<toDate>" and click Refresh button
      Then Total products Ordered report displayed successfully

      Examples:
        |fromDate  |toDate    |
        |01/01/2022|07/30/2022|

  @SeeProducts-ProductsDownloadsReport
  Scenario: Reporting Manager should be able to see Products - Products Downloads Report
    Given Reporting manager is on the dashboard page and clicks on downloads link
    Then Reporting Manager can see Products - Products Downloads Report

  @SeeCustomersNewAccountsReport
  Scenario Outline: Reporting Manager should be able to see Customers - New Accounts Report
    Given  Reporting manager is on the dashboard page and clicks on New Accounts link
    When   Reporting manager selects "<fromDate>" and "<toDate>" and clicks on Refresh button
    Then    Reporting manager can see Customers - New Accounts Report table
    Examples:
      | fromDate   | toDate     |
      | 01/01/2022 | 07/30/2022 |

  @SeeTaxesReport
  Scenario Outline: Reporting Manager should be able to see Sales - Taxes Report Grouped by Tax Rate
    Given Reporting manager on the dashboard page and click on tax link
    When  Reporting manager select taxes report period "<startedTime>" "<endedTime>" and click on shor report button
    Then  Taxes report display successful

    Examples:
      |startedTime|endedTime|
      |01/01/2010 |30/07/2022|