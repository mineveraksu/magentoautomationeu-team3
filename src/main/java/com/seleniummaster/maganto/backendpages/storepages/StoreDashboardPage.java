package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public StoreDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//a[@class=\"active\"]//span")
    WebElement systemLink;
    @FindBy(xpath = "(//li[@class=\"  last level1\"])[2]//span")
    WebElement manageStoresLink;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = " //span[text()='Manage Products']")
    WebElement manageProductsLink;
    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement salesLink;
    @FindBy(xpath = "//span[text()=\"Orders\"]")
    WebElement ordersLink;
    @FindBy(xpath = "(//a[text()='View'])[1]")
    WebElement viewLink;



    public void clickOnManageStoresLink() {
        testUtility.waitForElementPresent(systemLink);
        actions.moveToElement(systemLink).click().perform();
        testUtility.waitForElementPresent(manageStoresLink);
        manageStoresLink.click();
    }

    public void clickOnManageProductLink(){
        testUtility.waitForElementPresent(catalogLink);
        catalogLink.click();
        testUtility.waitForElementPresent(manageProductsLink);
        manageProductsLink.click();
    }

    public  void clickOnOrdersLink(){
        testUtility.waitForElementPresent(salesLink);
        actions.moveToElement(salesLink).click().perform();
        testUtility.waitForElementPresent(ordersLink);
        actions.moveToElement(ordersLink).click().perform();
    }

    public void clickOnViewLink(){
        testUtility.waitForElementPresent(viewLink);
        actions.moveToElement(viewLink).click().perform();
    }







}
