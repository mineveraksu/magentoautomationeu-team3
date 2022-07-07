package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttributesPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//div[@id='page:main-container']//span[text()='Add New Attribute']")
    WebElement addNewAttributeButton;
    @FindBy(id = "attribute_code")
    WebElement attributeCodeField;
    @FindBy(xpath = "//a[@id='product_attribute_tabs_labels']/span")
    WebElement manageLabelOptionsLink;
    @FindBy(name = "frontend_label[0]")
    WebElement adminField;
    @FindBy(xpath = "//div[@id='page:main-container']//span[text()='Save Attribute']")
    WebElement saveAttributeButton;
    @FindBy(css = ".success-msg ul li span")
    WebElement attributeSavedSuccessMessage;

    public AttributesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void clickOnAddNewAttributeButton(){
        testUtility.waitForElementPresent(addNewAttributeButton);
        addNewAttributeButton.click();
    }

    public void fillOutAttributeProperties(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(attributeCodeField);
        attributeCodeField.sendKeys(testDataHolder.getattributeCode()+System.currentTimeMillis());
    }

    public void clickOnManageLabelOptionsLink(){
        testUtility.waitForElementPresent(manageLabelOptionsLink);
        manageLabelOptionsLink.click();
    }

    public void fillOutAdminField(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(adminField);
        adminField.sendKeys(testDataHolder.getadminName());
    }

    public void clickOnSaveAttributeButton(){
        testUtility.waitForElementPresent(saveAttributeButton);
        saveAttributeButton.click();
    }

    public void addNewAttributes(TestDataHolder testDataHolder){
       clickOnAddNewAttributeButton();
       fillOutAttributeProperties(testDataHolder);
       clickOnManageLabelOptionsLink();
       fillOutAdminField(testDataHolder);
       clickOnSaveAttributeButton();
    }

    public boolean verifyNewAttributesAddedSuccessfully(){
        testUtility.waitForElementPresent(attributeSavedSuccessMessage);
        if(attributeSavedSuccessMessage.getText().contains("The product attribute has been saved.")){
            System.out.println("Category Manager Add new Attribute Test Passed. ");
            return true;
        }else{
            System.out.println("Category Manager Add new Attribute Test Failed. ");
            return false;
        }
    }
}
