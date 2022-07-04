package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";

    public FilterCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(css = "input[name='email']")
    WebElement emailField;

    @FindBy(css = "button[title='Search']")
    WebElement searchButton;

    @FindBy(css = "tr>td:nth-child(4)")
    WebElement customerEmail;

    public void clickEmailField(String email) {
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public boolean verifyFilterCustomerByEmail() {
        testUtility.waitForElementPresent(customerEmail);
        if (driver.getPageSource().contains(customerEmail.getText())) {
            System.out.println("Customer Manager can filter customers by Email Test is Passed!");
            return true;
        } else {
            System.out.println("Customer Manager can filter customers by Email Test is Failed!");
            return false;

        }
    }
}