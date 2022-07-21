package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.StoreProductPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
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

public class ProductSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    StoreDashboardPage storeDashboardPage;
    StoreProductPage storeProductPage;

    @Before
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.storePageLogin();
    }


    @Given("store manager is on the dashboard page store manager click on manage products link")
    public void storeManagerIsOnTheDashboardPageStoreManagerClickOnManageProductsLink() {
        storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickOnManageProductLink();
    }

    @When("click on add product button to fill out {string} {string} {string} {string} and other information information")
    public void clickOnAddProductButtonToFillOutAndOtherInformationInformation(String arg0, String arg1, String arg2, String arg3) {
      storeProductPage=new StoreProductPage(driver);
      storeProductPage.addProduct(arg0,arg1,arg2,arg3);
    }

    @Then("a new product created successfully")
    public void aNewProductCreatedSuccessfully() {
        Assert.assertTrue(storeProductPage.verifyAddProduct());
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
