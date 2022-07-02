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

    @Test
    public void testMyDownloadableProducts() {

        MyDashboardPage dashboardPage = new MyDashboardPage(driver);
        dashboardPage.clickOnMyDownloadableProductsLink();

        MyDownloadableProductsPage downloadableProductsPage = new MyDownloadableProductsPage(driver);

        Assert.assertTrue(downloadableProductsPage.isDownloadableProductsExist());

    }
    @Test
            (description = "A user should be able to check out the order")
    public void checkoutProduct() {
        checkOutPage = new CheckOutPage();
        checkOutPage.checkOut();


    @AfterClass
    public void tearDown(){

        closeBrowser();
    }


}
