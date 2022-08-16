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
    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement refundsLink;
    @FindBy(xpath = "//span[text()='Coupons']")
    WebElement couponsLink;
    @FindBy(xpath = "//span[text()='Tags']")
    WebElement tagsLink;
    @FindBy(xpath = "//span[text()='Popular']")
    WebElement popularLink;
    @FindBy(xpath = "//span[text()='Reviews']")
    WebElement reviewsLink;
    @FindBy(xpath = "//span[text()='Products Reviews']")
    WebElement product_ReviewsLink;


    @FindBy(xpath = "//span[text()='Bestsellers']")
    WebElement bestsellersLink;


    @FindBy(xpath = "(//span[text()='Customers'])[2]")
    WebElement customersLink2;

    @FindBy(xpath = "(//span[text()='Products'])[2]")
    WebElement productsLink2;

    @FindBy(linkText = "Show Tags")
    WebElement showTagsLink;



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

    public void clickOnRefundedLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).perform();
        testUtility.waitForElementPresent(refundsLink);
        refundsLink.click();

    }

    public void clickOnCouponsLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).perform();
        testUtility.waitForElementPresent(couponsLink);
        refundsLink.click();

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

    public void ClickOnDownloadsLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(productsLink).moveToElement(downloadsLink).click().perform();

    }

    public void clickOnTaxLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(taxLink);
        actions.moveToElement(taxLink).click().perform();
    }

    public void ClickOnCustomersByOrdersTotalLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(customersLink).moveToElement(customerByOrdersTotalLink).click().perform();

    }

    public void ClickOnCustomersByNumberOfOrdersLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(customersLink).moveToElement(customerByNumberOfOrdersLink).click().perform();

    }

    public void click_PopularLink() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(tagsLink);
        actions.moveToElement(tagsLink).click().perform();
        testUtility.waitForElementPresent(popularLink);
        actions.moveToElement(popularLink).click().perform();
    }

    public void click_Products_Reviews() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(reviewsLink);
        actions.moveToElement(reviewsLink).click().perform();
        testUtility.waitForElementPresent(product_ReviewsLink);
        actions.moveToElement(product_ReviewsLink).click().perform();
    }


    public void ClickOnBestsellersLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(productsLink);
        actions.moveToElement(productsLink).click().perform();
        testUtility.waitForElementPresent(bestsellersLink);
        actions.moveToElement(bestsellersLink).click().perform();

    }

    public void openCustomersTags() {

        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(tagsLink);
        actions.moveToElement(tagsLink).click().perform();
        testUtility.waitForElementPresent(customersLink2);
        actions.moveToElement(customersLink2).click().perform();

    }

    public void openProductsTags() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).perform();
        testUtility.waitForElementPresent(tagsLink);
        actions.moveToElement(tagsLink).perform();
        testUtility.waitForElementPresent(productsLink2);
        productsLink2.click();
    }

}




