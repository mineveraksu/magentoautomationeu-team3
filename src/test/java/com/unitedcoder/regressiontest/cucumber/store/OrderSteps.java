package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.OrdersPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class OrderSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    StoreDashboardPage storeDashboardPage;
    OrdersPage ordersPage;

    @Before
    public void setup (){
        browserSetUp(url);
        login= new BackEndLogin(driver);
        login.storePageLogin();
    }

    @Given("store manager is on the dashboard page and store manager click on orders link")
    public void storeManagerIsOnTheDashboardPageAndStoreManagerClickOnOrdersLink() {
        storeDashboardPage= new StoreDashboardPage(driver);
        storeDashboardPage.clickOnOrdersLink();


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

    @When("store manager search orders number and edit some information")
    public void storeManagerSearchOrdersNumberAndEditSomeInformation() {
    }

    @Then("edit orders successful")
    public void editOrdersSuccessful() {
    }
}
