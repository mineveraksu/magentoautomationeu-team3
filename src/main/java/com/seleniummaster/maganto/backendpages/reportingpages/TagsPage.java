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

    @FindBy(xpath = "(//span[contains(text(),'Reports')])[1]")
    WebElement reportsLink;

    @FindBy(xpath = "(//span[contains(text(),'Tags')])")
    WebElement tagsLink;

    @FindBy(xpath = "(//span[text()='Customers'])[1]")
    WebElement customersLink;

    @FindBy(xpath = "(//span[text()='Products'])[1]")
    WebElement productsLink;

    //@FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    // WebElement customersTagsTitle;

    // @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    // WebElement productsTagsTitle;

    @FindAll(@FindBy(css = "table[id=\"customers_grid_table\"]>tbody>tr"))
    List<WebElement> customersTagsTable;

    @FindAll(@FindBy(css = "table[id=\"customers_grid_table\"]>tbody>tr"))
    List<WebElement> productsTagsTable;

    public void openCustomersTags() {

        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(tagsLink);
        actions.moveToElement(tagsLink).click().perform();
        testUtility.waitForElementPresent(customersLink);
        actions.moveToElement(customersLink).click().perform();
    }

    public boolean verifyOpenCustomersReportTags() {
        testUtility.waitForElementPresent(customersTagsTable.get(0));
        if (customersTagsTable.size() > 0) {
            System.out.println("Reporting Manager see Products - Products Downloads Report Test Passed!");
            return true;
        } else {
            System.out.println("Reporting Manager see Products - Products Downloads Report Test Failed!!!");
            return false;
        }
    }

    public void openProductsTags() {
        testUtility.waitForElementPresent(reportsLink);
        actions.moveToElement(reportsLink).perform();
        testUtility.waitForElementPresent(tagsLink);
        actions.moveToElement(tagsLink).perform();
        testUtility.waitForElementPresent(productsLink);
        productsLink.click();
    }

    public boolean verifyOpenProductsTags() {
        testUtility.waitForElementPresent(productsTagsTable.get(0));
        if (productsTagsTable.size()>0) {
            System.out.println("Reporting Manager able to see Tags - Products Report");
            return true;
        } else {
            System.out.println("Reporting Manager not able to see Tags - Products Report");
            return false;
        }

    }
}

