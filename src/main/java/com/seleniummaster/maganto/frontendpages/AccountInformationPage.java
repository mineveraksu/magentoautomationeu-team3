package com.seleniummaster.maganto.frontendpages;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "middlename")
    WebElement middleNameField;
    @FindBy(id = "current_password")
    WebElement currentPasswordField;
    @FindBy(xpath = "(//*[@class=\"button\"])[1]")
    WebElement saveButton;
    @FindBy(css = ".success-msg>ul>li>span")
    WebElement accountInformationSavedSMS;
    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement accountEmailBox;

    public void editAccountInformation() {
        testUtility.waitForElementPresent(middleNameField);
        middleNameField.clear();
        middleNameField.sendKeys(testUtility.generateMiddleName());
        testUtility.waitForElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"password"));
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyEditAccountInformation() {
        testUtility.waitForElementPresent(accountInformationSavedSMS);
        if (driver.getPageSource().contains(accountInformationSavedSMS.getText()))
            System.out.println("The account information has been saved.");
        return true;
    }

    public String getEmailAddress(){
        return accountEmailBox.getAttribute("value");
    }
    public boolean verifyAccountInformationViewed(){
        if(getEmailAddress().length()>=1){
            System.out.println("Account information Viewed!");
            return true;
        }
        else{
            System.out.println("Please check Account Information Page!");
            return false;
        }
    }
}
