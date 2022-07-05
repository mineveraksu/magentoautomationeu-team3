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

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(xpath = "//span[text()='Add Root Category']")
    WebElement addRootCategoryLink;
    @FindBy (css = "input[name='general[name]']")
    WebElement categoryNameField;
    @FindBy(css="#group_4is_active")
    WebElement isActive;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategoryButton;
    @FindBy(css = ("textarea#group_4description"))
    WebElement descriptionField;
    @FindBy (xpath = "//span[text()='The category has been saved.']")
    WebElement successMessage;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickOnManageCategoriesLink() {
        testUtility.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
    }

    public void clickOnCategoryNameField(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(categoryNameField);
        categoryNameField.click();
        categoryNameField.sendKeys(testDataHolder.getRootCategoryName());
    }

    public void clickOnIsActive() {
        testUtility.waitForElementPresent(isActive);
        isActive.click();
    }

    public void selectIsActiveDropDown () {
        Select select = new Select(isActive);
        select.selectByValue("1");
    }

    public void clickOnDescriptionFiled(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.click();
        descriptionField.sendKeys(testDataHolder.getGetRootCategoryDescription());
    }
    public void clickOnSaveButton(){
        testUtility.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }

}
