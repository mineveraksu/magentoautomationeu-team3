package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = "input[name='general[name]']")
    WebElement categoryNameField;
    @FindBy(id = "group_4is_active")
    WebElement isActive;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategoryButton;
    @FindBy(css = ("textarea#group_4description"))
    WebElement descriptionField;
    @FindBy(name = "general[meta_keywords]")
    WebElement metaKeyWords;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement successMessage;
    @FindBy(xpath = "//span[text()='Delete Category']")
    WebElement deleteCategoryButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement deleteRootCategorySuccessfulMessage;
    @FindBy(linkText = "Expand All")
    WebElement expandAllLink;


    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void addRootCategory(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(categoryNameField);
        testUtility.sleep(3);
        categoryNameField.sendKeys(testDataHolder.getRootCategoryName());
        testUtility.waitForElementPresent(isActive);
        Select select = new Select(isActive);
        select.selectByValue("1");
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(testDataHolder.getRootCategoryDescription());
        testUtility.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }

    public void editRootCategory(TestDataHolder testDataHolder) {
        expandAllLink.click();
        WebElement existingRootCategories = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", testDataHolder.getRootCategoryName())));
        testUtility.waitForElementPresent(existingRootCategories);
        testUtility.sleep(3);
        existingRootCategories.click();
        testUtility.sleep(3);
        descriptionField.clear();
        descriptionField.sendKeys(TestUtility.getFieldFromJson("Test-Data/testDatasSmall.json", "new_category_description"));
        saveCategoryButton.click();
    }

    public void deleteExistingRootCategory(TestDataHolder testDataHolder) {
        WebElement existingRootCategories = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", testDataHolder.getRootCategoryName())));
        testUtility.waitForElementPresent(existingRootCategories);
        testUtility.sleep(3);
        existingRootCategories.click();
        testUtility.waitForElementPresent(deleteCategoryButton);
        deleteCategoryButton.click();
        testUtility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public boolean verifyAddRootCategories() {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("The category has been saved.")) {
            System.out.println("Catalog manager able to add root categories Test Passed!! ");
            return true;
        } else {
            System.out.println("Catalog manager able to add root categories Test Failed!! ");
            return false;
        }
    }



    public boolean verifyEditRootCategory() {
        if (descriptionField.getText().contains(TestUtility.getFieldFromJson("Test-Data/testDatasSmall.json", "new_category_description"))){
            System.out.println("Catalog Manager can edit root categories test Passed!");
            return true;
        } else {
            System.out.println("Catalog Manager can edit root categories test Failed!");
            return false;
        }
    }

    public boolean verifyDeleteExistingRootCategories() {
        testUtility.waitForElementPresent(deleteRootCategorySuccessfulMessage);
        if (deleteRootCategorySuccessfulMessage.getText().contains("deleted")) {
            System.out.println("Catalog Manager delete existing Root Categories Test Passed!!!");
            return true;
        } else {
            System.out.println("Catalog Manager delete existing Root Categories Test Failed!!!");
            return false;
        }
    }
}
