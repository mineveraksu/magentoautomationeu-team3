package com.seleniummaster.maganto.backendpages.storepages;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreWebsitePage {
    WebDriver driver;
    TestUtility testUtility;



    @FindBy(xpath = "(//td[@class=\"form-buttons\"])[1]//span/span/span")//1/3
    WebElement createWebsiteLink;
    @FindBy(id = "website_name")
    WebElement nameField;
    @FindBy(id = "website_code")
    WebElement codeField;
    @FindBy(xpath = "(//p[@class=\"form-buttons\"])[1]/button[3]/span/span/span")
    WebElement saveWebsiteButton;
    @FindBy(css = "li.success-msg")
    WebElement websiteSavedSuccessfulSMS;
    @FindBy(linkText = "Store Name")
    WebElement storeNameLink;

    public StoreWebsitePage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    public void createWebsite(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(createWebsiteLink);
        createWebsiteLink.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(testDataHolder.getWebsiteName());
        testUtility.waitForElementPresent(codeField);
        codeField.sendKeys(testDataHolder.getWebsiteCode());
        testUtility.waitForElementPresent(saveWebsiteButton);
        saveWebsiteButton.click();
    }

    public boolean verifyWebsiteCreatedSuccessfully(){
        testUtility.waitForElementPresent(websiteSavedSuccessfulSMS);
        if (websiteSavedSuccessfulSMS.getText().contains("saved.")) {
            System.out.println("Store manager create website test passed!");
            return true;
        } else {
            System.out.println("Store manager create website test failed!");
            return false;
        }

    }
    public boolean verifyAllStoresViewed(){
        if (storeNameLink.isDisplayed()){
            System.out.println("Store manager can view all stores.");
            return true;
        }else {
            System.out.println("Store manager can not view all stores.");
            return false;
        }

    }
}