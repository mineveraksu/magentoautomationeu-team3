package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.reportingpages.ProductsMostViewedPage;
import com.seleniummaster.maganto.backendpages.reportingpages.ReportingDashboardPage;
import com.seleniummaster.maganto.backendpages.reportingpages.InvoicedVsPaidReportPage;
import com.seleniummaster.maganto.backendpages.reportingpages.ShippedReportPage;
import com.seleniummaster.maganto.utility.*;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
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
    ExcelUtility excelUtility;
    InvoicedVsPaidReportPage InvoicedVsPaidReportPage;
    ShippedReportPage shippedReportPage;


    @Before("@ReportingModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.reportingPageLogin();
        reportingDashboardPage=new ReportingDashboardPage(driver);
        productsMostViewedPage=new ProductsMostViewedPage(driver);
        excelUtility=new ExcelUtility();
        testDataHolder=excelUtility.readReportingInfoFromExcel("Test-Data/reportingModule.xlsx","Sales_Info");
    }
    @Given("Reporting manager is on the dashboard page and clicks on Downloads link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnDownloadsLink() {
    }
    @Given("Reporting manager is on the dashboard page and clicks on mostViewed link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnMostViewedLink() {
        reportingDashboardPage.clickOnMostViewedLink();
    }

    @When("reporting manager select period field and click showReports button after filling infos")
    public void reportingManagerSelectPeriodFieldAndClickShowReportsButtonAfterFillingInfos() {
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
        InvoicedVsPaidReportPage=new InvoicedVsPaidReportPage(driver);
        InvoicedVsPaidReportPage.viewSalesInvoicedVsPaidReport(arg0,arg1);
    }

    @Then("Total Invoiced Vs Paid report view successfully")
    public void totalInvoicedVsPaidReportViewSuccessfully() {
        Assert.assertTrue(InvoicedVsPaidReportPage.verifyViewSalesInvoicedVsPaidReportSuccessfully());
    }

    //See Sales-Total Shipped Report
    @Given("Reporting manager is on the dashboard page and clicks on Shipping Option")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnShippingOption() {
        reportingDashboardPage.ClickOnShippingOption();
    }

    @When("Reporting Manager Navigate to Total Shipped Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToTotalShippedReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1) {
        shippedReportPage=new ShippedReportPage(driver);
        shippedReportPage.viewSalesShippedReport(arg0,arg1);
    }

    @Then("Total Shipped report view successfully")
    public void totalShippedReportViewSuccessfully() {
        shippedReportPage=new ShippedReportPage(driver);
        Assert.assertTrue(shippedReportPage.verifyViewSalesShippedReportSuccessfully());

    }
//See Products-Products Ordered Report
    @Given("Reporting manager is on the dashboard page and clicks on Products Ordered link")
    public void reportingManagerIsOnTheDashboardPageAndClicksOnProductsOrderedLink() {
        reportingDashboardPage.ClickOnProductsOrderedOption();

    }

    @When("Reporting Manager Navigate to products ordered report page and select period and date {string} {string} and click Refresh button")
    public void reportingManagerNavigateToProductsOrderedReportPageAndSelectPeriodAndDateAndClickRefreshButton(String arg0, String arg1) {
        productsMostViewedPage.viewProductsOrderedReport(arg0,arg1);

    }

    @Then("Total products Ordered report displayed successfully")
    public void totalProductsOrderedReportDisplayedSuccessfully() {
        Assert.assertTrue(productsMostViewedPage.verifyViewProductsOrderedReport());
    }


}


//    @After("@ReportingModuleTest")
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
//            screenShotUtility.takeScreenshot("image", "failedTest", driver);
//        }
//        closeBrowser();
//    }



