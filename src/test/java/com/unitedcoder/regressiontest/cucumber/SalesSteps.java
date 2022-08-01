package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.salespages.*;
import com.seleniummaster.maganto.utility.*;
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
    RefundsPage refundsPage;
    OrdersPage ordersPage;
    TestDataHolder testDataHolder;
    ExcelUtility excelUtility;
    CreditMemoPage creditMemoPage;
    AddCreditMemoPage addCreditMemoPage;


    @Before("@SalesModuleTest")
    public void setup() {
        browserSetUp(url);
        login = new BackEndLogin(driver);
        login.salesPageLogin();
        salesDashboardPage = new SalesDashboardPage(driver);
        excelUtility = new ExcelUtility();
        testDataHolder = excelUtility.readSalesInfoFromExcel("Test-Data/SalesModule.xlsx", "Refunds_Info");
    }

    @Given("Sales manager is on the dashboard page and clicks on Orders link")
    public void salesManagerIsOnTheDashboardPageAndClicksOnOrdersLink() {
        salesDashboardPage.clickOnOrdersLink();
        ordersPage=new OrdersPage(driver);
    }


    @When("sales manager selects a {string} in order to add a {string} to order")
    public void salesManagerSelectsAInOrderToAddAToOrder(String arg0, String arg1) {
        ordersPage.createANewOrder(arg0,arg1);
    }

    @Then("Sales Manager created a new order successfully")
    public void salesManagerCreatedANewOrderSuccessfully() {
        Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
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

    //Add Tax Rules
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

    @Then("a new Tax Rule created successfully")
    public void aNewTaxRuleCreatedSuccessfully() {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.verifyAddNewTaxRuleRuleSuccessfully();
        Assert.assertTrue(invoicesPage.verifyAddNewTaxRuleRuleSuccessfully());

    }

    //update Tax Rules
    @When("Sales Manager click Add New Tax Rule icon and fill out {string}information and edit tax rules")
    public void salesManagerClickAddNewTaxRuleIconAndFillOutInformationAndEditTaxRules(String arg0) {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.updateNewTaxRule(arg0);
    }

    @Then("the new Tax Rule update successfully")
    public void theNewTaxRuleUpdateSuccessfully() {

        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.verifyUpdateNewTaxRuleRuleSuccessfully();
        Assert.assertTrue(invoicesPage.verifyUpdateNewTaxRuleRuleSuccessfully());

    }

//    @Given("sales manager click on refunds link")
//    public void salesManagerClickOnRefundsLink() {
//        salesDashboardPage.clickOnRefundsLink();
//    }
//
//    @When("sales manager entering the refunds period and shows refunds")
//    public void salesManagerEnteringTheRefundsPeriodAndShowsRefunds() {
//        refundsPage = new RefundsPage(driver);
//        refundsPage.refundsReport(testDataHolder);
//    }
//
//    @Then("sales manager view refunds reports successful")
//    public void salesManagerViewRefundsReportsSuccessful() {
//        refundsPage = new RefundsPage(driver);
//        Assert.assertTrue(refundsPage.verifyRefundsReportSuccessfulShow());
//    }
//    // view credit memo
//    @Given("sales manager is on the dashboard and click credit memo link")
//    public void salesManagerIsOnTheDashboardAndClickCreditMemoLink() {
//        salesDashboardPage=new SalesDashboardPage(driver);
//        salesDashboardPage.clickOnCreditMemoLink();
//    }
//
//    @When("manager click the view button and view credit memo information")
//    public void managerClickTheViewButtonAndViewCreditMemoInformation() {
//        creditMemoPage=new CreditMemoPage(driver);
//        creditMemoPage.viewCreditMemoMethod(testDataHolder);
//
////    }
////    @And("Sales manager can view shopping cart")
////    public void salesManagerCanViewShoppingCart(){
////        Assert.assertTrue(manageCustomersPage.verifyShoppingCartView());
////    }
//
//    @Then("verify view credit memo")
//    public void verifyViewCreditMemo() {
//        creditMemoPage=new CreditMemoPage(driver);
//        org.testng.Assert.assertTrue(creditMemoPage.verifyViewCreditMemo());
//
//    }
//    //Add creditMemo
//    @When("Sales manager click pending and invoice button to create credit memo")
//    public void salesManagerClickPendingAndInvoiceButtonToCreateCreditMemo() {
//        ordersPage=new OrdersPage(driver);
//        ordersPage.selectStatusOfOrders();
//        ordersPage.clickOnPendingLink(testDataHolder);
//        addCreditMemoPage=new AddCreditMemoPage(driver);
//        addCreditMemoPage.addCreditMemo();
//
//    }
//    @Then("Verify added credit memo")
//    public void verifyAddedCreditMemo() {
//        addCreditMemoPage=new AddCreditMemoPage(driver);
//        org.testng.Assert.assertTrue(addCreditMemoPage.verifyAddedCreditMemo());
//    }
//
//
//    @After("@SalesModuleTest")
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            ScreenShotUtility screenShotUtility = new ScreenShotUtility();
//            screenShotUtility.takeScreenshot("image", "failedTest", driver);
//        }
//        closeBrowser();
//    }



}

