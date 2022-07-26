package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsMostViewedPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";
    Select select;
    int reportRowSize;

    public ProductsMostViewedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(id = "sales_report_period_type")
    WebElement periodDropdown;
    @FindBy(id = "sales_report_from")
    WebElement startDate;
    @FindBy(id="sales_report_to")
    WebElement endDate;
    @FindBy(xpath = "(//span[contains(text(),\"Show Report\")])[1]")
    WebElement showReportsButton;
    public void viewProductsMostViewedReport(){
    testUtility.waitForElementPresent(periodDropdown);
    select=new Select(periodDropdown);
    select.selectByValue("month");
    testUtility.waitForElementPresent(startDate);
    startDate.sendKeys(ApplicationConfig.readFromConfigProperties(config,"startDate"));
    testUtility.waitForElementPresent(endDate);
    endDate.sendKeys(ApplicationConfig.readFromConfigProperties(config,"endDate"));
    testUtility.waitForElementPresent(showReportsButton);
    showReportsButton.click();
}
    public boolean verifyMostViewedProductsDisplayed(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportRowSize=rows.size();
        return reportRowSize>0;
    }
}
