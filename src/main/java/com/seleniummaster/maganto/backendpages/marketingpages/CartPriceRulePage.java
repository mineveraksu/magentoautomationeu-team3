
package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPriceRulePage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    @FindBy(xpath = "//span[text()='Promotions']")
    WebElement promotionsLink;
    @FindBy(xpath = "//span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceRulesLink;
    @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    WebElement addNewRuleButton;
    @FindBy(xpath = "//input[@id='rule_name']")
    WebElement ruleNameField;
    @FindBy(xpath = "//input[@id='rule_name']")
    WebElement descriptionField;
    @FindBy(id = "rule_is_active")
    WebElement status;
    @FindBy(id ="rule_website_ids" )
    WebElement websites;
    @FindBy(id="rule_customer_group_ids")
    WebElement customerGroups;
    @FindBy(id = "rule_coupon_type")
    WebElement coupon;
    @FindBy(css = "#rule_sort_order")
    WebElement priorityField;
    @FindBy(xpath = "(//span[text()='Save'])[1]")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()='The rule has been saved.']")
    WebElement successMessages;
    @FindBy(xpath = "//td[contains(text(),'50% Sales')]")
    WebElement existingRule;
    @FindBy (xpath = "//td[contains(@class,'a-right ')]")
    WebElement selectedCartRuleIdFirstColumn;





    @FindBy(xpath = "//input[@id='promo_quote_grid_filter_rule_id']")
    WebElement cartRuleIdField;
    @FindBy(xpath = "//input[@id='promo_quote_grid_filter_name']")
    WebElement CartRuleNameField;
    @FindBy(xpath = "//td[@class='a-right ']")
    WebElement filteredCartRuleIdField;
    @FindBy(xpath = "//td[@class='a-left ']")
    WebElement SelectedCartRuleNameField;
    @FindBy(xpath = "//*[contains(text(),'Search')]")
    WebElement cartRuleSearchButton;
    @FindBy(xpath = "//*[contains(text(),'No records found')]")
    WebElement noRecordsFoundMessage;
    @FindBy(xpath = "//tbody/tr[6]/td[2]/div[1]/select[1]/option[1]")
    WebElement website;
    @FindBy(xpath = "//*[contains(text(),'50% Sales(team3)')]")
    WebElement selectedCartRuleNamesFirstColumn;




    public CartPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions=new Actions(driver);
    }
    public void clickShoppingCartPriceRulesLink() {
        testUtility.waitForElementPresent(promotionsLink);
        actions.moveToElement(promotionsLink).click().perform();
        testUtility.waitForElementPresent(shoppingCartPriceRulesLink);
        actions.moveToElement(shoppingCartPriceRulesLink).click().perform();

    }
    public void addNewShoppingCartPriceRule(String RuleName,String description ,String Priority ){

        testUtility.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();
        testUtility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(RuleName);
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(description);
        Select dropDownStatus = new Select(status);
        dropDownStatus.selectByVisibleText("Active");
        Select dropDownWebsites=new Select(websites);
        dropDownWebsites.selectByIndex(1);
        Select dropDownGroups=new Select(customerGroups);
        dropDownGroups.selectByValue("1");
        Select dropDownCoupon=new Select(coupon);
        dropDownCoupon.selectByValue("1");
        testUtility.waitForElementPresent(priorityField);
        priorityField.sendKeys(Priority);
        testUtility.waitForElementPresent(saveButton);
        actions.moveToElement(saveButton).build().perform();
        saveButton.click();
    }
    public boolean verifyAddNewShoppingCartPriceRuleSuccessfully() {
        testUtility.waitForElementPresent(successMessages);
        if (driver.getPageSource().contains(successMessages.getText())) {
            System.out.println("Marketing Manager can Add New Shopping Cart Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Shopping Cart  Test is Failed!!!");
            return false;
        }
    }

    public void updateCartPriceRule(String RuleName,String Description){
        testUtility.waitForElementPresent(CartRuleNameField);
        CartRuleNameField.click();
        CartRuleNameField.clear();
        testUtility.waitForElementPresent(cartRuleSearchButton);
        cartRuleSearchButton.click();
        CartRuleNameField.click();
        CartRuleNameField.sendKeys(RuleName);
        testUtility.waitForElementPresent(cartRuleSearchButton);
        cartRuleSearchButton.click();
        WebElement selectedCartRuleNamesFirstColumn=driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", RuleName)));
        testUtility.waitForElementPresent(selectedCartRuleNamesFirstColumn);
        selectedCartRuleNamesFirstColumn.click();
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(Description);
        testUtility.waitForElementPresent(websites);
        websites.click();
        Select select5= new Select(websites);
        select5.selectByIndex(3);
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean updateCartPriceRuleSuccessfully(){
        testUtility.waitForElementPresent(successMessages);
        if (driver.getPageSource().contains(successMessages.getText())) {
            System.out.println("Marketing Manager can update Shopping Cart Price Rule Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can update Shopping Cart Price Rule Test is Failed!!!");
            return false;
        }

    }

    //filtercartpricerulebyidandname

    public void filterCartPriceRuleById(String RuleId){
        testUtility.waitForElementPresent(cartRuleIdField);
        testUtility.sleep(3);
        cartRuleIdField.click();
        cartRuleIdField.clear();
        cartRuleIdField.sendKeys(RuleId);
        testUtility.waitForElementPresent(cartRuleSearchButton);
        cartRuleSearchButton.click();


    }

    public boolean verifyFilterCartPriceRuleById(String RuleId){
        testUtility.waitForElementPresent(selectedCartRuleIdFirstColumn);
        return selectedCartRuleIdFirstColumn.getText().equals(RuleId);

    }

    public void clearRuleIdFiled(){
        testUtility.waitForElementPresent(cartRuleIdField);
        cartRuleIdField.click();
        cartRuleIdField.clear();
        testUtility.waitForElementPresent(cartRuleSearchButton);
        cartRuleSearchButton.click();
    }


    public void filterCartPriceRuleByName(String RuleName){
        testUtility.waitForElementPresent(CartRuleNameField);
        CartRuleNameField.click();
        CartRuleNameField.sendKeys(RuleName);
        testUtility.waitForElementPresent(cartRuleSearchButton);
        cartRuleSearchButton.click();


    }

    public boolean verifyFilterCartPriceRuleByName(String RuleName){
        WebElement selectedCartRuleNameFirstColumn=driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", RuleName)));
        testUtility.waitForElementPresent(selectedCartRuleNamesFirstColumn);
        return selectedCartRuleNameFirstColumn.getText().equals(RuleName);

    }



}

