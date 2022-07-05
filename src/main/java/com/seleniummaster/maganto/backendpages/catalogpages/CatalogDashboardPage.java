package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = ".active>a")
    WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;


    public CatalogDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void clickOnManageCategories(){
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
        testUtility.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
    }

}
