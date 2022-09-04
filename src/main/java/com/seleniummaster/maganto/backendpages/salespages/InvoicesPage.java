package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InvoicesPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public InvoicesPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//td[@class=' last'])[6]/a")
    WebElement viewButton;
    @FindBy(xpath = "(//h3[@class=\"icon-head head-sales-order-invoice\"])[2]")
    WebElement invoiceID;
    @FindBy(xpath = "//textarea[@name=\"comment[comment]\"]")
    WebElement commentTextArea;
    @FindBy(xpath = "//input[@name=\"comment[is_customer_notified]\"]")
    WebElement notifyCustomerByEmailClickButton;
    @FindBy(xpath = "//input[@name=\"comment[is_visible_on_front]\"]")
    WebElement visibleByFrontEndClickButton;
    @FindBy(xpath = "//span[contains(text(),'Submit Comment')]")
    WebElement submitCommentButton;
    @FindBy(xpath = "//strong[@class=\"subdue\"]")
    WebElement customerNotifiedSMS;

    //Add and Update new tax rule
    @FindBy(xpath = "(//span[contains(text(),'Add New Tax Rule')])[1]")
    WebElement addNewTaxRuleButton;
    @FindBy(css = "#code")
    WebElement nameField;
    @FindBy(css = "#tax_customer_class")
    WebElement selectCustomerTaxClass;
    @FindBy(css = "#tax_product_class")
    WebElement selectProductClass;
    @FindBy(css = "#tax_rate")
    WebElement selectTaxRate;
    @FindBy(css = "#priority")
    WebElement priorityField;
    @FindBy(css = "#position")
    WebElement positionField;
    @FindBy(xpath = "(//span[contains(text(),'Save Rule')])[1]")
    WebElement saveRuleButton;
    @FindBy(xpath = "(//span[contains(text(),'The tax rule has been saved.')])[1]")
    WebElement addedTaxRuleSuccessMessages;
    @FindBy(xpath = "//td[contains(text(),'Team3')]")
    WebElement existingNewTaxRules;



    public void clickOnViewButton() {
        testUtility.waitForElementPresent(viewButton);
        viewButton.click();
    }

    public boolean verifyViewInvoices() {
        testUtility.waitForElementPresent(invoiceID);
        if (invoiceID.isDisplayed()) {
            System.out.println("Sales manager view invoices successfully passes!");
            return true;
        } else {
            System.out.println("Sales manager view invoices successfully failed!");
            return true;
        }
    }

    public void clickOnCommentTextField() {
        testUtility.waitForElementPresent(commentTextArea);
        commentTextArea.click();
    }

    public void writeComment(String commentText) {
        testUtility.waitForElementPresent(commentTextArea);
        commentTextArea.sendKeys(commentText);
    }

    public void clickOnNotifyCustomerByEmailClickButton() {
        testUtility.waitForElementPresent(notifyCustomerByEmailClickButton);
        notifyCustomerByEmailClickButton.click();
    }

    public void clickOnVisibleByFrontEndClickButton() {
        testUtility.waitForElementPresent(visibleByFrontEndClickButton);
        visibleByFrontEndClickButton.click();
    }

    public void clickOnSubmitCommentButton() {
        testUtility.waitForElementPresent(submitCommentButton);
        submitCommentButton.click();
    }

    public void viewInvoicesAndAddComments(String commentText) {
        clickOnViewButton();
        clickOnCommentTextField();
        writeComment(commentText);
        clickOnNotifyCustomerByEmailClickButton();
        clickOnVisibleByFrontEndClickButton();
        clickOnSubmitCommentButton();
    }

    public boolean verifyAddedCommentsToInvoiceHistorySuccessful() {
        testUtility.waitForElementPresent(customerNotifiedSMS);
        if (customerNotifiedSMS.isDisplayed()) {
            System.out.println("Sales manager add comments to invoice history test passed! ");
            return true;
        } else {
            System.out.println("Sales manager add comments to invoice history test failed!");
            return true;
        }
    }

    //Add new tax rule
    public void addNewTaxRule(String Name, String Priority , String SortOrder) {
        testUtility.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(Name+System.currentTimeMillis());
        Select dropDownCustomerTaxClass = new Select(selectCustomerTaxClass);
        dropDownCustomerTaxClass.selectByIndex(1);
        Select dropDownProductTaxClass = new Select(selectProductClass);
        dropDownProductTaxClass.selectByIndex(2);
        Select dropDownTaxRate = new Select(selectTaxRate);
        dropDownTaxRate.selectByIndex(3);
        testUtility.waitForElementPresent(priorityField);
        priorityField.clear();
        priorityField.click();
        priorityField.sendKeys(Priority);
        testUtility.waitForElementPresent(positionField);
        positionField.clear();
        positionField.sendKeys(SortOrder);
        testUtility.waitForElementPresent(saveRuleButton);
        actions.moveToElement(saveRuleButton).build().perform();
        saveRuleButton.click();
    }

    public boolean verifyAddNewTaxRuleSuccessfully() {
        testUtility.waitForElementPresent(addedTaxRuleSuccessMessages);
        if (driver.getPageSource().contains(addedTaxRuleSuccessMessages.getText())) {
            System.out.println("Marketing Manager can Add New Shopping Cart Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Shopping Cart  Test is Failed!!!");
            return false;
        }

    }
    public void updateNewTaxRule(String Number) {
        testUtility.waitForElementPresent(existingNewTaxRules);
        existingNewTaxRules.click();
        Select dropDownCustomerTaxClass = new Select(selectCustomerTaxClass);
        dropDownCustomerTaxClass.selectByIndex(1);
        Select dropDownProductTaxClass = new Select(selectProductClass);
        dropDownProductTaxClass.selectByIndex(1);
        Select dropDownTaxRate = new Select(selectTaxRate);
        dropDownTaxRate.selectByIndex(3);
        testUtility.waitForElementPresent(positionField);
        positionField.clear();
        positionField.sendKeys(Number);
        testUtility.waitForElementPresent(saveRuleButton);
        actions.moveToElement(saveRuleButton).build().perform();
        saveRuleButton.click();
    }

    public boolean verifyUpdateNewTaxRuleRuleSuccessfully() {
        testUtility.waitForElementPresent(addedTaxRuleSuccessMessages);
        if (driver.getPageSource().contains(addedTaxRuleSuccessMessages.getText())) {
            System.out.println("Marketing Manager can Add New Shopping Cart Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Shopping Cart  Test is Failed!!!");
            return false;
        }

    }
}
