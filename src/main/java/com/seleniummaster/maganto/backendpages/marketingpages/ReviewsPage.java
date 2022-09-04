package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ReviewsPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;
    int allReviewsRowSize;


    @FindBy(xpath = "//td[contains(text(),'team33')]//following-sibling::td[6]/a")
    WebElement editButton;
    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    WebElement editIcon;
    @FindBy(id = "detail")
    WebElement reviewField;
    @FindBy(xpath = "(//button[@id=\"save_button\"])[1]")
    WebElement saveReviewButton;
    @FindBy(css = "li.success-msg>ul>li>span")//The review has been saved.
    WebElement reviewSuccessfulAddedSMS;
    @FindBy(xpath = "//input[@id=\"Quality_5\"]")
    WebElement qualityRadioButton;
    @FindBy(xpath = "//input[@id=\"Price_1\"]")
    WebElement priceRadioButton;
    @FindBy(xpath = "//input[@id=\"Value_2\"]")
    WebElement valueRadioButton;
    @FindBy(xpath = "//select[@id=\"status_id\"]")
    WebElement statusSelectField;
    @FindBy(css = "#select_stores")
    WebElement visibleInField;
    @FindBy(css = "#nickname")
    WebElement nickNameField;
    @FindBy(css = "#title")
    WebElement summaryOfReviewField;
    @FindBy(xpath = "//span[text()='The review has been saved.']")
    WebElement updateReviewSuccessfulMassage;

    public ReviewsPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void clickOnEditButton() {
        testUtility.waitForElementPresent(editButton);
        editButton.click();
    }

    public void clickOnEditIcon() {
        testUtility.waitForElementPresent(editIcon);
        editIcon.click();
        testUtility.sleep(3);
    }


    public void clearReviewField() {
        testUtility.waitForElementPresent(reviewField);
        reviewField.clear();
    }

    public void editNewReview(String review) {
        testUtility.waitForElementPresent(reviewField);
        reviewField.sendKeys(review);
    }

    public void clickOnSaveReviewButton() {
        testUtility.waitForElementPresent(saveReviewButton);
        saveReviewButton.click();
    }

    public void updateExistingReview(String review) {
        clickOnEditButton();
        clearReviewField();
        editNewReview(review);
        clickOnSaveReviewButton();
    }

    public boolean verifyReviewEdit() {
        testUtility.waitForElementPresent(reviewSuccessfulAddedSMS);
        if (reviewSuccessfulAddedSMS.getText().contains("saved.")) {
            System.out.println("marketing manager edit existing review test passed!");
            return true;
        } else {
            System.out.println("marketing manager edit existing review test failed");
            return false;
        }
    }

    //ViewPendingReviews
    @FindBy(id = "reviwGrid")
    WebElement pendingViews;

    public boolean verifyViewPendingReviewsSuccessfully() {
        testUtility.waitForElementPresent(pendingViews);
        if (pendingViews.isDisplayed()) {
            System.out.println("Marketing Manager can view pending Reviews Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can view pending Reviews Test is Failed!!");
            return false;
        }
    }

    public void updatePendingReview() {
//        testUtility.sleep(2);
//        testUtility.waitForElementPresent(qualityRadioButton);
//        actions.moveToElement(qualityRadioButton).click().perform();
//        testUtility.waitForElementPresent(priceRadioButton);
//        actions.moveToElement(priceRadioButton).click().perform();
//        testUtility.waitForElementPresent(valueRadioButton);
//        actions.moveToElement(valueRadioButton).click().perform();
//        testUtility.waitForElementPresent(statusSelectField);
//        select = new Select(statusSelectField);
//        select.selectByIndex(2);
//        testUtility.waitForElementPresent(visibleInField);
//        select = new Select(visibleInField);
//        select.selectByIndex(2);
        testUtility.waitForElementPresent(nickNameField);
        nickNameField.clear();
        nickNameField.sendKeys(testUtility.generateFirstName());
        testUtility.waitForElementPresent(summaryOfReviewField);
        summaryOfReviewField.clear();
        summaryOfReviewField.sendKeys(testUtility.generateMiddleName());
        testUtility.waitForElementPresent(reviewField);
        reviewField.clear();
        reviewField.sendKeys(testUtility.generateMiddleName());
        testUtility.sleep(2);
        testUtility.waitForElementPresent(saveReviewButton);
        actions.moveToElement(saveReviewButton).click().perform();
    }

    public boolean verifyReviewUpdateSuccessful() {
        testUtility.waitForElementPresent(updateReviewSuccessfulMassage);
        if (updateReviewSuccessfulMassage.getText().contains("The review has been saved.")) {
            System.out.println(" Marketing module update review successful !");

            return true;
        } else {
            System.out.println(" Marketing module update review fail !");
            return false;
        }
    }

    //View All Reviews
    public boolean verifyViewAllReviewsSuccessfully() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table.data>tbody>tr"));
        allReviewsRowSize = rows.size();
        if (allReviewsRowSize > 0) {
            System.out.println("Marketing Manager can view all Reviews Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can view all Reviews Test is Failed!!");
            return false;
        }

    }
}


