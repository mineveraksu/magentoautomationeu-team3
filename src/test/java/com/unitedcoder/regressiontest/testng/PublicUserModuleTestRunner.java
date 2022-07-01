package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.frontendpages.AccountInformationPage;
import com.seleniummaster.maganto.frontendpages.LoginPage;
import com.seleniummaster.maganto.frontendpages.MyDashboardPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestResultListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestResultListener.class)
public class PublicUserModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    LoginPage loginPage;
    MyDashboardPage dashboardPage;
    AccountInformationPage accountInformationPage;

    @BeforeClass
    public void setup(ITestContext context){
        String url=ApplicationConfig.readFromConfigProperties(configFile,"puburl");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        loginPage=new LoginPage(driver);
        loginPage.login();
        dashboardPage=new MyDashboardPage(driver);
        accountInformationPage=new AccountInformationPage(driver);
    }

    @Test(description ="EditAccountInformation")
    public void EditAccountInformation(){
        dashboardPage.verifyLogin();
        dashboardPage.clickOnAccountInformationLink();
        accountInformationPage.editAccountInformation();
        Assert.assertTrue(accountInformationPage.verifyEditAccountInformation());
    }


}
