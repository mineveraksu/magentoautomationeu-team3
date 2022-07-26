package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StorePage {
    WebDriver driver;
    TestUtility testUtility;


    @FindBy(xpath = "//td[@class=\"form-buttons\"]/button[2]/span/span/span")
    WebElement createStoreButton;
    @FindBy(id = "group_website_id")
    WebElement websiteDropDown;
    @FindBy(id = "group_name")
    WebElement storeNameField;

    @FindBy(linkText = "Store Name")
    WebElement storeNameLink;
    //@FindBy(id = "group_root_category_id")
   // WebElement rootCategoryDropDown;
  //  @FindBy(id = "group_root_category_id")
//    WebElement rootCategoryDropDown;
//    @FindBy(css = "li.success-msg")
//    WebElement websiteSavedSuccessfulSMS;
//
//    public StorePage(WebDriver driver) {
//        this.driver = driver;
//        testUtility = new TestUtility(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    public void createWebsite(String name,String code) {
//        testUtility.waitForElementPresent(createWebsiteLink);
//        createWebsiteLink.click();
//        testUtility.waitForElementPresent(nameField);
//        nameField.sendKeys(name);
//        testUtility.waitForElementPresent(codeField);
//        codeField.sendKeys(code);
//        testUtility.waitForElementPresent(saveWebsiteButton);
//        saveWebsiteButton.click();
//    }
//
//    public boolean verifyWebsiteCreatedSuccessfully(){
//        testUtility.waitForElementPresent(websiteSavedSuccessfulSMS);
//        if (websiteSavedSuccessfulSMS.getText().contains("saved.")) {
//            System.out.println("Store manager create website test passed!");
//            return true;
//        } else {
//            System.out.println("Store manager create website test failed!");
//            return false;
//        }
//
//    }
    public boolean verifyAllStoresViewed(){
        if (storeNameLink.isDisplayed()){
            System.out.println("Store manager can view all stores.");
            return true;
        }else {
            System.out.println("Store manager can not view all stores.");
            return false;
        }

    }

    @FindBy(id = "group_root_category_id")
    WebElement rootCategoryDropDown;
    @FindBy(xpath = "(//button[@title='Save Store']//span[text()='Save Store'])[1]")
    WebElement saveStoreButton;
    @FindBy(xpath = "(//button[@title='Delete Store']//span[text()='Delete Store'])[1]")
    WebElement deleteStoreButton;
    @FindBy(css = "li.success-msg")
    WebElement successMessage;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateStoreButton() {
        testUtility.waitForElementPresent(createStoreButton);
        createStoreButton.click();
    }
    public void selectWebsiteDropDown(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(websiteDropDown);
        Select select = new Select(websiteDropDown);
        select.selectByVisibleText(testDataHolder.getWebsiteName());
    }

    public void typeStoreName(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(storeNameField);
        storeNameField.sendKeys(testDataHolder.getStoreName());
    }

    public void selectRootCategoryDropDown(int index) {
        testUtility.waitForElementPresent(rootCategoryDropDown);
        Select select = new Select(rootCategoryDropDown);
        select.selectByIndex(index);
    }

    public void clickOnSaveStoreButton() {
        testUtility.waitForElementPresent(saveStoreButton);
        saveStoreButton.click();
    }

    public void clickOnDeleteStoreButton() {
        testUtility.waitForElementPresent(deleteStoreButton);
        deleteStoreButton.click();
    }

    public void clickOnStoreName(TestDataHolder testDataHolder) {
        WebElement storeName = driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", testDataHolder.getStoreName())));
        testUtility.waitForElementPresent(storeName);
        storeName.click();
    }

    public void clickOnTheSecondStoreName(TestDataHolder testDataHolder) {
        WebElement storeName = driver.findElement(By.xpath(String.format("(//a[contains(text(),'%s')])[2]", testDataHolder.getStoreName())));
        testUtility.waitForElementPresent(storeName);
        storeName.click();
    }

    public void createStore(TestDataHolder testDataHolder) {
        clickOnCreateStoreButton();
        selectWebsiteDropDown(testDataHolder);
        typeStoreName(testDataHolder);
        selectRootCategoryDropDown(1);
        clickOnSaveStoreButton();
    }

    public boolean verifyStoreCreatedSuccessfully() {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("saved.")) {
            System.out.println("Store manager create store test passed!");
            return true;
        } else {
            System.out.println("Store manager create store test failed!");
            return false;
        }
    }

    public void editStore(TestDataHolder testDataHolder) {
        clickOnStoreName(testDataHolder);
        selectRootCategoryDropDown(2);
        clickOnSaveStoreButton();
    }

    public boolean verifyStoreEditedSuccessfully() {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("saved.")) {
            System.out.println("Store manager edit store test passed!");
            return true;
        } else {
            System.out.println("Store manager edit store test failed!");
            return false;
        }
    }

    public void deleteStore(TestDataHolder testDataHolder) {
        clickOnTheSecondStoreName(testDataHolder);
        clickOnDeleteStoreButton();
    }

    public boolean verifyStoreDeletedSuccessfully() {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("deleted.")) {
            System.out.println("Store manager delete store test passed!");
            return true;
        } else {
            System.out.println("Store manager delete store test failed!");
            return false;
        }


    }
}

