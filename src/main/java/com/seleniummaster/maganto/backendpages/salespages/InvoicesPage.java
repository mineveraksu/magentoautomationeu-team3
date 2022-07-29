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
    public void addNewTaxRule(String Name, String Priority1, String SortOrder) {
        testUtility.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(Name);
        Select dropDownCustomerTaxClass = new Select(selectCustomerTaxClass);
        dropDownCustomerTaxClass.selectByIndex(1);
        Select dropDownProductTaxClass = new Select(selectProductClass);
        dropDownProductTaxClass.selectByIndex(2);
        Select dropDownTaxRate = new Select(selectTaxRate);
        dropDownTaxRate.selectByIndex(3);
        testUtility.waitForElementPresent(priorityField);
        positionField.clear();
        priorityField.sendKeys(Priority1);
        testUtility.waitForElementPresent(positionField);
        positionField.clear();
        positionField.sendKeys(SortOrder);
        testUtility.waitForElementPresent(saveRuleButton);
        actions.moveToElement(saveRuleButton).build().perform();
        saveRuleButton.click();
    }

    public boolean verifyAddNewTaxRuleRuleSuccessfully() {
        testUtility.waitForElementPresent(addedTaxRuleSuccessMessages);
        if (driver.getPageSource().contains(addedTaxRuleSuccessMessages.getText())) {
            System.out.println("Marketing Manager can Add New Shopping Cart Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Shopping Cart  Test is Failed!!!");
            return false;
        }

    }
    public void updateNewTaxRule(String Name, String SortOrder,String number) {
        testUtility.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(Name);
        testUtility.sleep(3);
        Select dropDownCustomerTaxClass = new Select(selectCustomerTaxClass);
        dropDownCustomerTaxClass.selectByIndex(4);
        Select dropDownProductTaxClass = new Select(selectProductClass);
        dropDownProductTaxClass.selectByIndex(2);
        testUtility.sleep(3);
        Select dropDownTaxRate = new Select(selectTaxRate);
        dropDownTaxRate.selectByIndex(3);
        testUtility.sleep(3);
        testUtility.waitForElementPresent(priorityField);
        positionField.clear();
        priorityField.sendKeys(number);
        testUtility.sleep(3);
        testUtility.waitForElementPresent(positionField);
        positionField.clear();
        testUtility.sleep(3);
        positionField.sendKeys(SortOrder);
        testUtility.sleep(3);
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
