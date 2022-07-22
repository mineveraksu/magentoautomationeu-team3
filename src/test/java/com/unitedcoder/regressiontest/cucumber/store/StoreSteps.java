package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.storepages.StoreManagerWebPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreSteps {
    StoreManagerWebPage storeManagerWebPage;


    @Then("the store names should display")
    public void theStoreNamesShouldDisplay() {
        Assert.assertTrue(storeManagerWebPage.verifyAllStoresViewed());
    }
}
