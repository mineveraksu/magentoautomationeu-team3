package com.seleniummaster.maganto.backendpages.reportingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TagsPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    public TagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions = new Actions(driver);
    }


    @FindAll(@FindBy(css = "table[id=\"grid_table\"]>tbody>tr"))
    List<WebElement> customersTagsTable;

    @FindAll(@FindBy(css = "table[id=\"gridProducts_table\"]>tbody>tr"))
    List<WebElement> productsTagsTable;


    public boolean verifyOpenCustomersReportTags() {
        testUtility.waitForElementPresent(customersTagsTable.get(0));
        if (customersTagsTable.size() >= 1) {
            System.out.println("Reporting Manager able to see Products - Products  Report Test Passed!");
            return true;
        } else {
            System.out.println("Reporting Manager able to see Products - Products  Report Test Failed!!!");
            return false;
        }
    }


    public boolean verifyOpenProductsTags() {
        testUtility.waitForElementPresent(productsTagsTable.get(0));
        if (productsTagsTable.size()>=1){
            System.out.println("Reporting Manager able to see Tags - Products Report test Passed!");
            return true;
        } else {
            System.out.println("Reporting Manager not able to see Tags - Products Report test Failed!!");
            return false;
        }

    }
}

