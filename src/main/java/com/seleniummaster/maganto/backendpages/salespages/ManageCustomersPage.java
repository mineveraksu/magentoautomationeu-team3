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

    @FindBy(id = "weight")
    WebElement weightField;


    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveButton;

    @FindBy(linkText = "Delete")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"customer_cart_grid1_table\"]/thead/tr[1]/th[1]/span/a")
    WebElement customerShoppingCartView;

    @FindBy(xpath = "//*[@id=\"customer_cart_grid1_table\"]/tbody/tr")
    WebElement edit;



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

    public boolean verifyShoppingCartView() {
        testUtility.waitForElementPresent(customerShoppingCartView);
        testUtility.sleep(3);
        if (customerShoppingCartView.isDisplayed()) {
            System.out.println("Manager can view Customer Shopping Cart");
            return true;
        } else {
            System.out.println("Manager can't view Customer Shopping Cart");
            return false;
        }

    }

    public void editShoppingCart() {
        testUtility.sleep(2);
        testUtility.waitForElementPresent(edit);
        edit.click();
        testUtility.sleep(2);
        weightField.clear();
        weightField.sendKeys("5");
        testUtility.sleep(1);
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
        testUtility.sleep(1);

    }

    public boolean verifyEditShoppingCart() {

        if (driver.getPageSource().contains("The product has been saved.")) {
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
