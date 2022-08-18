package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public SalesDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
    WebElement salesLink;
//    @FindBy(xpath = "//span[contains(text(),'Orders')]")
//    WebElement ordersLink;

    @FindBy(xpath = "//span[contains(text(),'Invoices')]")
    WebElement invoicesLink;
    @FindBy(xpath = "(//*[text()='Sales'])[1]")
    WebElement salesTeb;
    @FindBy(xpath = "(//span[text()='Shipments'])[1]")
    WebElement shipmentsOption;
    @FindBy(xpath = "//span[contains(text(),'Credit Memos')]")
    WebElement creditMemoLink;

    @FindBy(xpath = "(//span[contains(text(),'Tax')])[1]")
    WebElement taxLink;
    @FindBy(xpath = "(//span[contains(text(),'Manage Tax Rules')])[1]")
    WebElement manageTaxRulesLink;
    @FindBy(xpath = "//span[contains(text(),'Orders')]")
    WebElement ordersLink;
    @FindBy(xpath = "(//span[contains(text(),'Reports')])[2]")
    WebElement reportsLink;
    @FindBy(xpath = "(//span[contains(text(),'Sales')])[2]")
    WebElement salesLinkUnderReportsLink;
    @FindBy(xpath = "//span[contains(text(),'Refunds')]")
    WebElement refundsLink;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[4]/a/span")
    WebElement customersLink;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProductsLink;



    public void clickOnInvoicesLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(invoicesLink);
        actions.moveToElement(invoicesLink).click().perform();
    }

    public void clickOnShipmentsOption(){
        testUtility.waitForElementPresent(salesTeb);
        actions.moveToElement(salesTeb).perform();
        testUtility.waitForElementPresent(shipmentsOption);
        shipmentsOption.click();

    }
    public void clickOnCreditMemoLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(creditMemoLink);
        actions.moveToElement(creditMemoLink).click().perform();

    }
    public void clickOnManageTaxRulesLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(taxLink);
        actions.moveToElement(taxLink).click().perform();
        testUtility.waitForElementPresent(manageTaxRulesLink);
        actions.moveToElement(manageTaxRulesLink).click().perform();

    }

    public void clickOnOrdersLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).perform();
        testUtility.waitForElementPresent(ordersLink);
        ordersLink.click();

    }

    public void clickOnRefundsLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLinkUnderReportsLink);
        actions.moveToElement(salesLinkUnderReportsLink).click().perform();
        testUtility.waitForElementPresent(refundsLink);
        actions.moveToElement(refundsLink).click().perform();
        testUtility.sleep(2);
    }
    public void clickOnManageCustomersLink(){
        testUtility.waitForElementPresent(customersLink);
        actions.moveToElement(customersLink).click().perform();
        testUtility.waitForElementPresent(manageCustomersLink);
        manageCustomersLink.click();
    }

    public void clickOnManageProductsLink(){
        testUtility.waitForElementPresent(catalogLink);
        catalogLink.click();
        testUtility.waitForElementPresent(manageProductsLink);
        manageProductsLink.click();
    }




}
