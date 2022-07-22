package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreProductPage;
import com.seleniummaster.maganto.utility.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps extends BasePage {
    StoreDashboardPage storeDashboardPage;
    StoreProductPage storeProductPage;

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
        Assert.assertTrue(storeProductPage.verifyAddProduct());
    }
}
