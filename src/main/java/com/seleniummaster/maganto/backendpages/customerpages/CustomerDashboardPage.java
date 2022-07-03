package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customersLink;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;
    @FindBy(xpath = "(//span[text()='Add New Customer'])[1]")
    WebElement addNewCustomerButton;

    public CustomerDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    public void clickOnCustomerGroups() {
        testUtility.waitForElementPresent(customersLink);
        actions.moveToElement(customersLink).perform();
        testUtility.waitForElementPresent(customerGroupsLink);
        customerGroupsLink.click();
    }
}
