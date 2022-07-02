package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.frontendpages.*;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestResultListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestResultListener.class)
public class PublicUserModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    LoginPage loginPage;
    MyDashboardPage dashboardPage;
    AccountInformationPage accountInformationPage;
    MyOrdersPage myOrdersPage;
    SalePage salePage;
    AddressBookPage addressBookPage;

    @BeforeClass
    public void setup(ITestContext context){
        String url=ApplicationConfig.readFromConfigProperties(configFile,"puburl");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        loginPage=new LoginPage(driver);
        loginPage.login();
        dashboardPage=new MyDashboardPage(driver);
        accountInformationPage=new AccountInformationPage(driver);
        myOrdersPage=new MyOrdersPage(driver);
        salePage=new SalePage(driver);
        addressBookPage=new AddressBookPage(driver);

    }

    @Test(priority = 1, description ="EditAccountInformation")
    public void EditAccountInformation(){
        dashboardPage.verifyLogin();
        dashboardPage.clickOnAccountInformationLink();
        accountInformationPage.editAccountInformation();
        Assert.assertTrue(accountInformationPage.verifyEditAccountInformation());
    }


    @Test(priority = 2, description = "A User Should be Able to View his/her Orders")
    public void viewOrders(){
        dashboardPage.clickOnMyOrdersLink();
        Assert.assertTrue(myOrdersPage.viewOrders());
    }

    @Test(priority = 3, description = "A User Should be Able to add products to shopping cart")
    public void addProductsToCart(){
        dashboardPage.clickOnSaleLink();
        salePage.addProductsToCart();
        Assert.assertTrue(salePage.verifyProductsAddedToCart());
    }
    @Test(priority = 4,description = "A User Should be Able to add products to shopping cart")
    public void updateShoppingCart(){
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
        shoppingCartPage.updateShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyUpdateShoppingCart());

    }
    @Test(description = "user should be able to update and view address book")
    public void updateAndViewAddressBook(){
        dashboardPage.verifyLogin();
        dashboardPage.clickOnAddressBookLink();
        addressBookPage.clickONEditNewAddressButton();
        addressBookPage.enterFirstName();
        addressBookPage.enterLastName();
        addressBookPage.enterPhoneNumber();
        addressBookPage.enterStreetAddress();
        addressBookPage.enterCity();
        addressBookPage.enterZipCode();
        addressBookPage.selectCountry();
        addressBookPage.clickONSaveAddressButton();
        Assert.assertTrue(dashboardPage.verifyUpdatedAddressBookSuccessful());
        dashboardPage.clickOnAddressBookLink();
        Assert.assertTrue(dashboardPage.verifyViewUpdatedAddressBook());

    }

    @Test
    public void testMyDownloadableProducts() {
        dashboardPage.clickOnMyDownloadableProductsLink();
        MyDownloadableProductsPage downloadableProductsPage = new MyDownloadableProductsPage(driver);
        Assert.assertTrue(downloadableProductsPage.isDownloadableProductsExist());
    }

    @AfterClass
    public void tearDown(){

        closeBrowser();
    }


}
