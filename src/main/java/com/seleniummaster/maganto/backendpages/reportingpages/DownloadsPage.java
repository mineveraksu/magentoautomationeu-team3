package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DownloadsPage {
    WebDriver driver;
    TestUtility testUtility;

    public DownloadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> downloadsTable;

    public boolean verifyViewSalesInvoicedVsPaidReportSuccessfully() {
        testUtility.waitForElementPresent(downloadsTable.get(1));
        if(downloadsTable.size()>=1) {
            System.out.println("Reporting Manager see Products - Products Downloads Report Test Passed!");
            return true;
        }else {
            System.out.println("Reporting Manager see Products - Products Downloads Report Test Failed!!!");
            return false;
        }
    }
}
