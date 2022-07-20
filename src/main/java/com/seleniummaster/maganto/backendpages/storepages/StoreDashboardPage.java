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
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class=\"active\"]//span")
    WebElement systemLink;
    @FindBy(xpath = "(//li[@class=\"  last level1\"])[2]//span")
    WebElement manageStoresLink;

    public void clickOnManageStoresLink(){
        testUtility.waitForElementPresent(systemLink);
        actions.moveToElement(systemLink).perform();
        testUtility.waitForElementPresent(manageStoresLink);
        manageStoresLink.click();
    }
}
