package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BestsellersPage  {


    WebDriver driver;
    TestUtility testUtility;
    Actions actions;



    public BestsellersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/a/span")
    WebElement ReportsButton;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/ul/li[3]/a/span")
    WebElement productButton;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/ul/li[3]/ul/li[1]/a/span")
    WebElement bestsellersLink;
    @FindBy(xpath = "//*[@id=\"sales_report_period_type\"]")
    WebElement PeriodField;
    @FindBy(xpath = "//*[@id=\"sales_report_from\"]")
    WebElement fromField;
    @FindBy(xpath = "//*[@id=\"sales_report_to\"]")
    WebElement toField;
    @FindBy(xpath ="(//button[@title=\"Show Report\"])[1]")
    WebElement clickShowReportsButton;
    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> bestsellersTable;

    public void seeProductsBestsellersReport(String fromDate, String toDate) {
        testUtility.waitForElementPresent(ReportsButton);
        ReportsButton.click();
        testUtility.waitForElementPresent(productButton);
        productButton.click();
        testUtility.waitForElementPresent(bestsellersLink);
        bestsellersLink.click();
        testUtility.waitForElementPresent(PeriodField);
        Select select = new Select(PeriodField);
        testUtility.sleep(3);
        select.selectByVisibleText("Year");
        testUtility.waitForElementPresent(fromField);
        testUtility.sleep(3);
        fromField.sendKeys(fromDate);
        testUtility.waitForElementPresent(toField);
        testUtility.sleep(3);
        toField.sendKeys(toDate);
        testUtility.waitForElementPresent(clickShowReportsButton);
        testUtility.sleep(2);
       // actions.moveToElement(clickShowReportsButton).perform();
        clickShowReportsButton.click();
        testUtility.sleep(3);



    }

    public boolean verifyProductsBestsellersReport() {
        testUtility.waitForElementPresent(bestsellersTable.get(1));
        if(bestsellersTable.size()>=1) {
            System.out.println("Reporting Manager see Products - Products Bestsellers Report Test Passed!");
            return true;
        }else {
            System.out.println("Reporting Manager see Products - Products Bestsellers Report Test Failed!!!");
            return false;
        }
    }
}
