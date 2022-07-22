package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
    WebDriver driver;
    TestUtility testUtility;


    @FindBy(xpath = "//td[@class=\"form-buttons\"]/button[2]/span/span/span")//1/3
    WebElement createStoreLink;
    @FindBy(id = "group_website_id")
    WebElement websiteDropDown;
    @FindBy(id = "group_name")
    WebElement storeNameField;
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
}
//
