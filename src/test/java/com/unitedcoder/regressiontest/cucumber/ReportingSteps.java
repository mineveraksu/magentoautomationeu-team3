package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.reportingpages.ProductsMostViewedPage;
import com.seleniummaster.maganto.backendpages.reportingpages.ReportingDashboardPage;
import com.seleniummaster.maganto.backendpages.reportingpages.SalesPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesDashboardPage;
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


    @Before("@ReportingModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.reportingPageLogin();
        reportingDashboardPage=new ReportingDashboardPage(driver);
        productsMostViewedPage=new ProductsMostViewedPage(driver);
        excelUtility=new ExcelUtility();
        testDataHolder=excelUtility.readReportingInfoFromExcel("Test-Data/reportingModule.xlsx","Sales_Info");
        testDataHolder2=excelUtility.readSalesInfoFromExcel("Test-Data/SalesModule.xlsx","Refunds_Info");
        salesPage= new SalesPage(driver);
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

    @After("@ReportingModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }


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
}
