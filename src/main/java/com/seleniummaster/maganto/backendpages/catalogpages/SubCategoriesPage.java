package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SubCategoriesPage {
    WebDriver driver;
    TestUtility testUtility;

    public SubCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(css = "button[title='Add Subcategory']")
    WebElement addSubcategoryButton;

    @FindBy(css = "input[name='general[name]']")
    WebElement nameField;

    @FindBy(css = "#group_4is_active")
    WebElement isActiveDropDown;

    @FindBy(css ="textarea#group_4description")
    WebElement descriptionField;

    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessages;

    @FindBy(xpath = "button[title='Save Category']")
    WebElement saveCategory;


    public void addSubCategories (TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(addSubcategoryButton);
        addSubcategoryButton.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(testDataHolder.getSubCategoriesName());
       // testUtility.waitForElementPresent(isActiveDropDown);
       // isActiveDropDown.click();
       // Select select = new Select(isActiveDropDown);
        //select.selectByValue("1");
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(testDataHolder.getSubCategoriesDescription());
        testUtility.waitForElementPresent(saveCategory);
        saveCategory.click();
    }

    public boolean verifyAddSubCategories(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(successMessages);
        if (successMessages.getText().contains("The category has been saved.")){
            System.out.printf("Catalog Manager Can Add Sub Categories %s Test Passed !",testDataHolder.getSubCategoriesName());
            return true;
        }else{
            System.out.println("Catalog Manager Can Add Sub Categories Test Failed !");
            return false;
        }
    }

    public void clickOnExistingSubCategories(TestDataHolder testDataHolder){
        WebElement existingSubCategories=driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]",testDataHolder.getSubCategoriesName())));
        testUtility.waitForElementPresent(existingSubCategories);
        existingSubCategories.click();
    }

    public void updateExistingSubCategories(TestDataHolder testDataHolder){
        clickOnExistingSubCategories(testDataHolder);
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(testDataHolder.getSubCategoriesName());
        testUtility.waitForElementPresent(saveCategory);
        saveCategory.click();
    }

    public boolean verifyUpdateExistingSubCategories(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(successMessages);
        if (successMessages.getText().contains("The category has been saved.")){
            System.out.printf("Catalog Manager Can Update Sub Categories %s Test Passed !",testDataHolder.getSubCategoriesName());
            return true;
        }else{
            System.out.println("Catalog Manager Can Update Sub Categories Test Failed !");
            return false;
        }
    }
}




