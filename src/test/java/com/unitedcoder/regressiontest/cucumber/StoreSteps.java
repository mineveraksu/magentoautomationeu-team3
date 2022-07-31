package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.*;
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
    StoreWebsitePage storeWebsitePage;
    StoreProductPage storeProductPage;
    StoreOrdersPage storeOrdersPage;
    ExcelUtility excelUtility;
    TestDataHolder testDataHolder;
    StorePage storePage;
    String storeName;
    String storeCode;
    StoreViewPage storeViewPage;

    @Before("@StoreModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.storePageLogin();
        storeDashboardPage = new StoreDashboardPage(driver);
        excelUtility = new ExcelUtility();
        testDataHolder = excelUtility.readStoreInfoFromExcel("Test-Data/storeModuleData.xlsx", "Store_Info");
    }

    //create website
    @Given("store manager is on the dashboard page store manager click on manage stores link")
    public void storeManagerIsOnTheDashboardPage() {
        storeDashboardPage.clickOnManageStoresLink();
    }

    @When("store manager click create website button and fill out Website Information and click save button")
    public void storeManagerClickCreateWebsiteButtonAndFillOutWebsiteInformationAndClickSaveButton() {
        storeWebsitePage = new StoreWebsitePage(driver);
        storeWebsitePage.createWebsite(testDataHolder);
    }

    @Then("website created successfully")
    public void websiteCreatedSuccessfully() {
        Assert.assertTrue(storeWebsitePage.verifyWebsiteCreatedSuccessfully());
    }

    //edit website
    @When("store manager select the website and edit website information and click save button")
    public void storeManagerSelectTheWebsiteAndEditWebsiteInformationAndClickSaveButton() {
        storeWebsitePage=new StoreWebsitePage(driver);
        storeWebsitePage.editWebsite(testDataHolder);
    }
    @Then("website edit successfully")
    public void websiteEditSuccessfully(){
        Assert.assertTrue(storeWebsitePage.verifyWebsiteEditSuccessfully());
    }


    //delete website
    @When("store manager select the website then click on the delete website button")
    public void storeManagerSelectTheWebsiteThenClickOnTheDeleteWebsiteButton() {
        storeWebsitePage = new StoreWebsitePage(driver);
        storeWebsitePage.deleteWebsite(testDataHolder);
    }

    @Then("website deleted successfully")
    public void websiteDeletedSuccessfully() {
        Assert.assertTrue(storeWebsitePage.verifyWebsiteDeletedSuccessfully());
    }

    //create store
    @When("store manager clicks on create store button to fill out store information")
    public void storeManagerClicksOnCreateStoreButtonToFillOutStoreInformation() {
        storePage = new StorePage(driver);
        storePage.createStore(testDataHolder);
    }

    @Then("the store should be created successfully")
    public void theStoreShouldBeCreatedSuccessfully() {
        Assert.assertTrue(storePage.verifyStoreCreatedSuccessfully());
    }

    //update store
    @When("store manager clicks on the store name to edit store then clicks on save store button")
    public void storeManagerClicksOnTheStoreNameToEditStoreThenClicksOnSaveStoreButton() {
        storePage = new StorePage(driver);
        storePage.editStore(testDataHolder);
    }

    @Then("the store should be edited successfully")
    public void theStoreShouldBeEditedSuccessfully() {
        Assert.assertTrue(storePage.verifyStoreEditedSuccessfully());
        storePage.createStore(testDataHolder);
    }

    //create store view
    @When("Store manager click the create store view button")
    public void storeManagerClickTheCreateStoreViewButton() {
        storeViewPage = new StoreViewPage(driver);
        storeViewPage.clickOnCreateStoreViewButton();
    }

    @And("fill out the information field{string}{string}")
    public void fillOutTheInformationField(String arg0, String arg1) {
        storeName = arg0;
        storeCode = arg1;
        storeViewPage = new StoreViewPage(driver);
        storeViewPage.createAStoreView(testDataHolder, storeName, storeCode);
    }

    @Then("Verify the created store view saved")
    public void verifyTheCreatedStoreViewSaved() {
        Assert.assertTrue(storeViewPage.verifyStoreViewSaved());
    }

    //update store view
    //view all stores
    @Then("the store names should display on this page.")
    public void theStoreNamesShouldDisplayOnThisPage() {
        StorePage storePage = new StorePage(driver);
        Assert.assertTrue(storePage.verifyAllStoresViewed());
    }

    @When("Store manager click the created store view link and put update name{string}")
    public void storeManagerClickTheCreatedStoreViewLinkAndPutUpdateName(String arg0) {
        storeViewPage = new StoreViewPage(driver);
        storeViewPage.editStoreView(arg0);
    }

    @Then("Verify the updated store view saved")
    public void verifyTheUpdatedStoreViewSaved() {
        Assert.assertTrue(storeViewPage.verifyStoreViewSaved());
    }


    //delete store
    @When("store manager clicks on the store name to click on the delete store button")
    public void storeManagerClicksOnTheStoreNameToClickOnTheDeleteStoreButton() {
        storePage = new StorePage(driver);
        storePage.deleteStore(testDataHolder);
    }

    @Then("the store should be deleted successfully")
    public void theStoreShouldBeDeletedSuccessfully() {
        Assert.assertTrue(storePage.verifyStoreDeletedSuccessfully());
    }

    //create product
    @Given("store manager is on the dashboard page store manager click on manage products link")
    public void storeManagerIsOnTheDashboardPageStoreManagerClickOnManageProductsLink() {
        storeDashboardPage.clickOnManageProductLink();

    }

    @When("click on add product button to fill out {string} {string} {string} {string} {string} {string} {string} and other information information")
    public void clickOnAddProductButtonToFillOutAndOtherInformationInformation(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        storeProductPage = new StoreProductPage(driver);
        storeProductPage.addProduct(testDataHolder, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Then("a new product created successfully")
    public void aNewProductCreatedSuccessfully() {
        org.junit.Assert.assertTrue(storeProductPage.verifyAddProductSuccessfully());
    }
    //update product
    @When("select the product {string} and update description {string}")
    public void selectTheProductAndUpdateDescription(String arg0, String arg1) {
        storeProductPage=new StoreProductPage(driver);
        storeProductPage.selectProduct(arg0);
        storeProductPage.updateProduct(arg1);
    }

    @Then("product information updated successfully")
    public void productInformationUpdatedSuccessfully() {
        Assert.assertTrue(storeProductPage.ProductUpdateSuccessfully());
    }


    //delete product

    //create order
    @Given("store manager is on the dashboard page and store manager click on orders link")
    public void storeManagerIsOnTheDashboardPageAndStoreManagerClickOnOrdersLink() {
        storeDashboardPage.clickOnOrdersLink();
    }

    @And("select shipping and payment methods and submit order")
    public void selectShippingAndPaymentMethodsAndSubmitOrder() {
        storeOrdersPage = new StoreOrdersPage(driver);
        storeOrdersPage.selectShippingMethodAndSubmitOrder();
    }

    @Then("the order should be saved successfully")
    public void theOrderShouldBeSavedSuccessfully() {
        Assert.assertTrue(storeOrdersPage.verifyCreateNewOrder());
    }

    //edit order
    @When("store manager search orders number and edit some information")
    public void storeManagerSearchOrdersNumberAndEditSomeInformation() {
    }

    @Then("edit orders successful")
    public void editOrdersSuccessful() {
    }

    //cancel order

    //add product categories
    @When("store manager clicks categories link and check the existing product categories")
    public void storeManagerClicksCategoriesLinkAndCheckTheExistingProductCategories() {
        storeProductPage = new StoreProductPage(driver);
        storeProductPage.addProductCategory();
    }

    @Then("verify added a new product category")
    public void verifyAddedANewProductCategory() {
        org.junit.Assert.assertTrue(storeProductPage.verifyAddProductCategory());
    }

    //update product categories
    @When("store manager clicks an existing product and check other existing product category")
    public void storeManagerClicksAnExistingProductAndCheckOtherExistingProductCategory() {
        storeProductPage = new StoreProductPage(driver);
        storeProductPage.updateProductCategory();
    }

    @Then("verify update the product category")
    public void verifyUpdateTheProductCategory() {
        Assert.assertTrue(storeProductPage.verifyUpdateProductCategory());

    }

    //delete product categories
    @When("store manager clicks an existing product and delete the product category")
    public void storeManagerClicksAnExistingProductAndDeleteTheProductCategory() {
        storeProductPage = new StoreProductPage(driver);
        storeProductPage.deleteProductCategory();


    }

    @Then("verify delete the product category")
    public void verifyDeleteTheProductCategory() {
        org.junit.Assert.assertTrue(storeProductPage.verifyDeleteProductCategory());
    }


    @When("store manager select a customer and a store {string} and a product")
    public void storeManagerSelectACustomerAndAStoreAndAProduct(String arg0) {
        storeDashboardPage.clickOnCreateNewOrderLink();
        storeOrdersPage = new StoreOrdersPage(driver);
        storeOrdersPage.selectCustomerAndProduct(arg0);
    }

    @After("@StoreModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }
}






