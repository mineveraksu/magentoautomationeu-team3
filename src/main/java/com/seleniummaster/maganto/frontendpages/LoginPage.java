package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";

    @FindBy(xpath = "(//span[text()='Account'])[1]")
    WebElement accountLink;
    @FindBy(xpath = "//a[text()='Log In']")
    WebElement loginLink;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passWordField;
    @FindBy(id = "send2")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility=new TestUtility(driver);

    }

    public void login() {
        driver.get(ApplicationConfig.readFromConfigProperties(config, "puburl"));
        testUtility.waitForElementPresent(accountLink);
        accountLink.click();
        testUtility.waitForElementPresent(loginLink);
        loginLink.click();
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(ApplicationConfig.readFromConfigProperties(config, "email"));
        testUtility.waitForElementPresent(passWordField);
        passWordField.sendKeys(ApplicationConfig.readFromConfigProperties(config, "password"));
        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }


}
