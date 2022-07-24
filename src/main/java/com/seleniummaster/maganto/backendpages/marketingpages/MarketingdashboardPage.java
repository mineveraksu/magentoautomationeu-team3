package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingdashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    String config="config.properties";

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterLink;
    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsletterTemplatesLink;

    public MarketingdashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }

    public void clickOnNewsletterTemplatesLink() {
        testUtility.waitForElementPresent(newsletterLink);
        actions.moveToElement(newsletterLink).perform();
        testUtility.waitForElementPresent(newsletterTemplatesLink);
        newsletterTemplatesLink.click();
    }

}
