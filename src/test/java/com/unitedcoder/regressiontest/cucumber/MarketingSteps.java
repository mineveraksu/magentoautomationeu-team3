package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.marketingpages.CatalogPriceRulePage;
import com.seleniummaster.maganto.backendpages.marketingpages.MarketingDashboardPage;
import com.seleniummaster.maganto.backendpages.marketingpages.NewsletterTemplatePage;
import com.seleniummaster.maganto.backendpages.marketingpages.ReviewsPage;
import com.seleniummaster.maganto.utility.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MarketingSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    MarketingDashboardPage marketingdashboardPage;
    NewsletterTemplatePage newsletterTemplatePage;
    ReviewsPage reviewsPage;
    CatalogPriceRulePage catalogPriceRulePage;
    TestDataHolder testDataHolder;
    ExcelUtility excelUtility;
    String RuleName;

    @Before("@MarketingModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.marketingPageLogin();
        marketingdashboardPage = new MarketingDashboardPage(driver);
        excelUtility=new ExcelUtility();
        //testDataHolder=new TestDataHolder();
        testDataHolder = excelUtility.readStoreInfoFromExcel("Test-Data/storeModuleData.xlsx", "Store_Info");
    }

    @Given("marketing manager is on the dashboard page and clicks on Newsletter Templates link")
    public void marketingManagerIsOnTheDashboardPageAndClicksOnNewsletterTemplatesLink() {
        marketingdashboardPage.clickOnNewsletterTemplatesLink();
        newsletterTemplatePage = new NewsletterTemplatePage(driver);
    }

    @When("marketing manager clicks on Add New Template button and fill out {string}{string} Information and clicks save Template button")
    public void marketingManagerClicksOnAddNewTemplateButtonAndFillOutInformationAndClicksSaveTemplateButton(String arg0, String arg1) {
        newsletterTemplatePage.addNewNewsletterTemplate(arg0, arg1);
    }

    @Then("a new Newsletter template {string} added successfully")
    public void aNewNewsletterTemplateAddedSuccessfully(String arg0) {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully(arg0));
    }

    @When("marketing manager clicks on {string} and change email to click on save Template button")
    public void marketingManagerClicksOnAndChangeEmailToClickOnSaveTemplateButton(String arg0) {
        newsletterTemplatePage.updateNewsletterTemplate(arg0);
    }

    @Then("The Newsletter template updated successfully")
    public void theNewsletterTemplateUpdatedSuccessfully() {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateUpdatedSuccessfully());
    }

    @When("marketing manager clicks on {string}  to click on delete Template button")
    public void marketingManagerClicksOnToClickOnDeleteTemplateButton(String arg0) {
        newsletterTemplatePage.deleteNewsletterTemplate(arg0);
    }

    @Then("The Newsletter template {string} deleted successfully")
    public void theNewsletterTemplateDeletedSuccessfully(String arg0) {
        Assert.assertTrue(newsletterTemplatePage.verifyNewsletterTemplateDeletedSuccessfully(arg0));
    }


    @Given("marketing manager is on the dashboard page and marketing manager click on all reviews link")
    public void marketingManagerIsOnTheDashboardPageAndMarketingManagerClickOnAllReviewsLink() {
        marketingdashboardPage.clickOnAllReviewsLink();
    }

    @When("marketing manager click existing review edit button and clear the review field and edit new review in {string} field")
    public void marketingManagerClickExistingReviewEditButtonAndClearTheReviewFieldAndEditNewReviewInField(String arg0) {
        reviewsPage = new ReviewsPage(driver);
        reviewsPage.updateExistingReview(arg0);
    }

    @Then("existing reviews updated successfully")
    public void existingReviewsUpdatedSuccessfully() {
        org.junit.Assert.assertTrue(reviewsPage.verifyReviewEdit());
    }

    //ViewPendingReviews
    @Given("marketing manager is on the dashboard page and marketing manager click on pending reviews link")
    public void marketingManagerIsOnTheDashboardPageAndMarketingManagerClickOnPendingReviewsLink() {
        marketingdashboardPage = new MarketingDashboardPage(driver);
        marketingdashboardPage.clickOnPendingReviewsLink();

    }

    @When("marketing manager view on pending reviews page")
    public void marketingManagerViewOnPendingReviewsPage() {
        reviewsPage = new ReviewsPage(driver);

    }

    @Then("the pending reviews view successfully")
    public void thePendingReviewsViewSuccessfully() {
        Assert.assertTrue(reviewsPage.verifyViewPendingReviewsSuccessfully());
    }

    @When("marketing manager update on mandatory field")
    public void marketingManagerUpdateOnMandatoryField() {
        reviewsPage = new ReviewsPage(driver);
        reviewsPage.clickOnEditIcon();
        reviewsPage.updatePendingReview();
    }

    @Then("the pending reviews update successful")
    public void thePendingReviewsUpdateSuccessful() {
        reviewsPage = new ReviewsPage(driver);
        Assert.assertTrue(reviewsPage.verifyReviewUpdateSuccessful());
    }

    @Given("marketing manager is on the dashboard page and marketing manager click on  the newsletter link.")
    public void marketingManagerIsOnTheDashboardPageAndMarketingManagerClickOnTheNewsletterLink() {
    }

    @When("marketing manager click on the newsletter subscribers link")
    public void marketingManagerClickOnTheNewsletterSubscribersLink() {
    }

    @Then("newsletter subscribers page should open successfully")
    public void newsletterSubscribersPageShouldOpenSuccessfully() {
    }

    //addnewrule
    @Given("marketing manager is on the dashboard page and clicks on catalog price rule link")
    public void marketingManagerIsOnTheDashboardPageAndClicksOnCatalogPriceRuleLink() {
        marketingdashboardPage.clickONCatalogPriceRuleLink();
    }

    @When("marketing manager click the add new rule button and fill out{string}")
    public String marketingManagerClickTheAddNewRuleButtonAndFillOut(String arg0) {
        RuleName=arg0;
        catalogPriceRulePage=new CatalogPriceRulePage(driver);
        catalogPriceRulePage.AddNewRule(RuleName,testDataHolder,"65");
        return RuleName;
    }

    @Then("verify new rule added successfully")
    public void verifyNewRuleAddedSuccessfully() {
        Assert.assertTrue(catalogPriceRulePage.verifySavedNewRule());
    }
   // search rule by id and name

    @When("Marketing manager enter rule name and rule id search the rule{string}{string}")
    public void marketingManagerEnterRuleNameAndRuleIdSearchTheRule(String arg0, String arg1) {
        catalogPriceRulePage=new CatalogPriceRulePage(driver);
        RuleName=arg0;
        catalogPriceRulePage.searchByName(arg0);
        catalogPriceRulePage.searchById(arg1);
    }

    @Then("Verify searched rule successfully")
    public void verifySearchedRuleSuccessfully() {
       Assert.assertTrue(catalogPriceRulePage.verifySearchResult(RuleName));
    }
    @After("@MarketingModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }



}



