package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.maganto.backendpages.BackEndLogin;
import com.seleniummaster.maganto.backendpages.catalogpages.*;
import com.seleniummaster.maganto.database.ConnectionManager;
import com.seleniummaster.maganto.database.DataAccess;
import com.seleniummaster.maganto.utility.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.sql.Connection;

@Listeners(TestResultListener.class)
public class CatalogModuleTestRunner extends BasePage {
    final String configFile = "config.properties";
    BackEndLogin login;
    CatalogDashboardPage catalogDashboardPage;
    SubCategoriesPage subCategoriesPage;
    CatalogPage catalogPage;
    AttributesPage attributesPage;
    ProductPage productPage;
    ExcelUtility excelUtility;
    Connection connection;
    DataAccess dataAccess;

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
        excelUtility = new ExcelUtility();
        productPage = new ProductPage(driver);
        connection= ConnectionManager.connectToDatabaseServer();
        dataAccess=new DataAccess();
    }

    @Test(groups = "regression test",dataProvider = "addRootCategoryInfo", description = "Catalog manager can add root categories.", priority = 1)
    public void addRootCategory(TestDataHolder testDataHolder) {
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.addRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyAddRootCategories());
    }

    @Test(groups = "regression test",dataProvider = "addRootCategoryInfo", description = "Catalog Manager can edit root categories ", priority = 2)
    public void editRootCategory(TestDataHolder testDataHolder) {
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.editRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyEditRootCategory());
    }


    @Test(groups = "regression test",dataProvider = "addRootCategoryInfo", description = "Catalog manager can delete root categories.", priority = 6)
    public void deleteExistingRootCategory(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageCategories();
        catalogPage.deleteExistingRootCategory(testDataHolder);
        Assert.assertTrue(catalogPage.verifyDeleteExistingRootCategories());
    }

    @Test(groups = "regression test",description = " manager can view all category under default")
    public void viewAllCategoryUnderTheDefault() {
        login.VerifyLoginSuccessfully();
        catalogDashboardPage.clickOnManageCategories();
        catalogDashboardPage.clickOnExpendLink();
        Assert.assertTrue(catalogDashboardPage.verifyManagerCanViewAllCategoriesUnderDefault());
    }

    @Test(dataProvider = "subCategoriesInfo",
            groups = "regression test", description = "Catalog Manager Can Add Sub Categories.", priority = 3)
    public void addSubCategories(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageCategories();
        subCategoriesPage.addSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyAddSubCategories(testDataHolder));
        Assert.assertTrue(dataAccess.getSubCategories(Integer.parseInt(subCategoriesPage.getSubCategoryID()),connection));
    }

    @Test(groups = "regression test",dataProvider = "subCategoriesInfo",
            description = "Catalog Manager Can Update Sub Categories.", priority = 4)
    public void updateExistingSubCategories(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageCategories();
        subCategoriesPage.updateExistingSubCategories(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyUpdateExistingSubCategories(testDataHolder));
    }

    @Test(groups = "regression test",dataProvider = "subCategoriesInfo", description = "Catalog Manager can delete sub categories", priority = 5)
    public void deleteSubCategories(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageCategories();
        subCategoriesPage.deleteExistingSubCategory(testDataHolder);
        Assert.assertTrue(subCategoriesPage.verifyDeleteExistingSubCategory());
    }

    @Test(groups = "regression test",dataProvider = "AttributeInfo", description = "Category Manager can add a new Attributes under a Catalog. ", priority = 7)
    public void addNewAttributes(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageAttributes();
        attributesPage.addNewAttributes(testDataHolder);
        Assert.assertTrue(attributesPage.verifyNewAttributesAddedSuccessfully());
    }

    @Test(groups = "regression test",dataProvider = "addProductInfo", description = "Catalog Manager can add products ")
    public void addNewProduct(TestDataHolder testDataHolder) {
        catalogDashboardPage.clickOnManageProductsPage();
        productPage.addProduct(testDataHolder);
        Assert.assertTrue(productPage.verifyProductAddedSuccessfully());
    }
    @Test(groups = "regression test",description = "Catalog Manager can edit products ")
    public void editProducts(){
        catalogDashboardPage.clickOnManageProductsPage();
        productPage.editProducts();
        Assert.assertTrue(productPage.verifyProductEditSuccessful());
    }

    @Test(groups = "regression test",dataProvider = "addProductInfo",description ="Category Manager can filter products in the Category Products tab" )
    public void filterProductsInTheCategoryProductsTab(TestDataHolder testDataHolder){
        catalogDashboardPage.clickOnManageCategories();
        productPage.filterProductInTheCategoryProductsTab(testDataHolder);
        Assert.assertTrue(productPage.verifyFilterProductInTheCategoryProductsTab());
    }
    @DataProvider
    public Object[] addProductInfo() {
        Object[] data = new Object[]{
                excelUtility.readCatalogAddProductInfoFromExcel("Test-Data/catalogModuleAddProducts.xlsx", "addProductInfo")};
        return data;
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
    public Object[] newCategoryDescription() {
        Object[] data = new Object[]{
                TestUtility.getFieldFromJson("Test-Data/testDatasSmall.json", "new_category_description")
        };
        return data;
    }

    @DataProvider
    public Object[] AttributeInfo() {
        Object[] data = new Object[]
                {excelUtility.readAttributeInfoFromExcel("Test-Data/attributeData.xlsx", "Attribute_Info")};
        return data;
    }


    @AfterClass()
    public void tearDown() {
        closeBrowser();
        ConnectionManager.closeDatabaseConnection(connection);
    }
}