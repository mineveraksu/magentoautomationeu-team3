package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreOrdersPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;


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


    //Store Manager can edit orders

    public StoreOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

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
    public void cancelOrder(){
        testUtility.sleep(2);
        testUtility.waitForElementPresent(cancelButton);
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
        }else{
            System.out.println("Store module order cancel false , please check out !");
            return false;
        }
    }

}
