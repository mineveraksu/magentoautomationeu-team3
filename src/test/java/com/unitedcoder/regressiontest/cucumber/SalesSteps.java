package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.salespages.InvoicesPage;
import com.seleniummaster.maganto.backendpages.salespages.RefundsPage;
import com.seleniummaster.maganto.backendpages.salespages.SalesDashboardPage;
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
    RefundsPage refundsPage;


    @Before("@SalesModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.salesPageLogin();
        salesDashboardPage=new SalesDashboardPage(driver);
    }
    @Given("Sales manager is on the dashboard page and clicks on Orders link")
    public void salesManagerIsOnTheDashboardPageAndClicksOnOrdersLink() {
    }

    @Given("sales manager is on the dashboard page and click on invoices link")
    public void salesManagerIsOnTheDashboardPageAndClickOnInvoicesLink() {
        salesDashboardPage=new SalesDashboardPage(driver);
        salesDashboardPage.clickOnInvoicesLink();
    }

    @When("sales manager click edit button and click comment text and added comment to {string} filed")
    public void salesManagerClickEditButtonAndClickCommentTextAndAddedCommentToFiled(String arg0) {
        invoicesPage=new InvoicesPage(driver);
        invoicesPage.viewInvoicesAndAddComments(arg0);
    }

    @Then("view invoices successfully and added comments to invoice history successfully")
    public void viewInvoicesSuccessfullyAndAddedCommentsToInvoiceHistorySuccessfully() {
        Assert.assertTrue(invoicesPage.verifyViewInvoices());
        Assert.assertTrue(invoicesPage.verifyAddedCommentsToInvoiceHistorySuccessful());
    }

    @After("@SalesModuleTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
            screenShotUtility.takeScreenshot("image", "failedTest", driver);
        }
        closeBrowser();
    }

    @Given("sales manager click on refunds link")
    public void salesManagerIsOnTheDashboardPageAndClickOnRefundLink() {
        salesDashboardPage.clickOnRefundsLink();
    }

    @When("sales manager entering the refunds period and shows refunds")
    public void salesManagerEnteringTheRefundsPeriodAndShowsRefunds() {
        refundsPage=new RefundsPage(driver);
        refundsPage.refundsReport();
    }

    @And("sales manager shoot out refunds report image in <image> file")
    public void salesManagerShootOutRefundsReportImageInImageFile() {
    }

    @Then("sales manager view refunds reports successful")
    public void salesManagerViewRefundsReportsSuccessful() {
    }
}
