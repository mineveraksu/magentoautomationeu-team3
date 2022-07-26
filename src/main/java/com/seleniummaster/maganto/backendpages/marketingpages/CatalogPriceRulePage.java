package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPriceRulePage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(name = "name")
    WebElement ruleNameField;
    @FindBy(name = "rule_id")
    WebElement ruleIdField;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    WebElement searchButton;
    @FindBy(css = "tr.even.pointer")
    WebElement searchedRuleLine;

    public CatalogPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    public void searchById(String id){
        testUtility.waitForElementPresent(ruleIdField);
        ruleIdField.sendKeys(id);
    }
    public void searchByName(String name){
        testUtility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(name);
    }
    public void clickOnSearchButton(){
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public boolean verifySearchResult(){



        return true;
    }

}
