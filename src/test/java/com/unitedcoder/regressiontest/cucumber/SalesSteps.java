package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.marketingpages.MarketingDashboardPage;
import com.seleniummaster.maganto.backendpages.marketingpages.NewsletterTemplatePage;
import com.seleniummaster.maganto.backendpages.marketingpages.ReviewsPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesShipmentsPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    SalesDashboardPage salesDashboardPage;
    SalesShipmentsPage salesShipmentsPage;


    @Before("@SalesModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.salesPageLogin();
        salesDashboardPage=new SalesDashboardPage(driver);
    }
    @Given("Sales manager is on the dashboard page and clicks on Orders link")
    public void salesManagerIsOnTheDashboardPageAndClicksOnOrdersLink() {

    }

    //UpdateShipment
    @Given("Sales manager is on the dashboard page and clicks on ShipmentsOption")
    public void salesManagerIsOnTheDashboardPageAndClicksOnShipmentsOption() {
        salesDashboardPage.clickOnShipmentsOption();
    }

    @When("Sales Manager click view icon and fill out {string} information and click submit comment button")
    public void salesManagerClickViewIconAndFillOutInformationAndClickSubmitCommentButton(String arg0) {
    }

    @And("Sale Manager edit shipping and tracking information and fill out {string} and click add button")
    public void saleManagerEditShippingAndTrackingInformationAndFillOutAndClickAddButton(String arg0) {
    }

    @Then("the shipments update successfully")
    public void theShipmentsUpdateSuccessfully() {
    }




    @After("@SalesModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }


}
