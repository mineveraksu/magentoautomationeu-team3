package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestResultListener;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class CatalogDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    @FindBy(css = ".active>a")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(xpath = "//span[text()='Attributes']")
    WebElement attributesLink;
    @FindBy(xpath = "//span[text()='Manage Attributes']")
    WebElement manageAttributesLink;

    public CatalogDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void clickOnManageCategories(){
        testUtility.waitForElementPresent(catalogLink);
        catalogLink.click();
        testUtility.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
    }

    public void clickOnManageAttributes(){
        testUtility.waitForElementPresent(catalogLink);
        actions.moveToElement(catalogLink).perform();
        testUtility.waitForElementPresent(attributesLink);
        actions.moveToElement(attributesLink).click(manageAttributesLink).perform();
    }

}
