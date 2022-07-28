package com.seleniummaster.maganto.backendpages.salespages;

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

public class RefundsPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    int reportsSize;

    @FindBy(css = "#store_switcher")
    WebElement showReportForField;
    @FindBy(css = "#sales_report_report_type")
    WebElement matchPeriodToField;
    @FindBy(css = "#sales_report_period_type")
    WebElement periodField;
    @FindBy(css = "#sales_report_from")
    WebElement startFrom;
    @FindBy(css = "#sales_report_to")
    WebElement endTo;
    @FindBy(xpath = "(//span[contains(text(),'Show Report')])[1]")
    WebElement showReportButton;

    public RefundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }


    public void refundsReport(TestDataHolder testDataHolder){
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
        testUtility.waitForElementPresent(startFrom);
        startFrom.sendKeys(testDataHolder.getStartFrom());
        testUtility.waitForElementPresent(endTo);
        endTo.sendKeys(testDataHolder.getEndTo());
        testUtility.sleep(2);
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();
        System.out.println(" clicked showReportButton");
        testUtility.sleep(2);



    }

    public boolean verifyRefundsReportSuccessfulShow(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportsSize= rows.size();
        if(reportsSize>=1){
            System.out.println("Refunds reports showed !");
            return  true;
        }else{
            System.out.println("Refunds have not founded !");
            return false;
        }
    }



}
