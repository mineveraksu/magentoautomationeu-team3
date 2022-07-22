package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;

//    public CreateOrderPage(){
//        this.driver=
//    }

    @FindBy(xpath = "(//span[text()='Create New Order'])[2]")
    WebElement createNewOrdersTab;
    @FindBy (id = "sales_order_create_customer_grid_filter_name")
    WebElement customerNameField;
    @FindBy (id = "sales_order_create_customer_grid_filter_entity_id")
    WebElement customerIdField;
    @FindBy (xpath = "//input[@type='text' and @id='sales_order_create_customer_grid_filter_email']")
    WebElement customerEmailField;
    @FindBy (xpath = "//input[@id='store_60']")
    WebElement storeNameRadioButton;
    @FindBy (xpath = "//span[text()='Add Products']")
    WebElement addProductsLink;
    @FindBy (xpath = "//input[@type='checkbox']")
    WebElement selectCheckBox;
    @FindBy (xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addSelectedProductsToOrdersLink;

    @FindBy (xpath ="//input[@type='text' and @id='order-billing_address_firstname']" )
    WebElement billingAddressFirstNameField;
    @FindBy (xpath = "//input[@type='text' and @id='order-billing_address_lastname']")
    WebElement billingAddressLastNameField;
    @FindBy (xpath = "//input[@type='text' and @id='order-billing_address_street0']")
    WebElement billingAddressStreetNameField;
    @FindBy (xpath = "//input[@type='text' and @id='order-billing_address_city']")
    WebElement billingAddressCityNameField;

    @FindBy (xpath = "//select[@id=\"order-billing_address_country_id\"]")
    WebElement billingAddressCountryNameField;
    @FindBy (xpath = "//select[@id=\"order-billing_address_region_id\"]")
    WebElement billingAddressStateNameField;

    @FindBy (xpath = "//input[@type='text' and @id='order-billing_address_postcode']")
    WebElement billingAddressZipCodeField;
    @FindBy (xpath = "//input[@type='text' and @id='order-billing_address_telephone']")
    WebElement billingAddressTelephoneField;
    @FindBy (xpath = "//input[@id=\"order-shipping_as_billing\"]")
    WebElement  sameAsBilingAddressRadioButton;
    @FindBy (xpath = "//input[@id='p_method_cashondelivery']")
    WebElement cashOnDeliveryRadioButton;

    @FindBy (xpath = "//a[@onclick='order.loadShippingRates();return false']")
    WebElement getShippingMethodsAndRatesLink;
    @FindBy (xpath = "//input[@onclick='order.setShippingMethod(this.value)']")
    WebElement freeShippingRadioButton;

    @FindBy (xpath = "//span[text()='Submit Order']")
    WebElement submitOrderButton;

    @FindBy (xpath = "//span[text()='The order has been created.']")
    WebElement successMessage;
}
