package com.unitedcoder.regressiontest.cucumber.store;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.maganto.backendpages.storepages.StoreManagerWebPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateWebsiteSteps extends BasePage {

    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    StoreManagerWebPage storeManagerWebPage;


    @Before
    public void setup() {
        browserSetUp(url);
    }
    @When("store manager click create website button and fill out{string} {string} field and click save button")
    public void storeManagerClickCreateWebsiteButtonAndFillTheOutFieldAndClickSaveButton(String arg0, String arg1) {
        storeManagerWebPage=new StoreManagerWebPage(driver);
        storeManagerWebPage.createWebsite(arg0,arg1);

    }

    @Then("website created successfully")
    public void websiteCreatedSuccessfully() {
    }
}
