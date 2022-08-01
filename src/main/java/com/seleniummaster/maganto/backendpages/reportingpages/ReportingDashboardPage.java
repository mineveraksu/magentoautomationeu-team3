package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public ReportingDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//span[contains(text(),'Reports')])[1]")
    WebElement reportsLink;
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsLink;
    @FindBy(xpath = "(//span[contains(text(),'Most Viewed')])[1]")
    WebElement mostViewedLink;
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
    WebElement salesOption;
    @FindBy(xpath = "(//span[contains(text(),'Invoiced')])[1]")
    WebElement invoicedOption;
    @FindBy(xpath = "//span[contains(text(),'Shipping')]")
    WebElement shippingOption;
    @FindBy(xpath = "(//span[text()='Products Ordered'])[1]")
    WebElement productsOrderedLink;
    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement salesLink;
    @FindBy(xpath = "(//span[text()=\"Orders\"])[1]")
    WebElement ordersLink;
    @FindBy(xpath = "(//span[text()=\"Customers\"])[1]")
    WebElement customersLink;
    @FindBy(xpath = "(//span[text()=\"New Accounts\"])[1]")
    WebElement newAccountsLink;
    @FindBy(xpath = "//span[text()='Downloads']")
    WebElement downloadsLink;
    @FindBy(xpath = "(//span[contains(text(),'Tax')])[1]")
    WebElement taxLink;
    @FindBy(xpath = "//span[text()='Customers by orders total']")
    WebElement customerByOrdersTotalLink;
    @FindBy(xpath = "//span[text()='Customers by number of orders']")
    WebElement customerByNumberOfOrdersLink;


    public void clickOnMostViewedLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(productsLink);
        actions.moveToElement(productsLink).click().perform();
        testUtility.waitForElementPresent(mostViewedLink);
        actions.moveToElement(mostViewedLink).click().perform();
    }

    public void ClickOnInvoicedOption() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(invoicedOption);
        actions.moveToElement(invoicedOption).click().perform();
    }

    public void ClickOnShippingOption() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesOption);
        actions.moveToElement(salesOption).perform();
        testUtility.waitForElementPresent(shippingOption);
        shippingOption.click();
    }

    public void clickOnOrdersLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(ordersLink);
        actions.moveToElement(ordersLink).click().perform();

    }
    public void ClickOnProductsOrderedOption() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(productsLink);
        actions.moveToElement(productsLink).click().perform();
        testUtility.waitForElementPresent(productsOrderedLink);
        actions.moveToElement(productsOrderedLink).perform();
        productsOrderedLink.click();
    }


    public void clickOnNewAccountsLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(customersLink).moveToElement(newAccountsLink).click().perform();
    }
    public void ClickOnDownloadsLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(productsLink).moveToElement(downloadsLink).click().perform();

    }

    public void clickOnTaxLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(taxLink);
        actions.moveToElement(taxLink).click().perform();
    }
    public void ClickOnCustomersByOrdersTotalLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(customersLink).moveToElement(customerByOrdersTotalLink).click().perform();

    }
    public void ClickOnCustomersByNumberOfOrdersLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(customersLink).moveToElement(customerByNumberOfOrdersLink).click().perform();

    }
}


