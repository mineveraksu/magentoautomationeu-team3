package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OrdersPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[text()='Orders']")
    WebElement ordersLink;
    @FindBy(css="#sales_order_grid_filter_real_order_id")
    WebElement orderIdField;
    @FindBy(xpath = "//span[(text()='Search')]")
    WebElement searchButton;
    @FindBy(xpath = "(//a[text()='View'])[1]")
    WebElement viewLink;
    @FindBy(xpath = "(//span[text()=\"Edit\"])[1]")
    WebElement editButton;
    @FindBy(xpath = "//input[@id=\"order-billing_address_postcode\"]")
    WebElement zipCodeField;
    @FindBy(xpath = "//input[@id=\"order-billing_address_telephone\"]")
    WebElement telephoneField;
    @FindBy(xpath = "//input[@id=\"p_method_checkmo\"]")
    WebElement checkOrderButton;
    @FindBy(xpath = "Shipping & Handling Information")
    WebElement shippingAndHandlingInformationField;










    public OrdersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }









}
