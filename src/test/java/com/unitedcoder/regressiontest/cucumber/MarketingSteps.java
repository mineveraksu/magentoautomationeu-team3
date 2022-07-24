package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.marketingpages.MarketingDashboardPage;
import com.seleniummaster.maganto.backendpages.marketingpages.ViewAllReviewsPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MarketingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    MarketingDashboardPage marketingDashboardPage;
    ViewAllReviewsPage viewAllReviewsPage;

    @Before("@MarketingModule")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.marketingPageLogin();
    }

    @Given("marketing manager is on the dashboard page and clicks on Newsletter Templates link")
    public void marketingManagerIsOnTheDashboardPageAndClicksOnNewsletterTemplatesLink() {
    }

    @When("marketing manager clicks on Add New Template button and fill out New Newsletter Template Information and clicks save Template button")
    public void marketingManagerClicksOnAddNewTemplateButtonAndFillOutNewNewsletterTemplateInformationAndClicksSaveTemplateButton() {
    }

    @Then("a new Newsletter template added successfully")
    public void aNewNewsletterTemplateAddedSuccessfully() {
    }


    //ViewPendingReviews
    @Given("marketing manager is on the dashboard page and marketing manager click on pending reviews link")
    public void marketingManagerIsOnTheDashboardPageAndMarketingManagerClickOnPendingReviewsLink() {
        marketingDashboardPage=new MarketingDashboardPage(driver);
        marketingDashboardPage.clickOnPendingReviewsLink();

    }

    @When("marketing manager view on pending reviews page")
    public void marketingManagerViewOnPendingReviewsPage() {
        viewAllReviewsPage=new ViewAllReviewsPage(driver);
    }

    @Then("the pending reviews view successfully")
    public void thePendingReviewsViewSuccessfully() {
        Assert.assertTrue(viewAllReviewsPage.verifyViewPendingReviewsSuccessfully());
    }


    @After("@MarketingModule")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }
}