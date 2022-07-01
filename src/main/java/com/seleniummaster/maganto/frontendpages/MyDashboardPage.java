package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ExcelUtility;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    ExcelUtility excelUtility;
    String excelFile = "Test-Data/addressBookData.xlsx";

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        excelUtility=new ExcelUtility();
    }

    @FindBy(css = "li[class=\"current\"]>a strong")
    WebElement myOrdersLink;
    // for click account information
    @FindBy(linkText = "Account Information")
    WebElement accountInformationLink;
    @FindBy(linkText = "Address Book")
    WebElement addressBookLink;
    @FindBy(css = ".success-msg")
    WebElement successMessage;
    @FindBy(xpath = "//*[@class=\"col-2 addresses-additional\"]")
    WebElement updatedAddressTable;


    public void clickOnMyOrdersLink() {
        testUtility.waitForElementPresent(myOrdersLink);
        myOrdersLink.click();
    }

    public void clickOnAccountInformationLink(){
        testUtility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }
    public void clickOnAddressBookLink(){
        testUtility.waitForElementPresent(addressBookLink);
        addressBookLink.click();
    }
    public boolean isAddressBookUpdatedSuccessful() {
        testUtility.waitForElementPresent(successMessage);
        System.out.println("success message "+"The address has been saved."+"is displayed");
        return successMessage.getText().contains("The address has been saved.");
    }
    public boolean isAddressBookUpdatedViewable() {
        testUtility.waitForElementPresent(updatedAddressTable);
        return  updatedAddressTable.getText().contains(excelUtility.
                readFromExcelCell(excelFile, "Address-Book", 1, 1));
    }

}

