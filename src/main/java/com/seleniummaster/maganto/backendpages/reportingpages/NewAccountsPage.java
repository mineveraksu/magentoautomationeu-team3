package com.seleniummaster.maganto.backendpages.reportingpages;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewAccountsPage {
    WebDriver driver;
    TestUtility testUtility;
    Select select;

    @FindBy(id = "period_date_from")
    WebElement fromDateField;
    @FindBy(id="period_date_to")
    WebElement toDateField;
    @FindBy(css = "#report_period")
    WebElement showByDropDown;
    @FindBy(xpath = "//button[@title=\"Refresh\"]")
    WebElement refreshButton;
    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> newAccountsTable;


    public NewAccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void seeCustomersNewAccountsReport(String fromDate,String toDate){
        testUtility.waitForElementPresent(fromDateField);
        fromDateField.sendKeys(fromDate);
        testUtility.waitForElementPresent(toDateField);
        toDateField.sendKeys(toDate);
        testUtility.waitForElementPresent(showByDropDown);
        select=new Select(showByDropDown);
        select.selectByIndex(1);
        testUtility.waitForElementPresent(refreshButton);
        refreshButton.click();
    }
    public boolean verifySeeCustomersNewAccountsReport() {
        testUtility.waitForElementPresent(newAccountsTable.get(1));
        if (newAccountsTable.size() > 0) {
            System.out.println("Reporting Manager see Customers - New Accounts Report Test Passed");
            return true;
        } else {
            System.out.println("Reporting Manager see Customers - New Accounts Report Test Failed");
            return false;

        }
    }
}
