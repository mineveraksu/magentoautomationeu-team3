package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BestsellersPage  {


    WebDriver driver;
    TestUtility testUtility;


    public BestsellersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }
    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> bestsellersTable;

    public boolean verifyProductsBestsellersReport() {
        testUtility.waitForElementPresent(bestsellersTable.get(1));
        if(bestsellersTable.size()>=0) {
            System.out.println("Reporting Manager see Products - Products Bestsellers Report Test Passed!");
            return true;
        }else {
            System.out.println("Reporting Manager see Products - Products Bestsellers Report Test Failed!!!");
            return false;
        }
    }
}
