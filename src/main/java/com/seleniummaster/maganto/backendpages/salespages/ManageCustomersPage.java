package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    String configFile = "config.properties";

    public ManageCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//span[text()='Reset Filter']")
    WebElement resetFilterButton;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;

    @FindBy(id = "customerGrid_filter_email")
    WebElement emailField;

    @FindBy(linkText = "Edit")
    WebElement editButton;

    @FindBy(id = "customer_info_tabs_cart")
    WebElement shoppingCartLink;

    @FindBy(linkText = "Configure")
    WebElement configureLink;

    @FindBy(id = "product_composite_configure_input_qty")
    WebElement quantityField;

    @FindBy(xpath = "//span[text()='OK']")
    WebElement okButton;


    @FindBy(linkText = "Delete")
    WebElement deleteButton;

    public void openShoppingCart() {
        String email = ApplicationConfig.readFromConfigProperties(configFile, "email");
        testUtility.sleep(2);
        testUtility.waitForElementPresent(resetFilterButton);
        resetFilterButton.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        searchButton.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(editButton);
        editButton.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(shoppingCartLink);
        shoppingCartLink.click();
        testUtility.sleep(2);

    }

    public void editShoppingCart() {
        testUtility.sleep(2);
        testUtility.waitForElementPresent(configureLink);
        configureLink.click();
        testUtility.sleep(2);
        quantityField.clear();
        quantityField.sendKeys("5");
        okButton.click();
        testUtility.sleep(2);
    }

    public boolean verifyEditShoppingCart() {

        if (driver.getPageSource().contains("5")) {
            System.out.println("Shopping cart edited successfully");
            return true;
        } else {
            System.out.println("Shopping cart can not be edited successfully");
            return false;
        }

    }

    public void deleteShoppingCart() {
        testUtility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public boolean verifyDeleteShoppingCart() {
        testUtility.sleep(2);
        if (driver.getPageSource().contains("No records found.")) {
            System.out.println("Shopping cart deleted successfully");
            return true;
        } else {
            System.out.println("Shopping cart cant be deleted");
            return false;
        }
    }


}
