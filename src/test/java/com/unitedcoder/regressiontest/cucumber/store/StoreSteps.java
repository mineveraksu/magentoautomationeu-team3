package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.ProductPage;
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

public class StoreSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    StoreDashboardPage storeDashboardPage;
    ProductPage productPage;
    private String name;
    private String description;
    private String shortDescription;
    private String SKU;

    @Before
    public void setup() {
        browserSetUp(url);
    }

    @Given("store manager is on the dashboard page")
    public void storeManagerIsOnTheDashboardPage() {
        login = new BackEndLogin(driver);
        login.storePageLogin();
        storeDashboardPage = new StoreDashboardPage(driver);
        productPage=new ProductPage(driver);

    }

    @When("store manager clicks on create store button to fill out {string} and other information")
    public void storeManagerClicksOnCreateStoreButtonToFillOutAndOtherInformation(String arg0) {
    }

    @Then("the store should be saved successfully")
    public void theStoreShouldBeSavedSuccessfully() {
    }

    @When("click on add product button to fill out {string} {string} {string} {string} and other information information")
    public void clickOnAddProductButtonToFillOutAndOtherInformationInformation(String arg0, String arg1, String arg2, String arg3) {
        name=arg0;
        description=arg1;
        shortDescription=arg2;
        SKU=arg3;
        productPage.addProduct(name,description,shortDescription,SKU);

    }

    @Then("a new product created successfully")
    public void aNewProductCreatedSuccessfully() {
        Assert.assertTrue(productPage.verifyAddProduct());

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


