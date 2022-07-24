package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.backendpages.storepages.StorePage;
import com.seleniummaster.maganto.backendpages.storepages.StoreProductPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreWebsitePage;
import com.seleniummaster.maganto.utility.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    StoreDashboardPage storeDashboardPage;
    StoreWebsitePage storeManagerWebPage;
    StoreProductPage storeProductPage;
    ExcelUtility excelUtility;
    TestDataHolder testDataHolder;
    StorePage storePage;

    @Before("@StoreModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.storePageLogin();
        excelUtility=new ExcelUtility();
        testDataHolder=excelUtility.readStoreInfoFromExcel("Test-Data/storeModuleData.xlsx","Store_Info");
    }
    //create website
    @Given("store manager is on the dashboard page store manager click on manage stores link")
    public void storeManagerIsOnTheDashboardPage() {
        storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickOnManageStoresLink();
    }

    @When("store manager click create website button and fill out Website Information and click save button")
    public void storeManagerClickCreateWebsiteButtonAndFillOutWebsiteInformationAndClickSaveButton() {
        storeManagerWebPage=new StoreWebsitePage(driver);
        storeManagerWebPage.createWebsite(testDataHolder);
    }

    @Then("website created successfully")
    public void websiteCreatedSuccessfully() {
        Assert.assertTrue(storeManagerWebPage.verifyWebsiteCreatedSuccessfully());
    }
    //edit website
    //delete website

    //create store
    @When("store manager clicks on create store button to fill out store information")
    public void storeManagerClicksOnCreateStoreButtonToFillOutStoreInformation(String arg0) {

    }

    @Then("the store should be saved successfully")
    public void theStoreShouldBeSavedSuccessfully() {
    }
    //update store
    //create store view
    //update store view
    //view all stores

    @Then("the store names should display on this page.")
    public void theStoreNamesShouldDisplayOnThisPage() {
        StorePage storePage=new StorePage();
        Assert.assertTrue(storePage.verifyAllStoresViewed());
    }
    //delete store
    //create product
    @Given("store manager is on the dashboard page store manager click on manage products link")
    public void storeManagerIsOnTheDashboardPageStoreManagerClickOnManageProductsLink() {
        storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickOnManageProductLink();

    }

    @When("click on add product button to fill out {string} {string} {string} {string} {string} {string} {string} and other information information")
    public void clickOnAddProductButtonToFillOutAndOtherInformationInformation(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        storeProductPage=new StoreProductPage(driver);
        storeProductPage.addProduct(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    }

    @Then("a new product created successfully")
    public void aNewProductCreatedSuccessfully() {
        org.junit.Assert.assertTrue(storeProductPage.verifyAddProduct());
    }
    //update product
    //delete product

    //create order
    @Given("store manager is on the dashboard page and store manager click on orders link")
    public void storeManagerIsOnTheDashboardPageAndStoreManagerClickOnOrdersLink() {
    }

    @When("store manager click on create new orders link")
    public void storeManagerClickOnCreateNewOrdersLink() {
    }

    @And("store manager clıck and select the store name")
    public void storeManagerClickAndSelectTheStoreName() {
    }

    @And("store manager select the product name")
    public void storeManagerSelectTheProductName() {
    }

    @And("fill the product information")
    public void fillTheProductInformation() {
    }

    @Then("the order should be saved successfully")
    public void theOrderShouldBeSavedSuccessfully() {
    }
    //edit order
    @When("store manager search orders number and edit some information")
    public void storeManagerSearchOrdersNumberAndEditSomeInformation() {
    }

    @Then("edit orders successful")
    public void editOrdersSuccessful() {
    }
     //cancel order
    @After("@StoreModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }


}
