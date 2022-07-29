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
    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement salesLink;
    @FindBy(xpath = "(//span[text()=\"Orders\"])[1]")
    WebElement ordersLink;

    public void clickOnMostViewedLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(productsLink);
        actions.moveToElement(productsLink).click().perform();
        testUtility.waitForElementPresent(mostViewedLink);
        actions.moveToElement(mostViewedLink).click().perform();
    }

    public void clickOnOrdersLink(){
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(ordersLink);
        actions.moveToElement(ordersLink).click().perform();
    }

}
