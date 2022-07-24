package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewsPage {
    WebDriver driver;
    TestUtility testUtility;


    @FindBy(xpath = "//td[contains(text(),'team33')]//following-sibling::td[6]/a")
    WebElement editButton;
    @FindBy(id="detail")
    WebElement reviewField;
    @FindBy(xpath = "(//button[@id=\"save_button\"])[1]")
    WebElement saveReviewButton;
    @FindBy(css = "li.success-msg>ul>li>span")//The review has been saved.
    WebElement reviewSuccessfulAddedSMS;

    public ReviewsPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickOnEditButton(){
        testUtility.waitForElementPresent(editButton);
        editButton.click();
    }
    public void clearReviewField(){
        testUtility.waitForElementPresent(reviewField);
        reviewField.clear();
    }
    public void editNewReview(String review){
        testUtility.waitForElementPresent(reviewField);
        reviewField.sendKeys(review);
    }
    public void clickOnSaveReviewButton(){
        testUtility.waitForElementPresent(saveReviewButton);
        saveReviewButton.click();
    }
    public void updateExistingReview(String review){
        clickOnEditButton();
        clearReviewField();
        editNewReview(review);
        clickOnSaveReviewButton();
    }
    public boolean verifyReviewEdit(){
        testUtility.waitForElementPresent(reviewSuccessfulAddedSMS);
        if (reviewSuccessfulAddedSMS.getText().contains("saved.")){
            System.out.println("marketing manager edit existing review test passed!");
            return true;
        }else {
            System.out.println("marketing manager edit existing review test failed");
            return false;
        }
    }
}
