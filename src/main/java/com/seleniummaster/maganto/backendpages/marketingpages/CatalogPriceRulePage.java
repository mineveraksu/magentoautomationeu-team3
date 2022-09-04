package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//span[contains(text(),\"Promotions\")]")
    WebElement promotionsDropDownList;
    @FindBy(xpath = "//span[contains(text(),\"Catalog Price Rules\")]")
    WebElement catalogPriceRuleOption;
    @FindBy(css = "#promo_catalog_grid_filter_name")
    WebElement catalogRuleNameField;
    @FindBy(xpath = "//td[contains(text(),\"team3333\")]")
    WebElement team3333;
    @FindBy(css = "#rule_description")
    WebElement descriptionField;
    @FindBy(css = "#rule_website_ids")
    WebElement websites;
    @FindBy(css = "#rule_customer_group_ids")
    WebElement customerGroup;
    @FindBy(xpath = "//span[contains(text(),'Save and Apply')]")
    WebElement saveAndApplyButton;
    @FindBy(xpath = "//span[contains(text(),\"The rule has been saved.\")]")
    WebElement updateSuccessMassage;
    @FindBy(css = "#rule_sort_order")
    WebElement priority;

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
    public void selectWebsite(){
        Select select=new Select(ruleWebSiteDropDown);
        select.selectByVisibleText("www.beatty.io");
    }
    public void selectCustomerGroupName(){
        Select select2=new Select(ruleGroupNameDropDown);
        select2.selectByValue("352");//"Europe Customer"
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
    public void AddNewRule(String name,String discount){
        clickOnAddNewRuleButton();
        typeRuleName(name);
        selectWebsite();
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

    public void updateCatalogPriceRule(){
        testUtility.waitForElementPresent(catalogRuleNameField);
        catalogRuleNameField.sendKeys("team3333");
        catalogRuleNameField.sendKeys(Keys.ENTER);
        testUtility.waitForElementPresent(team3333);
        team3333.click();
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.clear();
        descriptionField.sendKeys("This is update for team3 catalog price rule;"+System.currentTimeMillis());
        testUtility.waitForElementPresent(websites);
        Select select=new Select(websites);
        select.selectByValue("29");
        testUtility.waitForElementPresent(customerGroup);
        Select select1=new Select(customerGroup);
        select1.selectByValue("244");
        testUtility.waitForElementPresent(priority);
        priority.click();
        testUtility.waitForElementPresent(saveAndApplyButton);
        testUtility.sleep(10);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Save and Apply')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public boolean verifyCatalogPriceRuleUpdateSuccess(){

        testUtility.waitForElementPresent(updateSuccessMassage);
        if (updateSuccessMassage.getText().contains("The rule has been saved.")) {
            System.out.println("marketing manager update catalog price rule test passed!");
            return true;
        } else {
            System.out.println("marketing manager update catalog price rule test failed");
            return false;
        }
    }

}
