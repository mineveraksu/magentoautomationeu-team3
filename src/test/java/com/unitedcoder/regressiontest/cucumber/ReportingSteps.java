package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.marketingpages.NewsletterTemplatePage;
import com.seleniummaster.maganto.backendpages.reportingpages.*;
import com.seleniummaster.maganto.utility.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReportingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    ReportingDashboardPage reportingDashboardPage;
    ProductsMostViewedPage productsMostViewedPage;
    TestDataHolder testDataHolder;
    TestDataHolder testDataHolder2;
    ExcelUtility excelUtility;
    SalesPage salesPage;
    InvoicedVsPaidReportPage invoicedVsPaidReportPage;
    ShippedReportPage shippedReportPage;
    NewAccountsPage newAccountsPage;
    TagsPage tagsPage;
    CustomersByOrdersTotal customersByOrdersTotal;
    CustomersByNumberOfOrders customersByNumberOfOrders;
    Report_ReviewsPage report_ReviewsPage;
    PopularPage popularPage;



    @Before("@ReportingModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.reportingPageLogin();

        reportingDashboardPage = new ReportingDashboardPage(driver);
        excelUtility = new ExcelUtility();
        testDataHolder = excelUtility.readReportingInfoFromExcel("Test-Data/reportingModule.xlsx", "Sales_Info");
        testDataHolder2 = excelUtility.readSalesInfoFromExcel("Test-Data/SalesModule.xlsx", "Refunds_Info");
        salesPage = new SalesPage(driver);
        reportingDashboardPage = new ReportingDashboardPage(driver);
        productsMostViewedPage = new ProductsMostViewedPage(driver);
        excelUtility = new ExcelUtility();
        testDataHolder = excelUtility.readReportingInfoFromExcel("Test-Data/reportingModule.xlsx", "Sales_Info");
        testDataHolder2 = excelUtility.readSalesInfoFromExcel("Test-Data/SalesModule.xlsx", "Refunds_Info");
        salesPage = new SalesPage(driver);
        report_ReviewsPage = new Report_ReviewsPage(driver);
        popularPage = new PopularPage(driver);
    }

    @Given("Reporting manager is on the dashboard page and clicks on mostViewed link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnMostViewedLink() {
        reportingDashboardPage.clickOnMostViewedLink();
    }

    @When("reporting manager select period field and click showReports button after filling infos")
    public void reportingManagerSelectPeriodFieldAndClickShowReportsButtonAfterFillingInfos() {
        productsMostViewedPage = new ProductsMostViewedPage(driver);
        productsMostViewedPage.viewProductsMostViewedReport(testDataHolder);
    }

    @Then("most viewed products report displayed successfully")
    public void mostViewedProductsReportDisplayedSuccessfully() {
        Assert.assertTrue(productsMostViewedPage.verifyMostViewedProductsDisplayed());
    }


    //See Sales-Total Invoiced vs Paid Report
    @Given("Reporting manager is on the dashboard page and clicks on Invoiced Option")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnInvoicedOption() {
        reportingDashboardPage.ClickOnInvoicedOption();

    }

    @When("Reporting Manager Navigate to Total Invoiced vs Paid Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToTotalInvoicedVsPaidReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1) {
        invoicedVsPaidReportPage = new InvoicedVsPaidReportPage(driver);
        invoicedVsPaidReportPage.viewSalesInvoicedVsPaidReport(arg0, arg1);
    }

    @Then("Total Invoiced Vs Paid report view successfully")
    public void totalInvoicedVsPaidReportViewSuccessfully() {
        invoicedVsPaidReportPage.verifyViewSalesInvoicedVsPaidReportSuccessfully();
    }

    //See Sales-Total Shipped Report
    @Given("Reporting manager is on the dashboard page and clicks on Shipping Option")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnShippingOption() {
        reportingDashboardPage.ClickOnShippingOption();
    }

    @When("Reporting Manager Navigate to Total Shipped Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToTotalShippedReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1) {
        shippedReportPage = new ShippedReportPage(driver);
        shippedReportPage.viewSalesShippedReport(arg0, arg1);
    }

    @Then("Total Shipped report view successfully")
    public void totalShippedReportViewSuccessfully() {
        shippedReportPage.verifyViewSalesShippedReportSuccessfully();
    }

    @Given("Reporting manager is on the dashboard page and clicks on refunded Option")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnRefundedOption() {
        reportingDashboardPage.clickOnRefundedLink();

    }

    @When("Reporting Manager Navigate to Total Refunded Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToTotalRefundedReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1){
        salesPage= new SalesPage(driver);
        salesPage.seeTotalRefundsReport(arg0,arg1);
    }
    @Then("Total refunded report view successfully")
    public void totalRefundedReportViewSuccessfully() {
        salesPage=new SalesPage(driver);
        Assert.assertTrue(salesPage.verifyRefundsReportSuccessfullyShown());
    }

    //COUPONUSAGEREPORT
    @Given("Reporting manager is on the dashboard page and clicks on Coupon Usage Option")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnCouponUsageOption() {
        reportingDashboardPage.clickOnCouponsLink();
    }

    @When("Reporting Manager Navigate to Coupon Usage Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToCouponUsageReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1) {
        salesPage=new SalesPage(driver);
        salesPage.seeCouponUsageReport(arg0,arg1);
    }

    @Then("Coupon Usage report view successfully")
    public void couponUsageReportViewSuccessfully() {
        Assert.assertTrue(salesPage.verifyCouponUsageSuccessfullyShown());
    }
    //
    @Given("Reporting manager is on the dashboard page and clicks on Orders link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnOrdersLink() {
        reportingDashboardPage.clickOnOrdersLink();
    }

    @When("Reporting manager choose orders reported period and see report")
    public void reportingManagerChooseOrdersReportedPeriodAndSeeReport() {
        salesPage.seeTotalOrdersReport(testDataHolder2);

    }

    @And("Reporting manager see total ordered report under the Sales")
    public void reportingManagerSeeTotalOrderedReportUnderTheSales() {
        Assert.assertTrue(salesPage.verifyOrdersSaw());
    }

    //See Products-Products Ordered Report
    @Given("Reporting manager is on the dashboard page and clicks on Products Ordered link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnProductsOrderedLink() {
        reportingDashboardPage.ClickOnProductsOrderedOption();

    }

    @When("Reporting Manager Navigate to products ordered report page and select period and date {string} {string} and click Refresh button")
    public void reportingManagerNavigateToProductsOrderedReportPageAndSelectPeriodAndDateAndClickRefreshButton(String arg0, String arg1) {
        productsMostViewedPage.viewProductsOrderedReport(arg0, arg1);

    }

    @Then("Total products Ordered report displayed successfully")
    public void totalProductsOrderedReportDisplayedSuccessfully() {
        Assert.assertTrue(productsMostViewedPage.verifyViewProductsOrderedReport());
    }

    @Given("Reporting manager is on the dashboard page and clicks on New Accounts link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnNewAccountsLink() {
        reportingDashboardPage.clickOnNewAccountsLink();
    }

    @When("Reporting manager selects {string} and {string} and clicks on Refresh button")
    public void reportingManagerSelectsAndAndClicksOnRefreshButton(String arg0, String arg1) {
        newAccountsPage = new NewAccountsPage(driver);
        newAccountsPage.seeCustomersNewAccountsReport(arg0, arg1);
    }

    @Then("Reporting manager can see Customers - New Accounts Report table")
    public void reportingManagerCanSeeCustomersNewAccountsReportTable() {
        Assert.assertTrue(newAccountsPage.verifySeeCustomersNewAccountsReport());
    }


    @Given("Reporting manager is on the dashboard page and clicks on downloads link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnDownloadsLink() {
        reportingDashboardPage.ClickOnDownloadsLink();
    }

    @Then("Reporting Manager can see Products - Products Downloads Report")
    public void reportingManagerCanSeeProductsProductsDownloadsReport() {
        DownloadsPage downloadsPage = new DownloadsPage(driver);
        downloadsPage.verifyViewSalesInvoicedVsPaidReportSuccessfully();
    }

    //Reporting Manager should be able to see Tags - Customers Report
    @Given("Reporting manager is on the dashboard page and go to the customers tags page")
    public void reportingManagerIsOnTheDashboardPageAndGoToTheCustomersTagsPage() {
      reportingDashboardPage.openCustomersTags();
    }

    @Then("Reporting Manager can see customers tags")
    public void reportingManagerCanSeeCustomersTags() {
        tagsPage=new TagsPage(driver);
        Assert.assertTrue(tagsPage.verifyOpenCustomersReportTags());
    }
    //Reporting Manager should be able to see Tags - Products Report
    @Given("Reporting manager is on the dashboard page and go to the products tags page")
    public void reportingManagerIsOnTheDashboardPageAndGoToTheProductsTagsPage() {
        reportingDashboardPage.openProductsTags();
    }

    @Then("Reporting Manager can see Products products tags")
    public void reportingManagerCanSeeProductsProductsTags() {
        tagsPage=new TagsPage(driver);
        Assert.assertTrue(tagsPage.verifyOpenProductsTags());
    }

    @Given("Reporting manager on the dashboard page and click on tax link")
    public void reportingManagerOnTheDashboardPageAndClickOnTaxLink() {
        reportingDashboardPage.clickOnTaxLink();

    }

    @When("Reporting manager select taxes report period {string} {string} and click on shor report button")
    public void reportingManagerSelectTaxesReportPeriodAndClickOnShorReportButton(String arg0, String arg1) {
        salesPage.seeTaxesRateReport(arg0, arg1);
    }

    @Then("Taxes report display successful")
    public void taxesReportDisplaySuccessful() {
        Assert.assertTrue(salesPage.taxesReportSawVerify());
    }
    // see customers by orders total
    @Given("Reporting manager is on the dashboard page and clicks on customer by order total link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnCustomerByOrderTotalLink() {
        reportingDashboardPage.ClickOnCustomersByOrdersTotalLink();
    }

    @When("Reporting manager enter {string}{string} and click refresh button")
    public void reportingManagerEnterAndClickRefreshButton(String arg0, String arg1) {
        customersByOrdersTotal=new CustomersByOrdersTotal(driver);
        customersByOrdersTotal.customerByOrdersTotalMethod(arg0,arg1);

    }

    @Then("verifymanager can see customers by orders total")
    public void verifymanagerCanSeeCustomersByOrdersTotal() {
        customersByOrdersTotal=new CustomersByOrdersTotal(driver);
        org.testng.Assert.assertTrue(customersByOrdersTotal.verifyManagerCanSeeCustomersByOrdersTotal());
    }
    @Given("Reporting manager is on the dashboard page and clicks on customer by number of orders link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnCustomerByNumberOfOrdersLink() {
        reportingDashboardPage.ClickOnCustomersByNumberOfOrdersLink();
    }
    @When("Reporting manager enter {string}{string} and click on refresh button")
    public void reportingManagerEnterAndClickOnRefreshButton(String arg0, String arg1) {
        customersByNumberOfOrders=new CustomersByNumberOfOrders(driver);
        customersByNumberOfOrders.customerByNumberOfOrdersMethod(arg0,arg1);
    }

    @Then("verifymanager can see customers by number of orders")
    public void verifymanagerCanSeeCustomersByNumberOfOrders() {
        customersByNumberOfOrders=new CustomersByNumberOfOrders(driver);
        org.testng.Assert.assertTrue(customersByNumberOfOrders.verifyManagerCanSeeCustomersByNumberOfOrders());
    }

    @Given("Reporting manager on the dashboard page and click on tags_popular Link")
    public void reportingManagerOnTheDashboardPageAndClickOnTags_popularLink() {
        reportingDashboardPage.click_PopularLink();
    }

    @Then("verify popular report displayed")
    public void verifyPopularReportDisplayed() {
        popularPage.verifyPopularReportDisplayed();
    }

    @Given("Reporting manager is on the dashboard page and click on product review link")
    public void reportingManagerIsOnTheDashboardPageAndClickOnProductReviewLink() {
        reportingDashboardPage.click_Products_Reviews();
    }

    @Then("verify product review report display")
    public void verifyProductReviewReportDisplay() {
        report_ReviewsPage.verifyProductReviewReportSuccessfullyDisplayed();
    }


    @After("@ReportingModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }


}

