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

  @SeeTotalOrderedReport
  Scenario: Reporting Manager should be able to see  Sales - Total Ordered Report
    Given  Reporting manager is on the dashboard page and clicks on Orders link
    When   Reporting manager choose orders reported period and see report
    And    Reporting manager see total ordered report under the Sales



