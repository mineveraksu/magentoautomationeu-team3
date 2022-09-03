package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupsPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "(//div[@class='content-header']//button)[1]")
    WebElement addNewCustomerGroupButton;
    @FindBy(id = "customer_group_code")
    WebElement groupNameField;
    @FindBy(id = "tax_class_id")
    WebElement taxClassDropDownList;
    @FindBy(xpath = "(//button[@class='scalable save']/span/span/span)[1]")
    WebElement saveCustomerGroupButton;
    @FindBy(xpath = "(//button[@class='scalable delete']/span/span/span)[1]")
    WebElement deleteCustomerGroupButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement SuccessMessage;

    public CustomerGroupsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickOnAddNewCustomerGroupButton() {
        testUtility.waitForElementPresent(addNewCustomerGroupButton);
        addNewCustomerGroupButton.click();
    }

    public void clickOnGroupNameField(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(groupNameField);
        groupNameField.sendKeys(testDataHolder.getCustomerGroupName()+System.currentTimeMillis());
    }

    public void clickOnTaxClassDropDownList() {
        testUtility.waitForElementPresent(taxClassDropDownList);
        taxClassDropDownList.click();
    }

    public void selectFromTaxClassDropDownList(int index) {
        Select select = new Select(taxClassDropDownList);
        select.selectByIndex(index);
    }

    public void clickOnSaveCustomerGroupButton() {
        testUtility.waitForElementPresent(saveCustomerGroupButton);
        saveCustomerGroupButton.click();
    }

    public void clickOnDeleteCustomerGroupButton() {
        testUtility.waitForElementPresent(deleteCustomerGroupButton);
        deleteCustomerGroupButton.click();
        testUtility.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnExistingCustomerGroup(TestDataHolder testDataHolder){
        WebElement existingGroupName=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",testDataHolder.getCustomerGroupName())));
        testUtility.waitForElementPresent(existingGroupName);
        existingGroupName.click();
    }

    public void addNewCustomerGroups(TestDataHolder testDataHolder) {
        clickOnAddNewCustomerGroupButton();
        clickOnGroupNameField(testDataHolder);
        clickOnTaxClassDropDownList();
        selectFromTaxClassDropDownList(1);
        clickOnSaveCustomerGroupButton();
    }

    public boolean verifyAddNewCustomerGroups() {
        //testUtility.waitForElementPresent(SuccessMessage);
        if (SuccessMessage.getText().contains("saved")) {
            System.out.println("Customer Manager add new customer groups Test Passed!! ");
            return true;
        } else {
            System.out.println("Customer Manager add new customer groups Test Failed!! ");
            return false;
        }
    }

    public void updateExistingCustomerGroups(TestDataHolder testDataHolder) {
        clickOnExistingCustomerGroup(testDataHolder);
        clickOnTaxClassDropDownList();
        selectFromTaxClassDropDownList(2);
        clickOnSaveCustomerGroupButton();
    }

    public boolean verifyUpdateExistingCustomerGroups() {
        testUtility.waitForElementPresent(SuccessMessage);
        if (SuccessMessage.getText().contains("saved")) {
            System.out.println("Customer Manager update existing customer groups Test Passed!! ");
            return true;
        } else {
            System.out.println("Customer Manager update existing customer groups Test Failed!! ");
            return false;
        }    }

    public void deleteExistingCustomerGroups(TestDataHolder testDataHolder) {
        clickOnExistingCustomerGroup(testDataHolder);
        clickOnDeleteCustomerGroupButton();
    }

    public boolean verifyDeleteExistingCustomerGroups() {
        testUtility.waitForElementPresent(SuccessMessage);
        if (SuccessMessage.getText().contains("deleted")) {
            System.out.println("Customer Manager delete existing customer groups Test Passed!! ");
            return true;
        } else {
            System.out.println("Customer Manager delete existing customer groups Test Failed!! ");
            return false;
        }
    }
}
