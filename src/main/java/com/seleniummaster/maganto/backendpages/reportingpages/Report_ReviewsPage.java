package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Report_ReviewsPage {
    WebDriver driver;
    TestUtility testUtility;

    public Report_ReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
this is me
    @FindAll(@FindBy(css = "table[id=\"gridProducts_table\"]>tbody>tr"))
    List<WebElement> productReviewReportTable;

    public boolean verifyProductReviewReportSuccessfullyDisplayed() {
        testUtility.waitForElementPresent(productReviewReportTable.get(1));
        if(productReviewReportTable.size()>=1) {
            System.out.println("Reporting Manager see Products Review Report- Test Passed!");
            return true;
        }else {
            System.out.println("Reporting Manager see Products Review Report- Test Failed!!!");
            return false;
        }
    }
}
