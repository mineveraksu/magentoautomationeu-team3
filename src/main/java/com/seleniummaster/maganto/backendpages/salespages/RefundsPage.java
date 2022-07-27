package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RefundsPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;


    @FindBy(css = "#store_switcher")
    WebElement showReportForField;
    @FindBy(css = "#sales_report_report_type")
    WebElement matchPeriodToField;
    @FindBy(css = "#sales_report_period_type")
    WebElement periodField;
    @FindBy(css = "#sales_report_from_trig")
    WebElement salesReportFromFrame;
    @FindBy(xpath = "//div[contains(text(),'«')]")
    WebElement navigateToLastYearButton;
    @FindBy(xpath = "(//div[contains(text(),'×')])[1]")
    WebElement closeIcon;
    @FindBy(css = "#sales_report_to_trig")
    WebElement salesReportToFrame;
    @FindBy(xpath = "//div[contains(text(),'»')]")
    WebElement getNavigateToNextYearButton;
    @FindBy(css = "#sales_report_show_order_statuses")
    WebElement ordersStatusField;
    @FindBy(css = "#sales_report_show_empty_rows")
    WebElement emptyRowsField;
    @FindBy(xpath = "(//span[contains(text(),'Show Report')])[2]")
    WebElement showReportButton;

    public RefundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void refundsReport(){
        testUtility.waitForElementPresent(showReportForField);
        actions.moveToElement(showReportForField).click().perform();
        Select select=new Select(showReportForField);
        select.selectByVisibleText("All Websites");
        System.out.println(" all choose");
        testUtility.waitForElementPresent(matchPeriodToField);
        Select select1=new Select(matchPeriodToField);
        select1.selectByVisibleText("Order Created Date");
        testUtility.waitForElementPresent(periodField);
        Select select2=new Select(periodField);
        select2.selectByVisibleText("Year");
        testUtility.waitForElementPresent(salesReportFromFrame);
        actions.moveToElement(salesReportFromFrame).click().perform();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(navigateToLastYearButton);
        actions.moveToElement(navigateToLastYearButton).click().perform();
        testUtility.waitForElementPresent(closeIcon);
        actions.moveToElement(closeIcon).click().perform();
        testUtility.waitForElementPresent(salesReportToFrame);
        actions.moveToElement(salesReportToFrame).click().perform();
//        testUtility.waitForElementPresent(getNavigateToNextYearButton);
//        actions.moveToElement(getNavigateToNextYearButton).click().perform();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(ordersStatusField);
        Select select3=new Select(ordersStatusField);
        select3.selectByVisibleText("Any");
        testUtility.waitForElementPresent(emptyRowsField);
        Select select4=new Select(emptyRowsField);
        select4.selectByVisibleText("No");
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();

    }

    public boolean verifyRefundsReportSuccessfulShow(){


        return true;
    }



}
