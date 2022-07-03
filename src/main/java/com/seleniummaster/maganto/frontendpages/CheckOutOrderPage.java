package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOrderPage {
    WebDriver driver;
    TestUtility utility;

    public CheckOutOrderPage( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    @FindBy(css = "div.account-cart-wrapper span.label")
    WebElement accountLink;
    @FindBy(css="a.top-link-checkout")
    WebElement checkOutLink;
    @FindBy( css="input[id='billing:use_for_shipping_yes']")
    WebElement shipToThisAddressRadioButton;
    @FindBy( css="input[title='Ship to different address']")
    WebElement shipToDifferentAddressRadioButton;
    @FindBy( css="div[id='billing-buttons-container']>button")
    WebElement billingContinueButton;
    @FindBy( css="input[id='shipping:same_as_billing']")
    WebElement useBillingAddressCheckBox;
    @FindBy( css="div[id='shipping-buttons-container']>button")
    WebElement shippingContinueButton;
    @FindBy( css="dl.sp-methods>dt")
    WebElement flatRateInformation;
    @FindBy( css="div[id='shipping-method-buttons-container']>button")
    WebElement shippingMethodContinueButton;
    @FindBy( css="input#p_method_checkmo")
    WebElement moneyOrderRaDioButton;
    @FindBy(css = "input#p_method_cashondelivery")
    WebElement cashOnDeliveryRadioButton;
    @FindBy( css="li#opc-review span.number")
    WebElement orderReviewInfo;
    @FindBy( css="button.button.btn-checkout")
    WebElement placeOrderButton;
    @FindBy(css = "div#payment-buttons-container button")
    WebElement paymentInfoButton;
    @FindBy(xpath = "//*[@id=\"checkout-progress-wrapper\"]/div/div[2]")
    WebElement billingShippingAddressInfo;
    @FindBy(xpath = "//*[@id=\"shipping-progress-opcheckout\"]/dt")
    WebElement shippingAddressInfo;
    @FindBy(xpath = "//*[@id=\"shipping_method-progress-opcheckout\"]/dt")
    WebElement shippingMethodInfo;
    @FindBy(xpath = "//*[@id=\"payment-progress-opcheckout\"]/dd/p")
    WebElement moneyOrderMessage;
    @FindBy(xpath = "//*[@id=\"payment-progress-opcheckout\"]/dd/p")
    WebElement cashOndeliveryMessage;
    @FindBy(css = "div.page-title>h1")
    WebElement ordreReceivedMessage;
    @FindBy(css = "div#payment-progress-opcheckout>dd")
    WebElement paymentMethodMessage;
    @FindBy(xpath = "//a[text()='Edit']")
    WebElement editLink;
    @FindBy(css = "div.buttons-set>button")
    WebElement continueShoppingButton;
    @FindBy(css = "div.page-title>h2")
    WebElement homePageTitle;
    @FindBy(css = "div.page-title>h1")
    WebElement checkOutPage;

    public void clickCheckOutLink() {
        utility.waitForElementPresent(accountLink);
        accountLink.click();
        utility.waitForElementPresent(checkOutLink);
        checkOutLink.click();
        utility.waitForElementPresent(checkOutPage);
        boolean isCheckOutPageDisplayed=checkOutPage.isDisplayed();
        System.out.println("isCheckOutPageDisplayed: "+isCheckOutPageDisplayed);
    }
    public boolean clickShipToThisAddressRadioButton()
    {
        utility.waitForElementPresent(shipToThisAddressRadioButton);
        shipToThisAddressRadioButton.click();
        utility.waitForElementPresent(billingContinueButton);
        billingContinueButton.click();
        utility.waitForElementPresent(billingShippingAddressInfo);
        System.out.println("billingShippingAddressInfo is Displayed: "+billingShippingAddressInfo.isDisplayed());
        return billingShippingAddressInfo.isDisplayed();
    }
    public boolean ClickShipToDifferentAddressRadioButton()
    {
        utility.waitForElementPresent(editLink);
        editLink.click();
        utility.waitForElementPresent(shipToDifferentAddressRadioButton);
        shipToDifferentAddressRadioButton.click();
        utility.waitForElementPresent(billingContinueButton);
        billingContinueButton.click();
        utility.waitForElementPresent(useBillingAddressCheckBox);
        useBillingAddressCheckBox.click();
        utility.waitForElementPresent(shippingContinueButton);
        shippingContinueButton.click();
        utility.waitForElementPresent(shippingAddressInfo);
        System.out.println("shippingAddressInfo is Displayed: "+shippingAddressInfo.isDisplayed());
        return shippingAddressInfo.isDisplayed();
    }
    public boolean clickShippingMethodContinueButton()
    {
        utility.waitForElementPresent(shippingMethodContinueButton);
        shippingMethodContinueButton.click();
        shippingMethodInfo.isDisplayed();
        System.out.println("shippingMethodInfo is Displayed: "+shippingMethodInfo.isDisplayed());
        return shippingMethodInfo.isDisplayed();
    }
    public boolean clickPaymentInformationContinueButton()
    {
        utility.waitForElementPresent(moneyOrderRaDioButton);
        moneyOrderRaDioButton.click();
        utility.waitForElementPresent(paymentInfoButton);
        paymentInfoButton.click();
        utility.waitForElementPresent(paymentMethodMessage);
        System.out.println("paymentMethodMessage is Displayed: "+paymentMethodMessage.isDisplayed());
        return paymentMethodMessage.isDisplayed();
    }
    public boolean clickPlaceOrderButton()
    {
        utility.waitForElementPresent(placeOrderButton);
        placeOrderButton.click();
        utility.waitForElementPresent(ordreReceivedMessage);
        System.out.println("ordreReceivedMessage is Displayed: "+ordreReceivedMessage.getText());
        return ordreReceivedMessage.isDisplayed();
    }


    public void CheckOutOrderPage() {
    }
}
