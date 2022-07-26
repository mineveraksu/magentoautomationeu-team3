package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.reportingpages.ProductsMostViewedPage;
import com.seleniummaster.maganto.backendpages.reportingpages.ReportingDashboardPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    ReportingDashboardPage reportingDashboardPage;
    ProductsMostViewedPage productsMostViewedPage;


    @Before("@ReportingModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.reportingPageLogin();
        reportingDashboardPage=new ReportingDashboardPage(driver);
        productsMostViewedPage=new ProductsMostViewedPage(driver);
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
        productsMostViewedPage.viewProductsMostViewedReport();
    }

    @Then("most viewed products report displayed successfully")
    public void mostViewedProductsReportDisplayedSuccessfully() {
        productsMostViewedPage.verifyMostViewedProductsDisplayed();
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
