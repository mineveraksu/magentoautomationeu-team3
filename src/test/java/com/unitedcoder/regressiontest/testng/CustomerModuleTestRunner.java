package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.customerpages.*;
import com.seleniummaster.maganto.database.ConnectionManager;
import com.seleniummaster.maganto.database.DataAccess;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestDataHolder;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.sql.Connection;


public class CustomerModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    BackEndLogin login;
    CustomerDashboardPage customerDashboardPage;
    CustomerGroupsPage customerGroupsPage;
    FilterCustomerPage filterCustomerPage;
    CustomerPage customerPage;
    AddAddressesPage addAddressesPage;
    Connection connection;
    DataAccess dataAccess;

    @BeforeClass
    public void setup(ITestContext context) {
        String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
        browserSetUp(url);
        context.setAttribute("driver", driver);
        login = new BackEndLogin(driver);
        login.customerPageLogin();
        customerDashboardPage = new CustomerDashboardPage(driver);
        customerGroupsPage = new CustomerGroupsPage(driver);
        filterCustomerPage = new FilterCustomerPage(driver);
        customerPage = new CustomerPage(driver);
        addAddressesPage = new AddAddressesPage(driver);
        connection= ConnectionManager.connectToDatabaseServer();
        dataAccess=new DataAccess();
    }

    @Test(groups = "regression test", description = "Customer Manager can add a new customer ")
    public void addNewCustomer() {
        login.VerifyLoginSuccessfully();
        customerDashboardPage.clickOnManageCustomers();
        customerPage.addNewCustomer();
        Assert.assertTrue(customerPage.verifyNewCustomerAdded());
       // Assert.assertTrue(dataAccess.getNewlyAddedCustomer(customerPage.email(), connection));
    }
    @Test(dataProvider = "customerGroupInfo", groups = "regression test", description = "Customer Manager can add new customer groups.")
    public void addNewCustomerGroups(TestDataHolder testDataHolder) {
        customerDashboardPage.clickOnCustomerGroups();
        customerGroupsPage.addNewCustomerGroups(testDataHolder);
        //Assert.assertTrue(customerGroupsPage.verifyAddNewCustomerGroups());
        Assert.assertTrue(dataAccess.getCustomerGroup(testDataHolder.getCustomerGroupName(), connection));
    }

    @Test(dataProvider = "customerGroupInfo", groups = "regression test", description = "Customer Manager can  update existing customer groups.", dependsOnMethods = "addNewCustomerGroups")
    public void updateExistingCustomerGroups(TestDataHolder testDataHolder) {
        customerDashboardPage.clickOnCustomerGroups();
        customerGroupsPage.updateExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyUpdateExistingCustomerGroups());
    }

    @Test(groups = "regression test",description = "assign a customer to group",
            dataProvider = "customerGroupInfo",dependsOnMethods = {"addNewCustomer","updateExistingCustomerGroups"})
    public void assignACustomerToGroup(TestDataHolder testDataHolder) {
        customerDashboardPage.clickOnManageCustomers();
        customerPage.selectAddedCustomer();
        customerPage.selectActionsList();
        customerPage.selectGroup(testDataHolder);
        customerPage.clickOnSubmitButton();
        customerPage.verificationACustomerAssignToGroup();
    }

    @Test(groups = "regression test",description = "exportCustomer")
    public void exportCustomer() {
        String fileType = "Excel XML";
        customerDashboardPage.clickOnManageCustomers();
        customerPage.selectFileType(fileType);
        customerPage.clickOnExportButton();
        customerPage.isCustomerFileExported();
    }

    @Test(dataProvider = "customerGroupInfo", groups = "regression test", description = "Customer Manager can delete existing customer groups", dependsOnMethods = "deleteExistingCustomer")
    public void deleteExistingCustomerGroups(TestDataHolder testDataHolder) {
        customerDashboardPage.clickOnCustomerGroups();
        customerGroupsPage.deleteExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyDeleteExistingCustomerGroups());
    }

    @Test(groups = "regression test", description = "Customer Manager Can Filter Customers by Email",dependsOnMethods = "deleteExistingCustomerGroups")
    public void filterCustomerByEmail() {
        customerDashboardPage.clickOnManageCustomers();
        filterCustomerPage.clickEmailField();
        Assert.assertTrue(filterCustomerPage.verifyFilterCustomerByEmail());
    }

    @DataProvider
    public Object[] customerGroupInfo() {
        Object[] data = new Object[]{new TestDataHolder("Europe Customer")};
        return data;
    }



    @Test(groups = "regression test", description = "Customer Manager can add a new address for a customer",dependsOnMethods = "filterCustomerByCountry")
    public void addNewAddress() {
        customerDashboardPage.navigateToAddressesLink();
        addAddressesPage.addNewAddress();
        Assert.assertTrue(addAddressesPage.verifyNewAddressAdded());
        addAddressesPage.deleteAddedAddress();
    }

    @Test(groups = "regression test",description = "Customer Manager can update an existing customer ",dependsOnMethods = "assignACustomerToGroup")
    public void updateCustomer() {
        customerPage.updateCustomer();
        Assert.assertTrue(customerPage.verifyUpdateCustomer());
    }

    @Test(groups = "regression test", description = "Customer Manager can filter customers by Country, State, and website. ",dependsOnMethods = "filterCustomerByEmail")
    public void filterCustomerByCountry() {
        customerDashboardPage.clickOnManageCustomers();
        filterCustomerPage.filterByCountry();
        Assert.assertTrue(filterCustomerPage.verifyFilteredByCountry());
        filterCustomerPage.clickOnResetFilter();
        filterCustomerPage.filterByWebsite();
        Assert.assertTrue(filterCustomerPage.verifyFilteredByWebsite());
        filterCustomerPage.clickOnResetFilter();
        filterCustomerPage.filterByState();
        Assert.assertTrue(filterCustomerPage.verifyFilteredByState());
        filterCustomerPage.clickOnResetFilter();
    }

    @Test(groups = "regression test",description = "Customer Manager can filter customers by Group")
    public void filterCustomerByGroup(){
        customerDashboardPage.clickOnManageCustomers();
        filterCustomerPage.filterByGroup();
        Assert.assertTrue(filterCustomerPage.verifyFilterByGroup());
    }

    @Test(groups = "regression test",description = "Customer Manager can delete an existing customer",dependsOnMethods = "updateCustomer")
    public void deleteExistingCustomer() {
        customerDashboardPage.clickOnManageCustomers();
        customerPage.deleteCustomer();
        Assert.assertTrue(customerPage.verifyDeleteCustomer());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
        ConnectionManager.closeDatabaseConnection(connection);
    }

}
