package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    public ManageCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }
    @FindBy(xpath = "//*[@id=\"nav\"]/li[4]/a/span")
    WebElement customersLink;

    @FindBy(xpath = "//*span[text()='Manage Customers'")
    WebElement ManageCustomersLink;

    @FindBy(id = "customer_info_tabs_cart")
    WebElement shoppingCartLink;

    @FindBy(linkText = "Configure")
    WebElement configureLink;

    @FindBy(id = "product_composite_configure_input_qty")
    WebElement quantityField;

    @FindBy(css= "button[span='OK']")
    WebElement okButton;





}
