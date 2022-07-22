package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;

public class MarketingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;

//    @Before("@MarketingModule")
//    public void setup() {
//        browserSetUp(url);
//        login = new BackEndLogin(driver);
//        //login.storePageLogin();
//    }
//
//    @After("@MarketingModule")
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
//            screenShotUtility.takeScreenshot("image", "failedTest", driver);
//        }
//        closeBrowser();
//    }
}
