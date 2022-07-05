package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.maganto.backendpages.catalogpages.SubCategoriesPage;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.BasePage;
import com.seleniummaster.maganto.utility.TestDataHolder;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class CatalogModuleTestRunner extends BasePage {
    final String configFile="config.properties";
    BackEndLogin login;
    CatalogDashboardPage catalogDashboardPage;
    SubCategoriesPage subCategoriesPage;

    @BeforeClass
    public void setup(ITestContext context){
        String url= ApplicationConfig.readFromConfigProperties(configFile,"url");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        login=new BackEndLogin(driver);
        login.catalogPageLogin();
        catalogDashboardPage=new CatalogDashboardPage(driver);
        subCategoriesPage=new SubCategoriesPage(driver);
    }

    @Test(dataProvider = "subCategoriesInfo",description = "Catalog Manager Can Add Sub Categories.")
    public void addSubCategories(TestDataHolder testDataHolder){
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        subCategoriesPage.addSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyAddSubCategories(testDataHolder));
    }

    @Test(dataProvider = "updateSubCategoriesInfo",description = "Catalog Manager Can Update Sub Categories.",enabled = false
    )
    public void updateExistingSubCategories(TestDataHolder testDataHolder){
        subCategoriesPage.updateExistingSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyUpdateExistingSubCategories(testDataHolder));
    }

    @DataProvider
    public Object[] subCategoriesInfo(){
        Object[] data=new Object[]
                {new TestDataHolder("Clothes","Clothes for every season")};

        return data;
    }

    @DataProvider
    public Object[] updateSubCategoriesInfo(){
        Object[][] data= new Object[][]{
                {"Clothes for men"}
        };
        return data;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        closeBrowser();
    }

}







