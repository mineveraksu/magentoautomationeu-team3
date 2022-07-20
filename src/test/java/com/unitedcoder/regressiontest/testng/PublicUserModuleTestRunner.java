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
    ShoppingCartPage shoppingCartPage;
    CheckOutOrderPage checkOutOrderPage;
    AddressBookPage addressBookPage;
    MyWishListPage myWishListPage;

    @BeforeClass
    public void setup(ITestContext context) {
        String url = ApplicationConfig.readFromConfigProperties(configFile, "puburl");
        browserSetUp(url);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        loginPage.login();
        dashboardPage = new MyDashboardPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
        myOrdersPage = new MyOrdersPage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        addressBookPage = new AddressBookPage(driver);
        myWishListPage = new MyWishListPage(driver);
    }

    @Test(groups = "regression test", description = "A user should be able to edit account information")
    public void EditAccountInformation() {
        dashboardPage.verifyLogin();
        dashboardPage.clickOnAccountInformationLink();
        accountInformationPage.editAccountInformation();
        Assert.assertTrue(accountInformationPage.verifyEditAccountInformation());
    }

    @Test(description = "A user should be able to view Account Information")
    public void viewAccountInformation(){
        dashboardPage.clickOnAccountInformationLink();
        accountInformationPage.verifyAccountInformationViewed();
        Assert.assertTrue(accountInformationPage.verifyAccountInformationViewed());
    }

    @Test(groups = "regression test", description = "A User Should be Able to View his/her Orders")
    public void viewOrders() {
        dashboardPage.clickOnMyOrdersLink();
        Assert.assertTrue(myOrdersPage.viewOrders());
    }

    @Test(groups = "regression test", description = "A User Should be Able to add products to shopping cart")
    public void addProductsToCart() {
        dashboardPage.clickOnSaleLink();
        shoppingCartPage.addProductsToCart();
        Assert.assertTrue(shoppingCartPage.verifyProductsAddedToCart());
    }

    @Test(groups = "regression test", description = "A User Should be Able to update products to shopping cart", dependsOnMethods = "addProductsToCart")
    public void updateShoppingCart() {
        shoppingCartPage.updateShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyUpdateShoppingCart());
        shoppingCartPage.clickOnDeleteCartButton();
    }

    @Test(groups = "regression test", description = "user should be able to update and view address book")
    public void updateAndViewAddressBook() {
        dashboardPage.clickOnAddressBookLink();
        addressBookPage.updateAddressBookMethod();
        addressBookPage.clickONSaveAddressButton();
        Assert.assertTrue(dashboardPage.verifyUpdatedAddressBookSuccessful());
        dashboardPage.clickOnAddressBookLink();
        Assert.assertTrue(dashboardPage.verifyViewUpdatedAddressBook());

    }

    @Test(description = "A user should be able to check out the order")
    public void checkoutProduct() {
        CheckOutOrderPage checkOutOrderPage = new CheckOutOrderPage(driver);
        //checkOutOrderPage.clickPlaceOrderButton();
    }

    @Test(groups = "regression test", description = "A user should be able to view his/her downloadable orders")
    public void testMyDownloadableProducts() {
        dashboardPage.clickOnMyDownloadableProductsLink();
        MyDownloadableProductsPage downloadableProductsPage = new MyDownloadableProductsPage(driver);
        Assert.assertTrue(downloadableProductsPage.isDownloadableProductsExist());
    }

    @Test(description = "A user should be able to view my wish list")
    public void verifyMyWishList() {
        dashboardPage.clickOnMyWishListLink();
        myWishListPage.viewMyWshList();
        Assert.assertTrue(myWishListPage.viewMyWshList());
    }

    @AfterMethod
    public void backToDashboardPage() {
        dashboardPage.backToDashboardPage();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

}
