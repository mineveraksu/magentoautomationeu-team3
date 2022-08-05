package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PopularPage {
    WebDriver driver;
    TestUtility testUtility;

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindAll(@FindBy(css = "table[id=\"grid_table\"]>tbody>tr"))
    List<WebElement> popularReportTable;

    public boolean verifyPopularReportDisplayed() {
        testUtility.waitForElementPresent(popularReportTable.get(1));
        if(popularReportTable.size()>=1) {
            System.out.println("Reporting Manager see Tags_popular Report- Test Passed!");
            return true;
        }else {
            System.out.println("Reporting Manager see Tags_popular Report- Test Failed!!!");
            return false;
        }
    }
}
