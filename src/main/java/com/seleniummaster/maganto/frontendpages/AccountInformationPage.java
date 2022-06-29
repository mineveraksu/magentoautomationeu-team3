package com.seleniummaster.maganto.frontendpages;
import com.github.javafaker.Faker;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {
    WebDriver driver;
    TestUtility testUtility;
    Faker faker;
    String config = "config.properties";

    public AccountInformationPage(WebDriver driver, TestUtility testUtility) {
        this.driver = driver;
        this.testUtility = testUtility;
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


    public void editAccountInformation() {
        testUtility.waitForElementPresent(middleNameField);
        middleNameField.sendKeys(faker.name().nameWithMiddle());
        testUtility.waitForElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(config, "password");
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyEditAccountInformation() {
        testUtility.waitForElementPresent(accountInformationSavedSMS);
        if (driver.getPageSource().contains(accountInformationSavedSMS.getText()))
            System.out.println("The account information has been saved.");
        return true;
    }

}
