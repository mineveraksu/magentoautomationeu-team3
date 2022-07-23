package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;
    String Config= "config.properties";
    String email;

    public CreateOrderPage(WebDriver driver){
        this.driver=driver;
        testUtility= new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }


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
    WebElement  sameAsBillingAddressRadioButton;
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

    public void openCreateANewOrderPage(WebDriver driver){
        testUtility.waitForElementPresent(createNewOrdersTab);
        createNewOrdersTab.click();
        testUtility.waitForElementPresent(customerEmailField);
        customerEmailField.click();
        customerEmailField.sendKeys(ApplicationConfig.readFromConfigProperties(Config,email));
        testUtility.waitForElementPresent(storeNameRadioButton);
        storeNameRadioButton.click();
        testUtility.waitForElementPresent(addProductsLink);
        addProductsLink.click();
        testUtility.waitForElementPresent(selectCheckBox);
        selectCheckBox.click();
        testUtility.waitForElementPresent(addSelectedProductsToOrdersLink);
        addSelectedProductsToOrdersLink.click();


    }
    public void fillBillingAndShippingAddressForm(WebDriver driver){
        testUtility.waitForElementPresent(billingAddressFirstNameField);
        billingAddressFirstNameField.click();
        billingAddressFirstNameField.sendKeys(testUtility.generateFirstName());
        testUtility.waitForElementPresent(billingAddressLastNameField);
        billingAddressLastNameField.click();
        billingAddressLastNameField.sendKeys(testUtility.generateLastName());
        testUtility.waitForElementPresent(billingAddressStreetNameField);
        billingAddressStreetNameField.click();
        billingAddressStreetNameField.sendKeys(testUtility.generateStreetAddress());
        testUtility.waitForElementPresent(billingAddressCityNameField);
        billingAddressCityNameField.click();
        billingAddressCityNameField.sendKeys(testUtility.generateCityName());
        testUtility.waitForElementPresent(billingAddressCountryNameField);
        billingAddressCountryNameField.click();
        select=new Select(billingAddressCountryNameField);
        select.selectByVisibleText("Turkey");
        testUtility.waitForElementPresent(billingAddressStateNameField);
        billingAddressStateNameField.click();
        select=new Select(billingAddressStateNameField);
        select.selectByVisibleText("Alaska");
        testUtility.waitForElementPresent(billingAddressZipCodeField);
        billingAddressZipCodeField.click();
        billingAddressZipCodeField.sendKeys(testUtility.generateZipCode());
        testUtility.waitForElementPresent(billingAddressTelephoneField);
        billingAddressTelephoneField.click();
        billingAddressTelephoneField.sendKeys(testUtility.generateTelephoneNumber());
        testUtility.waitForElementPresent(sameAsBillingAddressRadioButton);
        sameAsBillingAddressRadioButton.click();



    }

    public void selectShippingAndPaymentMethodAndSubmitOrder(WebDriver driver){
        testUtility.waitForElementPresent(getShippingMethodsAndRatesLink);
        getShippingMethodsAndRatesLink.click();
        testUtility.waitForElementPresent(freeShippingRadioButton);
        freeShippingRadioButton.click();
        testUtility.waitForElementPresent(cashOnDeliveryRadioButton);
        cashOnDeliveryRadioButton.click();
        testUtility.waitForElementPresent(submitOrderButton);
        submitOrderButton.click();

    }
    public boolean verifyCreateNewOrder(){
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("The order has been created.")){
            System.out.println("Store manager create new order test passed!");
            return true;

        }else {
            System.out.println("Store manager create new order test failed!");
            return false;
        }


    }
}
