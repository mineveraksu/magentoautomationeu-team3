package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SubCategoriesPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public SubCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    @FindBy(css = "button[title='Add Subcategory']")
    WebElement addSubcategoryButton;
    @FindBy(css = "input[name='general[name]']")
    WebElement nameField;
    @FindBy(css = "#group_4is_active")
    WebElement isActiveDropDown;
    @FindBy(css = "textarea#group_4description")
    WebElement descriptionField;
    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessages;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategory;
    @FindBy(xpath = "//span[text()='Delete Category']")
    WebElement deleteCategoryButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement deleteSubCategorySuccessfulMessage;
    @FindBy(xpath = "(//div[@class='content-header']//h3[contains(text(),'Timberland')])[1]")
    WebElement subCategoryIDLocation;


    public void addSubCategories(TestDataHolder testDataHolder) {
        WebElement existingRootCategories = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", testDataHolder.getRootCategoryName())));
        testUtility.waitForElementPresent(existingRootCategories);
        existingRootCategories.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(addSubcategoryButton);
        actions.moveToElement(addSubcategoryButton).click().perform();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(testDataHolder.getSubCategoriesName());
        testUtility.waitForElementPresent(isActiveDropDown);
        Select select = new Select(isActiveDropDown);
        select.selectByValue("1");
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(testDataHolder.getSubCategoriesDescription());
        testUtility.waitForElementPresent(saveCategory);
        saveCategory.click();
    }

    public String getSubCategoryID(){
        testUtility.sleep(3);
        testUtility.waitForElementPresent(subCategoryIDLocation);
        String subcategoryID=subCategoryIDLocation.getText().replace("Timberland (ID: ","").replace(")","");
        return subcategoryID;
    }

    public boolean verifyAddSubCategories(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(successMessages);
        if (successMessages.getText().contains("The category has been saved.")) {
            System.out.printf("Catalog Manager Can Add (%s) Sub Categories Test Passed!!!", testDataHolder.getSubCategoriesName());
            return true;
        } else {
            System.out.printf("Catalog Manager Can Add (%s) Sub Categories Test Failed!!!", testDataHolder.getSubCategoriesName());
            return false;
        }
    }

    public void clickOnExistingSubCategories(TestDataHolder testDataHolder) {
        testUtility.sleep(3);
        WebElement existingSubCategories = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", testDataHolder.getSubCategoriesName())));
        testUtility.waitForElementPresent(existingSubCategories);
       existingSubCategories.click();


    }

    public void updateExistingSubCategories(TestDataHolder testDataHolder) {
        clickOnExistingSubCategories(testDataHolder);
        testUtility.sleep(3);
        testUtility.waitForElementPresent(isActiveDropDown);
        actions.moveToElement(isActiveDropDown).click();
        testUtility.sleep(3);
        Select select = new Select(isActiveDropDown);
        select.selectByVisibleText("No");
        testUtility.waitForElementPresent(saveCategory);
        saveCategory.click();

    }

    public boolean verifyUpdateExistingSubCategories(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(successMessages);
        if (successMessages.getText().contains("The category has been saved.")) {
            System.out.printf("Catalog Manager Can Update (%s) Sub Categories Test Passed!!!", testDataHolder.getSubCategoriesName());
            return true;
        } else {
            System.out.printf("Catalog Manager Can Update (%s) Sub Categories Test Failed!!!", testDataHolder.getSubCategoriesName());
            return false;
        }
    }

    public void deleteExistingSubCategory(TestDataHolder testDataHolder) {
        WebElement existingSubCategories = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", testDataHolder.getSubCategoriesName())));
        testUtility.waitForElementPresent(existingSubCategories);
        testUtility.sleep(3);
        existingSubCategories.click();
        testUtility.waitForElementPresent(deleteCategoryButton);
        deleteCategoryButton.click();
        testUtility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyDeleteExistingSubCategory() {
        testUtility.waitForElementPresent(deleteSubCategorySuccessfulMessage);
        if (deleteSubCategorySuccessfulMessage.getText().contains("deleted")) {
            System.out.println("Catalog Manager delete existing Sub Categories Test Passed!!!");
            return true;
        } else {
            System.out.println("Catalog Manager delete existing Sub Categories Test Failed!!!");
            return false;
        }
    }

}





