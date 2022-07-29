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
    @FindBy(xpath = "//button[@title='Add']")
    WebElement addButton;
    @FindBy(xpath = "(//button[@class='scalable save'])[2]")
    WebElement sendTrackingInformationButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement updateShipmentSuccessMessage;


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
        addProductButton.click();
    }

    public void typeProductName(String productName) {
        testUtility.waitForElementPresent(productNameField);
        productNameField.sendKeys(productName+ Keys.ENTER);
    }

    public void createANewOrder(String storeName){
        clickOnCreateNewOrderButton();
        selectViewDropDown();
        clickOnCustomerEmail();
        selectAStore(storeName);
        clickOnAddProductButton();
    }


}
