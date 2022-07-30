package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(id = "rule_name")
    WebElement ruleNameField;
    @FindBy(id = "rule_description")
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
        dropDownGroups.selectByValue("0");
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

}


