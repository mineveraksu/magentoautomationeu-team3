package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    TestUtility utility;
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
    @FindBy(css = "p.welcome-msg")
    WebElement loginVerifyMessage;

    public LoginPage(WebDriver driver, TestUtility utility) {
        this.driver = driver;
        this.utility = utility;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        driver.get(ApplicationConfig.readFromConfigProperties(config, "puburl"));
        utility.waitForElementPresent(accountLink);
        accountLink.click();
        utility.waitForElementPresent(loginLink);
        loginLink.click();
        utility.waitForElementPresent(emailField);
        emailField.sendKeys(ApplicationConfig.readFromConfigProperties(config, "email"));
        utility.waitForElementPresent(passWordField);
        passWordField.sendKeys(ApplicationConfig.readFromConfigProperties(config, "password"));
        utility.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public boolean verifyLogin() {
        utility.waitForElementPresent(loginVerifyMessage);
        if (driver.getPageSource().contains(loginVerifyMessage.getText()))
            System.out.println("login successfully");
        return true;
    }
}
