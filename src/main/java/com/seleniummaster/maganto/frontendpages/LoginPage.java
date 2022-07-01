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

    @FindBy(xpath="(//span[text()='Account'])[1]")
    WebElement accountLink;
    @FindBy(xpath = "//a[text()='Log In']")
    WebElement loginLink;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passWordField;
    @FindBy(id = "send2")
    WebElement loginButton;
    @FindBy(css = "p.welcome-msg")
    WebElement loginVerifyMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    public void login() {
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

    public boolean verifyLogin() {
        testUtility.waitForElementPresent(loginVerifyMessage);
        if (driver.getPageSource().contains(loginVerifyMessage.getText()))
            System.out.println("login successfully");
        return true;
    }
}
