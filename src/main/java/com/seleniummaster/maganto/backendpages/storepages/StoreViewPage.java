package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreViewPage {

        WebDriver driver;
        TestUtility testUtility;
        @FindBy(xpath = "//td[@class=\"form-buttons\"]/button[3]/span/span/span")
        WebElement createStoreViewLink;
        @FindBy(css = "#store_group_id")
        WebElement storeDropDown;
        @FindBy(css = "#store_name")
        WebElement storeNameField;
        @FindBy(css = "#store_code")
        WebElement storeCodeField;
        @FindBy(xpath = "(//span[text()=\"Save Store View\"])[1]")
        WebElement saveStoreViewButton;
        @FindBy(css = ".success-msg")
        WebElement successMsg;

        public StoreViewPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
            testUtility=new TestUtility(driver);
        }
        public void clickOnCreateStoreViewLink(){
            testUtility.waitForElementPresent(createStoreViewLink);
            createStoreViewLink.click();
        }
        public void selectStoreDropDown(){
            testUtility.waitForElementPresent(storeDropDown);
            Select select=new Select(storeDropDown);
            select.selectByVisibleText("marka");
        }
        public void enterName(String name){
            testUtility.waitForElementPresent(storeNameField);
            storeNameField.sendKeys(name);
        }
        public void enterCode(String code){
            testUtility.waitForElementPresent(storeNameField);
            storeNameField.sendKeys(code);
        }
        public void clickSaveStoreViewButton(){
            testUtility.waitForElementPresent(saveStoreViewButton);
            saveStoreViewButton.click();
        }
        public void createAStoreView(String name,String code){
            clickOnCreateStoreViewLink();
            selectStoreDropDown();
            enterName(name);
            enterCode(code);
            clickSaveStoreViewButton();
        }
        public boolean verifyStoreViewSaved(){

            return successMsg.getText().contains("The store view has been saved");
        }
    }

