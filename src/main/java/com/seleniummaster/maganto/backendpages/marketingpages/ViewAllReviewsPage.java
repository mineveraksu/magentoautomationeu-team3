package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewAllReviewsPage {
    WebDriver driver;
    TestUtility testUtility;

    public ViewAllReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindAll(

            @FindBy(xpath = "//tr[@class='even pointer'] [1]")
    )
    List<WebElement> pendingReviews;

    @FindBy(css = "div#anchor-content")
    WebElement allPendingViews;

    public boolean verifyViewPendingReviewsSuccessfully() {
         testUtility.waitForElementPresent(allPendingViews);
        if (pendingReviews.size() > 0) {
            System.out.println("Marketing Manager can view pending Reviews Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can view pending Reviews Test is Failed!!!");
            return false;
        }
    }
}