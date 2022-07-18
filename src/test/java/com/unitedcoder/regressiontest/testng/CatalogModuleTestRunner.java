package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.catalogpages.AttributesPage;
import com.seleniummaster.maganto.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.maganto.backendpages.catalogpages.CatalogPage;
import com.seleniummaster.maganto.backendpages.catalogpages.SubCategoriesPage;
import com.seleniummaster.maganto.utility.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestResultListener.class)
public class CatalogModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    BackEndLogin login;
    CatalogDashboardPage catalogDashboardPage;
    SubCategoriesPage subCategoriesPage;
    CatalogPage catalogPage;
    AttributesPage attributesPage;
    ExcelUtility excelUtility;

    @BeforeClass
    public void setup(ITestContext context) {
        String url = ApplicationConfig.readFromConfigProperties(configFile, "url");
        browserSetUp(url);
        context.setAttribute("driver", driver);
        login = new BackEndLogin(driver);
        login.catalogPageLogin();
        catalogDashboardPage = new CatalogDashboardPage(driver);
        subCategoriesPage = new SubCategoriesPage(driver);
        catalogPage = new CatalogPage(driver);
        attributesPage = new AttributesPage(driver);
        excelUtility=new ExcelUtility();
    }

    @Test(dataProvider = "addRootCategoryInfo", description = "Catalog manager can add root categories.")
    public void addRootCategory(TestDataHolder testDataHolder) {
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.addRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyAddRootCategories(testDataHolder));
    }

    @Test(dataProvider = "subCategoriesInfo", dependsOnMethods = "addRootCategory",
            groups = "regression test", description = "Catalog Manager Can Add Sub Categories.")
    public void addSubCategories(TestDataHolder testDataHolder) {
        subCategoriesPage.addSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyAddSubCategories(testDataHolder));
    }

    @Test(dataProvider = "subCategoriesInfo", dependsOnMethods = "addSubCategories",
            description = "Catalog Manager Can Update Sub Categories.", groups = "regression test")
    public void updateExistingSubCategories(TestDataHolder testDataHolder) {
        subCategoriesPage.updateExistingSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyUpdateExistingSubCategories(testDataHolder));
    }

    @Test(dataProvider = "AttributeInfo", description = "Category Manager can add a new Attributes under a Catalog. ")
    public void addNewAttributes(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageAttributes();
        attributesPage.addNewAttributes(testDataHolder);
        Assert.assertTrue(attributesPage.verifyNewAttributesAddedSuccessfully());
    }

    @DataProvider
    public Object[] subCategoriesInfo() {
        Object[] data = new Object[]
                {new TestDataHolder("Timberland", "For every season", "shoes")};
        return data;
    }

    @DataProvider
    public Object[] addRootCategoryInfo() {
        Object[] data = new Object[]
                {new TestDataHolder("shoes", "IMPORTANT")
                };
        return data;
    }

    @DataProvider
    public Object[] AttributeInfo() {
        Object[] data = new Object[]
                {excelUtility.readAttributeInfoFromExcel("Test-Data/attributeData.xlsx", "Attribute_Info")};
        return data;
    }

//    @AfterClass()
//    public void tearDown() {
//        closeBrowser();
//    }
}



