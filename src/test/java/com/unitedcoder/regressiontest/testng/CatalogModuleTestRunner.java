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

    @Test(priority = 1,dataProvider = "addRootCategoryInfo", description = "Catalog manager can add root categories.")
    public void addRootCategory(TestDataHolder testDataHolder) {
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.addRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyAddRootCategories(testDataHolder));
    }

    @Test(priority = 2,dataProvider = "subCategoriesInfo",groups = "regression test",description = "Catalog Manager Can Add Sub Categories.")
    public void addSubCategories(TestDataHolder testDataHolder){
        subCategoriesPage.addSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyAddSubCategories(testDataHolder));
    }

    @Test(priority = 3,dataProvider = "subCategoriesInfo",description = "Catalog Manager Can Update Sub Categories.",groups = "regression test",dependsOnMethods ="addSubCategories")
    public void updateExistingSubCategories(TestDataHolder testDataHolder) {
        subCategoriesPage.updateExistingSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyUpdateExistingSubCategories(testDataHolder));
    }


    @DataProvider
    public Object[] subCategoriesInfo(){
        Object[] data=new Object[]
                {new TestDataHolder("Timberland","For every season","shoes")};

        return data;
    }


    @DataProvider
    public Object[] addRootCategoryInfo(){
        Object [] data = new Object[]
                {new TestDataHolder("shoes","IMPORTANT")
        };

        return data;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        closeBrowser();
    }

}



