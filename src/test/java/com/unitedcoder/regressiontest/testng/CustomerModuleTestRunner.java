package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.customerpages.*;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestDataHolder;

import com.seleniummaster.maganto.utility.TestUtility;
import org.apache.tools.ant.taskdefs.Sleep;
import io.cucumber.java.bs.A;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class CustomerModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    BackEndLogin login;
    CustomerDashboardPage customerDashboardPage;
    CustomerGroupsPage customerGroupsPage;
    FilterCustomerPage filterCustomerPage;
    CustomerPage customerPage;
    TestUtility testUtility;



    AddAddressesPage addAddressesPage;


    @BeforeClass
    public void setup(ITestContext context){
        String url= ApplicationConfig.readFromConfigProperties(configFile,"url");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        login=new BackEndLogin(driver);
        login.customerPageLogin();
        customerDashboardPage=new CustomerDashboardPage(driver);
        customerGroupsPage=new CustomerGroupsPage(driver);
        filterCustomerPage=new FilterCustomerPage(driver);
        customerPage=new CustomerPage(driver);
        addAddressesPage=new AddAddressesPage(driver);

    }

    @Test(groups = "regression test", description = "Customer Manager can add a new customer ")
    public void addNewCustomer(){
        customerPage.addNewCustomer();
        Assert.assertTrue(customerPage.verifyNewCustomerAdded());
    }

    @Test(dataProvider = "customerGroupInfo",groups = "regression test",description = "Customer Manager can add new customer groups.")
    public void addNewCustomerGroups(TestDataHolder testDataHolder){
        login.VerifyLoginSuccessfully();
        customerDashboardPage.clickOnCustomerGroups();
        customerGroupsPage.addNewCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyAddNewCustomerGroups());
    }

    @Test(dataProvider = "customerGroupInfo",groups = "regression test",description = "Customer Manager can  update existing customer groups.",dependsOnMethods = "addNewCustomerGroups")
    public void updateExistingCustomerGroups(TestDataHolder testDataHolder){
        customerDashboardPage.clickOnCustomerGroups();
        customerGroupsPage.updateExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyUpdateExistingCustomerGroups());
    }
    @Test(description = "assign a customer to group",
            dataProvider = "customerGroupInfo",dependsOnMethods = {"addNewCustomer"})
    public void assignACustomerToGroup(TestDataHolder testDataHolder){
        customerPage.selectAddedCustomer();
        customerPage.selectActionsList();
        customerPage.selectGroup(testDataHolder);
        customerPage.clickOnSubmitButton();
        customerPage.verificationACustomerAssignToGroup();
    }

    @Test(description = "exportCustomer")
    public void exportCustomer(){
        String fileType="Excel XML";
        customerPage.selectFileType(fileType);
        customerPage.clickOnExportButton();
        customerPage.isCustomerFileExported();
    }

    @Test(dataProvider = "customerGroupInfo",groups = "regression test",description = "Customer Manager can delete existing customer groups",dependsOnMethods = "updateExistingCustomerGroups")
    public void deleteExistingCustomerGroups(TestDataHolder testDataHolder){
        customerGroupsPage.deleteExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyDeleteExistingCustomerGroups());
    }

    @Test(dataProvider = "filterCustomerInfo",groups = "regression test",description = "Customer Manager Can Filter Customers by Email")
    public void filterCustomerByEmail(String email){
        customerDashboardPage.clickOnManageCustomers();
        filterCustomerPage.clickEmailField(email);
        Assert.assertTrue(filterCustomerPage.verifyFilterCustomerByEmail());
    }

    @Test(groups = "regression test",description = "Customer Manager can filter customers by Country, State, and website. ")
    public void filterCustomerByCountry(){
        TestUtility testUtility=new TestUtility(driver);
        customerDashboardPage.clickOnManageCustomers();
        testUtility.sleep(2);
        filterCustomerPage.filterByCountry();
        filterCustomerPage.verifyFilteredByCountry();
        testUtility.sleep(2);
        filterCustomerPage.clickOnResetFilter();
        System.out.println("ready to search other elements1");

       //filterCustomerPage.filterByState();
        //filterCustomerPage.clickOnResetFilter();
        filterCustomerPage.filterByWebsite();
        filterCustomerPage.verifyFilteredByWebsite();
    }

    @DataProvider
    public Object[] customerGroupInfo(){
        Object[] data=new Object[]{new TestDataHolder("Europe Customer")};
        return data;
    }
    @DataProvider
    public Object[][]filterCustomerInfo() {
        Object[][] data = new Object[][]{
                {"gunes8811@hotmail.com"}
        };

        return data;
    }


    @Test(groups = "regression test",description = "Customer Manager can add a new address for a customer")//dataProvider = "customerGroupInfo",,dependsOnMethods = "addNewCustomer"
    public void addNewAddress(){
        customerDashboardPage.navigateToAddressesLink();
        addAddressesPage.addNewAddress();
        Assert.assertTrue(addAddressesPage.verifyNewAddressAdded());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
