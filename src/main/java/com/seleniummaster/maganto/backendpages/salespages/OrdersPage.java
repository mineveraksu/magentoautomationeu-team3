package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {
    WebDriver driver;
    TestUtility testUtility;
    String email;

    @FindBy(xpath = "//td[@class=\"form-buttons\"]/button/span/span/span")
    WebElement createNewOrderButton;
    @FindBy(name = "limit")
    WebElement viewDropDown;
    @FindBy(xpath = "//span[text()='Add Products']")
    WebElement addProductButton;
    @FindBy(css = "#sales_order_create_search_grid_filter_name")
    WebElement productNameField;
    @FindBy(xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addSelectedProductsToOrderButton;
    @FindBy(xpath = "//input[@value='checkmo']")
    WebElement checkOrderRadioButton;
    @FindBy(xpath = "//a[contains(text(),'shipping method')]")
    WebElement changeShippingMethodLink;
    @FindBy(xpath = "//input[@value='freeshipping_freeshipping']")
    WebElement freeShippingRadioButton;
    @FindBy(css = "#submit_order_top_button")
    WebElement submitOrderButton;
    @FindBy(css = "li.success-msg>ul>li>span")
    WebElement successMessage;


    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        email = ApplicationConfig.readFromConfigProperties("config.properties", "email");
    }

    public void clickOnCreateNewOrderButton() {
        testUtility.waitForElementPresent(createNewOrderButton);
        createNewOrderButton.click();
    }

    public void selectViewDropDown() {
        testUtility.waitForElementPresent(viewDropDown);
        Select select = new Select(viewDropDown);
        select.selectByIndex(4);
    }

    public void clickOnCustomerEmail() {
        testUtility.sleep(3);
        WebElement customerEmail = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", email)));
        testUtility.waitForElementPresent(customerEmail);
        customerEmail.click();
    }

    public void selectAStore(String storeName) {
        WebElement storeNameLocation = driver.findElement(By.xpath(String.format("//label[text()='%s']", storeName)));
        testUtility.waitForElementPresent(storeNameLocation);
        storeNameLocation.click();
    }

    public void clickOnAddProductButton() {
        testUtility.waitForElementPresent(addProductButton);
        testUtility.javaScriptClick(addProductButton);
    }

    public void typeProductName(String productName) {
        testUtility.waitForElementPresent(productNameField);
        productNameField.sendKeys(productName + Keys.ENTER);
    }

    public void selectCheckbox(String productName) {
        testUtility.sleep(2);
        WebElement checkBox=driver.findElement(By.xpath(String.format("(//*[contains(text(),'%s')])[2]//following-sibling::td[3]/input", productName)));
        testUtility.waitForElementPresent(checkBox);
        checkBox.click();
    }

    public void clickOnAddSelectedProductsToOrderButton() {
        testUtility.waitForElementPresent(addSelectedProductsToOrderButton);
        addSelectedProductsToOrderButton.click();
    }

    public void selectPaymentMethod() {
        testUtility.waitForElementPresent(checkOrderRadioButton);
        checkOrderRadioButton.click();
    }

    public void selectShippingMethod() {
        testUtility.waitForElementPresent(changeShippingMethodLink);
        changeShippingMethodLink.click();
        testUtility.waitForElementPresent(freeShippingRadioButton);
        freeShippingRadioButton.click();
    }

    public void clickOnSubmitOrderButton() {
        testUtility.waitForElementPresent(submitOrderButton);
        submitOrderButton.click();
    }


    public void createANewOrder(String storeName, String productName) {
        clickOnCreateNewOrderButton();
        selectViewDropDown();
        clickOnCustomerEmail();
        selectAStore(storeName);
        clickOnAddProductButton();
        typeProductName(productName);
        selectCheckbox(productName);
        clickOnAddSelectedProductsToOrderButton();
        selectPaymentMethod();
        selectShippingMethod();
        clickOnSubmitOrderButton();
    }

    public boolean verifyOrderCreatedSuccessfully(){
        testUtility.waitForElementPresent(successMessage);
        if(successMessage.isDisplayed()){
            System.out.println("Sales Manager create a new order Test Passed");
            return true;
        }else{
            System.out.println("Sales Manager create a new order Test Failed");
            return false;
        }
    }
}
