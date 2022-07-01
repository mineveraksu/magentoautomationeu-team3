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

    @FindAll(

            @FindBy(css = "tr.first.odd")
    )
    List<WebElement> myOrders;

    @FindBy(css = "div.my-account")
    WebElement allOrderTable;

    public boolean viewOrders() {
        testUtility.waitForElementPresent(allOrderTable);
        if (myOrders.size() > 0) {
            System.out.println("A User Should be Able to View his/her Orders Test is Passed!");
            return true;
        }else{
            System.out.println("A User Should be Able to View his/her Orders Test is Failed!");
            return false;
        }

    }

}