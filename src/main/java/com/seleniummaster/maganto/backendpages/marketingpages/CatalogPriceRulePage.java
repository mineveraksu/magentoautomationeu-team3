package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPriceRulePage {
    WebDriver driver;
    TestUtility testUtility;

    String name;


    @FindBy(name = "name")
    WebElement ruleNameField;
    @FindBy(name = "rule_id")
    WebElement ruleIdField;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    WebElement searchButton;
    @FindBy(css = ".hor-scroll>table>tbody")
    WebElement searchedRuleLine;
    @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    WebElement addNewRuleButton;
    @FindBy(id = "rule_name")
    WebElement addRuleNameField;
    @FindBy(id = "rule_website_ids")
    WebElement ruleWebSiteDropDown;
    @FindBy(id = "rule_customer_group_ids")
    WebElement ruleGroupNameDropDown;
    @FindBy(xpath = "(//button[@title=\"Save\"])[1]")
    WebElement saveButton;
    @FindBy(id = "rule_discount_amount")
    WebElement ruleDiscountField;
    @FindBy(css = "li.success-msg")
    WebElement successMsg;//The rule has been saved.
    @FindBy(xpath = "//table[@id=\"promo_catalog_grid_table\"]//tbody")
    WebElement verifyElement;

    public CatalogPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void clickOnAddNewRuleButton(){
        testUtility.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();
    }
    public String typeRuleName(String Name){
        testUtility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(Name);
        return name;


    }
    public void selectWebsite(TestDataHolder testDataHolder){
        Select select=new Select(ruleWebSiteDropDown);
        select.selectByVisibleText(testDataHolder.getWebsiteName());
    }
    public void selectCustomerGroupName(){
        Select select2=new Select(ruleGroupNameDropDown);
        select2.selectByVisibleText("Europe Customer");//"Europe Customer"
    }
    public void typeDiscountAmount(String discount){
        testUtility.waitForElementPresent(ruleDiscountField);
        ruleDiscountField.sendKeys(discount);

    }
    public void clickOnSaveButton(){
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
        testUtility.sleep(4);

    }
    public boolean verifySavedNewRule(){

        return successMsg.getText().contains("The rule has been saved.");
    }
    public void AddNewRule(String name,TestDataHolder testDataHolder,String discount){
        clickOnAddNewRuleButton();
        typeRuleName(name);
        selectWebsite(testDataHolder);
        selectCustomerGroupName();
        clickOnSaveButton();
        typeDiscountAmount(discount);
        clickOnSaveButton();

    }
    // search added rul

    public void typeName(String name){
        testUtility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(name);
    }
    public void clickOnSearchButton(){
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void searchByName(String Name) {
        typeName(Name);
        clickOnSearchButton();

    }

    public void searchById(String id){
        testUtility.waitForElementPresent(ruleIdField);
         ruleIdField.sendKeys(id);

    }
    public boolean verifySearchResult(String rulename){

        return verifyElement.getText().contains(rulename);

    }

}
