package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreOrdersPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;
    String Config= "config.properties";
    String email = "email" ;

    public StoreOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//span[text()=\"Edit\"])[1]")
    WebElement editButton;
    @FindBy(xpath = "//input[@id=\"order-billing_address_postcode\"]")
    WebElement zipCodeField;
    @FindBy(xpath = "//input[@id=\"order-billing_address_telephone\"]")
    WebElement telephoneField;
    @FindBy(xpath = "(//span[contains(text(),'Validate VAT Number')])[1]")
    WebElement validateVatNumberButton;
    @FindBy(xpath = "//a[contains(text(),'Get shipping methods and rates')]")
    WebElement getShippingMethodsAndRates;
    @FindBy(xpath = "//input[contains(@id,'s_method_flatrate_flatrate')]")
    WebElement fixedRadioButton;
    @FindBy(xpath = "//button[contains(@class,'scalable save')]")
    WebElement submitOrderButton;//cancel
    @FindBy(xpath = "//span[text()='The order has been created.']")
    WebElement verifyOrderSuccessfulEdited;
    @FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
    WebElement cancelButton;
    @FindBy(xpath = "//span[contains(text(),'The order has been cancelled.')]")
    WebElement cancelOrderSuccessMassage;


    @FindBy (xpath = "//input[@type='text' and @id='sales_order_create_customer_grid_filter_email']")
    WebElement customerEmailField;
    @FindBy (xpath = "//td[contains(text(),'team33@hotmail.com')]")
    WebElement selectedEmailField;
    @FindBy (xpath = "//span[contains(.,'Add Products')]")
    WebElement addProductsLink;
    @FindBy (xpath = "//table[@id='sales_order_create_search_grid_table']/tbody/tr/td[2]")
    WebElement productName;
    @FindBy (xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addSelectedProductsToOrdersLink;


    @FindBy (css="#order-billing_address_firstname")
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
    @FindBy (xpath = "//input[@id='p_method_cashondelivery']")
    WebElement cashOnDeliveryRadioButton;

    @FindBy (xpath = "//a[@onclick='order.loadShippingRates();return false']")
    WebElement getShippingMethodsAndRatesLink;
    @FindBy (xpath = "//input[@onclick='order.setShippingMethod(this.value)']")
    WebElement freeShippingRadioButton;
    @FindBy (xpath = "//span[text()='The order has been created.']")
    WebElement successMessage;


    //Store Manager can create a new order
    public void selectCustomerAndProduct(String storeName){
        testUtility.waitForElementPresent(customerEmailField);
        customerEmailField.click();
        customerEmailField.sendKeys(ApplicationConfig.readFromConfigProperties(Config,email));
        customerEmailField.sendKeys(Keys.ENTER);
        testUtility.waitForElementPresent(selectedEmailField);
        selectedEmailField.click();
        testUtility.sleep(3);
        WebElement storeNameRadioButton=driver.findElement(By.xpath(String.format("//label[text()='%s']", storeName)));
        testUtility.waitForElementPresent(storeNameRadioButton);
        storeNameRadioButton.click();
        testUtility.waitForElementPresent(addProductsLink);
        testUtility.javaScriptClick(addProductsLink);
        testUtility.waitForElementPresent(productName);
        testUtility.javaScriptClick(productName);
        testUtility.waitForElementPresent(addSelectedProductsToOrdersLink);
        testUtility.javaScriptClick(addSelectedProductsToOrdersLink);
    }

    public void selectShippingMethodAndSubmitOrder() {
        testUtility.sleep(5);
        testUtility.waitForElementPresent(getShippingMethodsAndRatesLink);
        getShippingMethodsAndRatesLink.click();
        testUtility.sleep(5);
        testUtility.waitForElementPresent(freeShippingRadioButton);
        freeShippingRadioButton.click();
        testUtility.sleep(5);
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

    //Store Manager can edit orders
    public void editOrderInformation() {
        testUtility.waitForElementPresent(editButton);
        actions.moveToElement(editButton).click().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        testUtility.waitForElementPresent(zipCodeField);
        zipCodeField.clear();
        zipCodeField.sendKeys(testUtility.generateZipCode());
        testUtility.waitForElementPresent(telephoneField);
        telephoneField.clear();
        telephoneField.sendKeys(testUtility.generateTelephoneNumber());
        testUtility.sleep(2);
        testUtility.waitForElementPresent(validateVatNumberButton);
        actions.moveToElement(validateVatNumberButton).click().perform();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(getShippingMethodsAndRates);
        actions.moveToElement(getShippingMethodsAndRates).click().perform();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(fixedRadioButton);
        actions.moveToElement(fixedRadioButton).click().perform();
        testUtility.sleep(3);
        actions.moveToElement(submitOrderButton).click().perform();

    }

    public boolean verifyOrderEdited() {
        testUtility.waitForElementPresent(verifyOrderSuccessfulEdited);
        if (verifyOrderSuccessfulEdited.getText().contains("created.")) {
            System.out.println(" Store manager edit order successful !");
            return true;
        } else {
            System.out.println("Store manager edit order failed ! ");
            return false;
        }
    }

    //Store Manager can cancel orders
    public void clickOnCancelOrder(){
        testUtility.sleep(2);
        actions.moveToElement(cancelButton).click().perform();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        testUtility.sleep(2);
    }

    public boolean verifyOrderCancelSuccessful(){
        testUtility.waitForElementPresent(cancelOrderSuccessMassage);
        if(cancelOrderSuccessMassage.getText().contains("The order has been cancelled.")){
            System.out.println("Store module order cancel successful !");
            return true;
        }
        else{
            System.out.println("Store module order cancel false , please check out !");
            return false;
        }
    }

}
