@ReportingModuleTest
Feature:Reporting Module Functions

  @SeeProducts-ProductsDownloadsReport
  Scenario: Reporting Manager can see Products - Products Downloads Report
    Given Reporting manager is on the dashboard page and clicks on Downloads link

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
