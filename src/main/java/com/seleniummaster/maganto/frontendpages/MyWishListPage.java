package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishListPage {
    WebDriver driver;
    TestUtility testUtility;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy (id = "wishlist-view-form")
    WebElement myWishListForm;
    @FindBy(xpath = "//p[text()='You have no items in your wishlist.']")
    WebElement emptyWishList;

    public boolean viewMyWshList() {
        testUtility.waitForElementPresent(myWishListForm);
        if (myWishListForm.isDisplayed()||emptyWishList.isDisplayed()) {
            System.out.println("A User Should be Able to View my Wish List Test is Passed!");
           return true;
        }else  {
        System.out.println("A User Should be Able to view my Wish List Test is Failed!");
        return false;
    }
    }

}
