package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    String config="config.properties";


    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customersLink;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;
    @FindBy(css = "button[title='Search']")
    WebElement searchButton;
    @FindBy(css = "input[name='email']")
    WebElement emailTextBox;
    @FindBy(xpath = "//td[contains(text(),\"team33@hotmail.com\")]")
    WebElement customerEmailAddress;
    @FindBy(css = "#customer_info_tabs_addresses")
    WebElement addressesLink;

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

    public void clickOnManageCustomers(){
        testUtility.waitForElementPresent(customersLink);
        actions.moveToElement(customersLink).perform();
        testUtility.waitForElementPresent(manageCustomersLink);
        manageCustomersLink.click();
    }

    //Customer Manager can add a new address for a customer_Tursunay
    public void navigateToAddressesLink(){
        testUtility.waitForElementPresent(emailTextBox);
        emailTextBox.sendKeys(ApplicationConfig.readFromConfigProperties(config,"email"));
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.waitForElementPresent(customerEmailAddress);
        testUtility.sleep(3);
        customerEmailAddress.click();
        testUtility.waitForElementPresent(addressesLink);
        addressesLink.click();
    }

}
