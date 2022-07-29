package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.salespages.InvoicesPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesShipmentsPage;
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
import org.junit.Assert;

public class SalesSteps extends BasePage {
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
    BackEndLogin login;
    SalesDashboardPage salesDashboardPage;
    InvoicesPage invoicesPage;
    SalesShipmentsPage salesShipmentsPage;


    @Before("@SalesModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.salesPageLogin();
        salesDashboardPage = new SalesDashboardPage(driver);
    }

    @Given("Sales manager is on the dashboard page and clicks on Orders link")
    public void salesManagerIsOnTheDashboardPageAndClicksOnOrdersLink() {
    }

    @Given("sales manager is on the dashboard page and click on invoices link")
    public void salesManagerIsOnTheDashboardPageAndClickOnInvoicesLink() {
        salesDashboardPage = new SalesDashboardPage(driver);
        salesDashboardPage.clickOnInvoicesLink();
    }

    @When("sales manager click edit button and click comment text and added comment to {string} filed")
    public void salesManagerClickEditButtonAndClickCommentTextAndAddedCommentToFiled(String arg0) {
        invoicesPage = new InvoicesPage(driver);
        invoicesPage.viewInvoicesAndAddComments(arg0);
    }

    @Then("view invoices successfully and added comments to invoice history successfully")
    public void viewInvoicesSuccessfullyAndAddedCommentsToInvoiceHistorySuccessfully() {
        Assert.assertTrue(invoicesPage.verifyViewInvoices());
        Assert.assertTrue(invoicesPage.verifyAddedCommentsToInvoiceHistorySuccessful());
    }

    //UpdateShipments

    @Given("Sales manager is on the dashboard page and clicks on shipmentsOption")
    public void salesManagerIsOnTheDashboardPageAndClicksOnShipmentsOption() {
        salesDashboardPage.clickOnShipmentsOption();
    }

    @When("Sales Manager click view icon and fill out {string} information and click on submit comment button")
    public void salesManagerClickViewIconAndFillOutInformationAndClickOnSubmitCommentButton(String arg0) {
        salesShipmentsPage = new SalesShipmentsPage(driver);
        salesShipmentsPage.updateShipmentsHistory(arg0);
    }

    @And("Sales Manager edit shipping and tracking information and fill out {string} and click on add button")
    public void salesManagerEditShippingAndTrackingInformationAndFillOutAndClickOnAddButton(String arg0) {
        salesShipmentsPage.updateTrackingInformation(arg0);
    }

    @Then("the shipments update successfully")
    public void theShipmentsUpdateSuccessfully() {
        salesShipmentsPage.verifyUpdateShipmentsHistorySuccessfully();
        salesShipmentsPage.verifyUpdateShipmentsTrackingInformationSuccessfully();
    }

    @After("@SalesModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }

    //Add and update Tax Rules
    @Given("Sales manager is on the dashboard page and clicks on Manage Tax Rules")
    public void salesManagerIsOnTheDashboardPageAndClicksOnManageTaxRules() {
        SalesDashboardPage salesDashboardPage = new SalesDashboardPage(driver);
        salesDashboardPage.clickOnManageTaxRulesLink();
    }

    @When("Sales Manager click Add New Tax Rule  icon and fill out {string} {string} {string} information and click on Save Rule button")
    public void salesManagerClickIconAndFillOutInformationAndClickOnSaveRuleButton(String arg0, String arg1, String arg2) {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.addNewTaxRule(arg0, arg1, arg2);

    }

    @And("Sales Manager edit tax rules and click on Save Rule button")
    public void salesManagerEditTaxRulesAndClickOnSaveRuleButton(String arg0, String arg1, String arg2) {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.updateNewTaxRule(arg0, arg1, arg2);


    }

    @Then("a new Tax Rule created successfully")
    public void aNewTaxRuleCreatedSuccessfully() {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.verifyAddNewTaxRuleRuleSuccessfully();

    }

    @And("the new Tax Rule update successfully")
    public void theNewTaxRuleUpdateSuccessfully() {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.verifyUpdateNewTaxRuleRuleSuccessfully();
    }
}
