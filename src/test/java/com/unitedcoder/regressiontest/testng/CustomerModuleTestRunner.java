package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.customerpages.CustomerDashboardPage;
import com.seleniummaster.maganto.backendpages.customerpages.CustomerGroupsPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestDataHolder;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    BackEndLogin login;
    CustomerDashboardPage customerDashboardPage;
    CustomerGroupsPage customerGroupsPage;

    @BeforeClass
    public void setup(ITestContext context){
        String url= ApplicationConfig.readFromConfigProperties(configFile,"url");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        login=new BackEndLogin(driver);
        login.customerPageLogin();
        customerDashboardPage=new CustomerDashboardPage(driver);
        customerGroupsPage=new CustomerGroupsPage(driver);
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
        customerGroupsPage.updateExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyUpdateExistingCustomerGroups());
    }

    @Test(dataProvider = "customerGroupInfo",groups = "regression test",description = "Customer Manager can delete existing customer groups",dependsOnMethods = "updateExistingCustomerGroups")
    public void deleteExistingCustomerGroups(TestDataHolder testDataHolder){
        customerGroupsPage.deleteExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyDeleteExistingCustomerGroups());
    }

    @DataProvider
    public Object[] customerGroupInfo(){
        Object[] data=new Object[]{new TestDataHolder("Europe Customer")};
        return data;
    }






    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
