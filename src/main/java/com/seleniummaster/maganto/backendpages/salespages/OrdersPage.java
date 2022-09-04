package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {
    WebDriver driver;
    TestUtility testUtility;
    TestDataHolder testDataHolder;
    String email;
    String userName;

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
    @FindBy(id = "order-billing_address_customer_address_id")
    WebElement billingAddressDropDown;
    @FindBy(css = "#submit_order_top_button")
    WebElement submitOrderButton;
    @FindBy(css = "li.success-msg>ul>li>span")
    WebElement successMessage;
    @FindBy(id = "sales_order_grid_filter_status")
    WebElement statusDropDown;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//a[contains(text(),\"View\")]")
    WebElement viewButton;
    @FindBy(id = "sales_order_grid_filter_billing_name")
    WebElement billToNameField;
    @FindBy(xpath = "//button[@title='Ship']")
    WebElement shipButton;
    @FindBy(xpath = "//span[contains(text(),\"Add Tracking Number\")]")
    WebElement addTrackingNumberButton;
    @FindBy(id = "trackingC1")
    WebElement carrierDropDown;
    @FindBy(id = "trackingN1")
    WebElement numberField;
    @FindBy (xpath = "//span[contains(text(),\"Submit Shipment\")]")
    WebElement submitShipmentButton;
    @FindBy(xpath = "//span[contains(text(),\"The shipment has been created.\")]")
    WebElement updateSuccessMessage;
    @FindBy(xpath = "(//span[text()='Cancel'])[2]")
    WebElement cancelButton;



    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        email = ApplicationConfig.readFromConfigProperties("config.properties", "email");
        userName = ApplicationConfig.readFromConfigProperties("config.properties", "username");
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

    public void selectBillingAddressDropDown() {
        testUtility.waitForElementPresent(billingAddressDropDown);
        Select select = new Select(billingAddressDropDown);
        select.selectByIndex(1);
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
        selectBillingAddressDropDown();
        selectPaymentMethod();
        selectShippingMethod();
        clickOnSubmitOrderButton();
    }
    public void selectStatusOfOrders(){
                Select select=new Select(statusDropDown);
                select.selectByValue("pending");
                testUtility.sleep(2);
                //testUtility.waitForElementPresent(searchButton);
                searchButton.click();

    }
    public void clickOnPendingLink(TestDataHolder testDataHolder){
        testUtility.sleep(3);
        //WebElement pendingLink=driver.findElement(By.xpath(String.format("(//table[@id='sales_order_grid_table']/tbody/tr/td[contains(text(),'%s')])[1]//ancestor::tr/td[9]",testDataHolder.getBillToName())));
        WebElement pendingLink=driver.findElement(By.xpath(String.format("(//*[contains(text(),'%s')])[1]//following-sibling::td[4]","Kathryn  Carroll")));
        testUtility.waitForElementPresent(pendingLink);
        pendingLink.click();
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
    public void selectStatus(){
        selectStatusOfOrders();
    }
    public void searchBillToName(){
        testUtility.waitForElementPresent(billToNameField);
        billToNameField.sendKeys("team3");
        billToNameField.sendKeys(Keys.ENTER);
        testUtility.sleep(5);
    }

    public void updateOrderWithInStorePickup(){
        testUtility.waitForElementPresent(viewButton);
        viewButton.click();
        testUtility.waitForElementPresent(shipButton);
        shipButton.click();
        testUtility.waitForElementPresent(addTrackingNumberButton);
        addTrackingNumberButton.click();
        testUtility.waitForElementPresent(carrierDropDown);
        Select select1=new Select(carrierDropDown);
        select1.selectByValue("dhl");
        testUtility.waitForElementPresent(numberField);
        testUtility.sleep(5);
        numberField.sendKeys("123"+System.currentTimeMillis());
        testUtility.sleep(5);
        testUtility.waitForElementPresent(submitShipmentButton);
        submitShipmentButton.click();
    }

    public boolean verifyUpdateSuccess(){
        testUtility.waitForElementPresent(updateSuccessMessage);
        if (updateSuccessMessage.isDisplayed()){
            System.out.println("Update order with in store test case pickup passed");
            return true;
        }else
        {
            System.out.println("Update order with in store pickup test case field");
            return false;
        }
    }
    public void clickOnThePendingOrder() {
        WebElement orderToDelete=driver.findElement(By.xpath(String.format("(//td[contains(text(),'%s')])[1]/following-sibling::td[4][contains(text(),'Pending')]",userName)));
        testUtility.waitForElementPresent(orderToDelete);
        orderToDelete.click();
    }

    public void clickOnCancelButton() {
        testUtility.waitForElementPresent(cancelButton);
        cancelButton.click();
        testUtility.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void deleteOrder() {
        clickOnThePendingOrder();
        clickOnCancelButton();
    }

    public boolean verifyOrderDeletedSuccessfully(){
        testUtility.waitForElementPresent(successMessage);
        if(successMessage.isDisplayed()){
            System.out.println("Sales Manager delete a order Test Passed");
            return true;
        }else{
            System.out.println("Sales Manager delete a order Test Failed");
            return false;
        }
    }


}
