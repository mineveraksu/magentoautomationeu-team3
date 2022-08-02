package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SalesPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    TestDataHolder testDataHolder;
    int rowCount;
    int rowSize;
    Select select;

    @FindBy(css = "#store_switcher")
    WebElement showReportForField;
    @FindBy(css = "#sales_report_report_type")
    WebElement matchPeriodToField;
    @FindBy(css = "#sales_report_period_type")
    WebElement periodField;
    @FindBy(css = "#sales_report_from")
    WebElement fromField;
    @FindBy(css = "#sales_report_to")
    WebElement toField;
    @FindBy(xpath = "(//button[@class=\"scalable \"])[1]")
    WebElement showReportButton;
    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement refundsLink;
    @FindBy(xpath = "//select[@id='sales_report_report_type']")
    WebElement matchPeriodToDropDown;
    @FindBy(xpath = "//select[@id='sales_report_period_type']")
    WebElement periodDropDown;


    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
        testDataHolder = new TestDataHolder();
    }

    public void seeTotalOrdersReport(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(showReportForField);
        Select select = new Select(showReportForField);
        select.selectByVisibleText("All Websites");
        Select select1 = new Select(matchPeriodToField);
        select1.selectByVisibleText("Order Created Date");
        Select select2 = new Select(periodField);
        select2.selectByVisibleText("Year");
        testUtility.waitForElementPresent(fromField);
        fromField.sendKeys(testDataHolder.getStartFrom());
        testUtility.waitForElementPresent(toField);
        toField.sendKeys(testDataHolder.getEndTo());
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();

    }

    public boolean verifyOrdersSaw() {
        List<WebElement> rows = driver.findElements(By.cssSelector(".data>tbody>tr"));
        rowCount = rows.size();
        if (rowCount >= 1) {
            System.out.println("Reporting manager see total order reports successful !");
            return true;
        } else {
            System.out.println("Reporting manager can not see total orders !");
            return false;
        }
    }

    // See texes rate report
    public void seeTaxesRateReport(String startedTime, String endedTime) {
        testUtility.waitForElementPresent(showReportForField);
        Select select1 = new Select(showReportForField);
        select1.selectByVisibleText("All Websites");
        Select select2 = new Select(matchPeriodToField);
        select2.selectByVisibleText("Order Created Date");
        Select select3 = new Select(periodField);
        select3.selectByVisibleText("Year");
        testUtility.waitForElementPresent(fromField);
        fromField.sendKeys(startedTime);
        testUtility.waitForElementPresent(toField);
        toField.sendKeys(endedTime);
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();
    }

    public boolean taxesReportSawVerify() {
        List<WebElement> rows = driver.findElements(By.cssSelector(".data>tbody>tr"));
        rowSize = rows.size();
        if (rowSize >= 1) {
            System.out.println(" Reporting manager can see taxes report ");
            return true;
        } else {
            System.out.println(" Reporting manager can not see taxes report ");
            return false;
        }

    }

    public void seeTotalRefundsReport(String fromDate, String toDate) {
        testUtility.waitForElementPresent(matchPeriodToField);
        Select select1 = new Select(matchPeriodToField);
        select1.selectByVisibleText("Order Created Date");
        Select select2 = new Select(periodField);
        select2.selectByVisibleText("Year");
        testUtility.waitForElementPresent(fromField);
        fromField.sendKeys(fromDate);
        testUtility.waitForElementPresent(toField);
        toField.sendKeys(toDate);
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();

    }
    public boolean verifyRefundsReportSuccessfullyShown(){
        List<WebElement> rows = driver.findElements(By.cssSelector(".data>tbody>tr"));
        rowSize = rows.size();
        if (rowSize >= 1) {
            System.out.println(" Reporting manager can see taxes report ");
            return true;
        } else {
            System.out.println(" Reporting manager can not see taxes report ");
            return false;
        }

    }





}

