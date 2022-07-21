package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.ScreenShotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreSteps extends BasePage {

    @When("store manager clicks on create store button to fill out store information")
    public void storeManagerClicksOnCreateStoreButtonToFillOutAndOtherInformation() {
    }

    @Then("the store should be saved successfully")
    public void theStoreShouldBeSavedSuccessfully() {
    }


}
