package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.marketingpages.MarketingdashboardPage;
import com.seleniummaster.maganto.backendpages.marketingpages.NewsletterTemplatePage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MarketingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    MarketingdashboardPage marketingdashboardPage;
    NewsletterTemplatePage newsletterTemplatePage;

    @Before("@MarketingModule")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.marketingPageLogin();
        marketingdashboardPage = new MarketingdashboardPage(driver);
    }

    @Given("marketing manager is on the dashboard page and clicks on Newsletter Templates link")
    public void marketingManagerIsOnTheDashboardPageAndClicksOnNewsletterTemplatesLink() {
        marketingdashboardPage.clickOnNewsletterTemplatesLink();
        newsletterTemplatePage = new NewsletterTemplatePage(driver);
    }

    @When("marketing manager clicks on Add New Template button and fill out {string}{string} Information and clicks save Template button")
    public void marketingManagerClicksOnAddNewTemplateButtonAndFillOutInformationAndClicksSaveTemplateButton(String arg0, String arg1) {
        newsletterTemplatePage.addNewNewsletterTemplate(arg0,arg1);
    }

    @Then("a new Newsletter template {string} added successfully")
    public void aNewNewsletterTemplateAddedSuccessfully(String arg0) {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully(arg0));
    }

    @When("marketing manager clicks on {string} and change email to click on save Template button")
    public void marketingManagerClicksOnAndChangeEmailToClickOnSaveTemplateButton(String arg0) {
        newsletterTemplatePage.updateNewsletterTemplate(arg0);
    }

    @Then("The Newsletter template updated successfully")
    public void theNewsletterTemplateUpdatedSuccessfully() {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateUpdatedSuccessfully());
    }

    @When("marketing manager clicks on {string}  to click on delete Template button")
    public void marketingManagerClicksOnToClickOnDeleteTemplateButton(String arg0) {
        newsletterTemplatePage.deleteNewsletterTemplate(arg0);
    }

    @Then("The Newsletter template {string} deleted successfully")
    public void theNewsletterTemplateDeletedSuccessfully(String arg0) {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateDeletedSuccessfully(arg0));
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
