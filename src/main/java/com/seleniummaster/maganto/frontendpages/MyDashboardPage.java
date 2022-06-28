package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(css = "li[class=\"current\"]>a strong")
    WebElement myOrdersLink;

    @FindBy(css = "tr.first.odd > td.a-center.view.last > span > a:nth-child(1)")
    WebElement viewOrderLink;

    @FindBy(css = "div.page-title.title-buttons>h1")
    WebElement orderNumber;


    public void clickOnMyOrdersLink() {
        testUtility.waitForElementPresent(myOrdersLink);
        myOrdersLink.click();
    }

    public void clickOnViewOrderLink() {
        testUtility.waitForElementPresent(viewOrderLink);
        viewOrderLink.click();
    }



}

