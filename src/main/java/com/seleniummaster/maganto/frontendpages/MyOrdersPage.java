package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MyOrdersPage {
    WebDriver driver;
    TestUtility testUtility;

    public MyOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(css = "tr.first.odd > td.a-center.view.last > span > a:nth-child(1)")
    WebElement viewOrderLink;

    @FindAll(

            @FindBy(css = "div.page-title.title-buttons>h1")
    )
    List<WebElement> orderNumber;

    @FindBy(css = "div.my-account")
    WebElement allOrderTable;

    public void clickOnViewOrderLink() {
        testUtility.waitForElementPresent(viewOrderLink);
        viewOrderLink.click();
    }

    public boolean viewOrders() {
        testUtility.waitForElementPresent(allOrderTable);
        if (orderNumber.size() > 0)
            System.out.println("A User Should be Able to View his/her Orders test passed");
        return true;
    }



}