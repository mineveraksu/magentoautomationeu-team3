package com.unitedcoder.regressiontest.cucumber.store;
import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreWebsitePage;
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

public class WebsiteSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    StoreDashboardPage storeDashboardPage;
    StoreWebsitePage storeManagerWebPage;

    @Before
    public void setup() {
        browserSetUp(url);

    }

    @Given("store manager is on the dashboard page store manager click on manage stores link")
    public void storeManagerIsOnTheDashboardPage() {
        login = new BackEndLogin(driver);
        login.storePageLogin();
        storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickOnManageStoresLink();
    }

    @When("store manager click create website button and fill out{string} {string} field and click save button")
    public void storeManagerClickCreateWebsiteButtonAndFillTheOutFieldAndClickSaveButton(String arg0, String arg1) {
        storeManagerWebPage=new StoreWebsitePage(driver);
        storeManagerWebPage.createWebsite(arg0,arg1);

    }

    @Then("website created successfully")
    public void websiteCreatedSuccessfully() {
        Assert.assertTrue(storeManagerWebPage.verifyWebsiteCreatedSuccessfully());
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
