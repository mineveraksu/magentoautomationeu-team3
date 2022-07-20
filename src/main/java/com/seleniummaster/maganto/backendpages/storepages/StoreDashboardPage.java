package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css="li[class='parent level0']")
    WebElement catalogButton;
    @FindBy(css="//span[text()='Manage Products']")
    WebElement manageProductsButton;


    public StoreDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);

    }

    public void clickOnManageProductButton(){
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
        testUtility.waitForElementPresent(manageProductsButton);
        manageProductsButton.click();

    }
}
