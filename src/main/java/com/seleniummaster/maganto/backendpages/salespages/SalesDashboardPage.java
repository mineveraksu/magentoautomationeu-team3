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
    @FindBy(xpath = "(//*[text()='Sales'])[1]")
    WebElement salesTeb;
    @FindBy(xpath = "(//span[text()='Shipments'])[1]")
    WebElement shipmentsOption;

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
}
