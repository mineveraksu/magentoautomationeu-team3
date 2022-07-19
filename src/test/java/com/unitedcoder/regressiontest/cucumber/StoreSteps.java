package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;

    @Before
    public void setup() {
        browserSetUp(url);
    }

    @Given("store manager is on the dashboard page")
    public void storeManagerIsOnTheDashboardPage() {
        login = new BackEndLogin(driver);
        login.storePageLogin();
    }

    @When("store manager clicks on create store button to fill out {string} and other information")
    public void storeManagerClicksOnCreateStoreButtonToFillOutAndOtherInformation(String arg0) {
    }

    @Then("the store should be saved successfully")
    public void theStoreShouldBeSavedSuccessfully() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }

}
