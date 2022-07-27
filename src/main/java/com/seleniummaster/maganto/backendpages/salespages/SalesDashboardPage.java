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
    @FindBy(xpath = "//span[contains(text(),'Invoices')]")
    WebElement invoicesLink;
    @FindBy(xpath = "//span[text()=\"Reports\"]")
    WebElement reportsLink;
    @FindBy(xpath = "(//span[text()='Sales'])[2]")
    WebElement salesLinkUnderReportsLink;
    @FindBy(xpath = "//span[contains(text(),'Refunds')]")
    WebElement refundsLink;


    public void clickOnInvoicesLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(invoicesLink);
        actions.moveToElement(invoicesLink).click().perform();
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


}
