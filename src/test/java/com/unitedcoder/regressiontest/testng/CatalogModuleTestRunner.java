package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.maganto.backendpages.catalogpages.CatalogPage;
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
    CatalogPage catalogPage;

    @BeforeClass
    public void setup(ITestContext context){
        String url= ApplicationConfig.readFromConfigProperties(configFile,"url");
        browserSetUp(url);
        context.setAttribute("driver",driver);
        login=new BackEndLogin(driver);
        login.catalogPageLogin();
        catalogDashboardPage=new CatalogDashboardPage(driver);
        subCategoriesPage=new SubCategoriesPage(driver);
        catalogPage = new CatalogPage(driver);
    }

    @Test(dataProvider = "subCategoriesInfo",description = "Catalog Manager Can Add Sub Categories.",enabled = false)
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

    @Test(dataProvider = "addRootCategoryInfo", description = "Catalog manager can add root categories.")
    public void addRootCategory(TestDataHolder testDataHolder){
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.addRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyAddRootCategories(testDataHolder));
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
    @DataProvider
    public Object[] addRootCategoryInfo(){
        Object [] data = new Object[]
                {new TestDataHolder("shoes","IMPORTANT","SHIRALI")
        };

        return data;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        closeBrowser();
    }

}







