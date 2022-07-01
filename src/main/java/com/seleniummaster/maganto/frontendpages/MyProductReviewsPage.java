package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProductReviewsPage {

    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";

    public MyProductReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(linkText = "Cart")
    WebElement cartLink;

    @FindBy(linkText = "Edit item")
    WebElement editItemLink;

    @FindBy(linkText = "Add Your Review")
    WebElement addYourReviewLink;

    @FindBy(id = "Quality_3")
    WebElement qualityRadio;

    @FindBy(id = "Price_3")
    WebElement priceRadio;

    @FindBy(id = "Value_3")
    WebElement valueRadio;

    @FindBy(id = "review_field")
    WebElement reviewField;

    @FindBy(id = "summary_field")
    WebElement summaryField;

    @FindBy(linkText = "Submit Review")
    WebElement submitReviewLink;

    @FindBy(linkText = "My Product Reviews")
    WebElement myProductReviewsLink;

    @FindBy(linkText = "Account")
    WebElement accountLink;

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;


    public void openAddReviewsPage() {
        testUtility.waitForElementPresent(cartLink);
        cartLink.click();
        testUtility.waitForElementPresent(editItemLink);
        editItemLink.click();
        testUtility.waitForElementPresent(addYourReviewLink);
        addYourReviewLink.click();
    }

    public void addReview() {
        testUtility.waitForElementPresent(qualityRadio);
        qualityRadio.click();
        priceRadio.click();
        valueRadio.click();
        reviewField.sendKeys(ApplicationConfig
                .readFromConfigProperties(config, "myreviewcontent"));
        summaryField.sendKeys(ApplicationConfig.
                readFromConfigProperties(config, "myreviewcontent"));
        submitReviewLink.click();
    }

    public void clickOnMyProductLink() {
        testUtility.waitForElementPresent(accountLink);
        accountLink.click();
        testUtility.waitForElementPresent(myAccountLink);
        myAccountLink.click();
        testUtility.waitForElementPresent(myProductReviewsLink);
        myProductReviewsLink.click();
    }

    public void verifyMyProductReviewsLinkDisplay() {
        if (myProductReviewsLink.isDisplayed()) {
            System.out.println("MY PRODUCT REVIEWS link displayed successfully.");
        } else {
            System.out.println("MY PRODUCT REVIEWS link can not be displayed .");
        }
    }

    public void verifyMyProductReviewsContentsDisplayed() {
        if (driver.getPageSource().contains
                (ApplicationConfig.readFromConfigProperties
                        (config, "myreviewcontent"))) {
            System.out.println("Product reviews contents displayed.");
        } else {
            System.out.println("Product reviews contents can not be displayed.");
        }
    }
}
