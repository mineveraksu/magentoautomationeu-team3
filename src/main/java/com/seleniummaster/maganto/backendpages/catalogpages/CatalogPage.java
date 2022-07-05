package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[text()='Add Root Category']")
    WebElement addRootCategoryLink;
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
        testUtility.waitForElementPresent(metaKeyWords);
        metaKeyWords.sendKeys(testDataHolder.getMetaKeyWords());
        testUtility.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }

    public Boolean verifyAddRootCategories(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("The category has been saved.")) {
            System.out.println("Catalog manager able to add root categories Test Passed!! ");
            return true;
        } else {
            System.out.println("Catalog manager able to add root categories Test Failed!! ");
            return false;
        }
    }
}