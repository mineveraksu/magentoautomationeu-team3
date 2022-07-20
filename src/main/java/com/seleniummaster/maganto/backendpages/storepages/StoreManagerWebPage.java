package com.seleniummaster.maganto.backendpages.storepages;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerWebPage {
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

    public StoreManagerWebPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    public void createWebsite(String name,String code) {
        testUtility.waitForElementPresent(createWebsiteLink);
        createWebsiteLink.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(name);
        testUtility.waitForElementPresent(codeField);
        codeField.sendKeys(code);
        testUtility.waitForElementPresent(saveWebsiteButton);
        saveWebsiteButton.click();

    }
}