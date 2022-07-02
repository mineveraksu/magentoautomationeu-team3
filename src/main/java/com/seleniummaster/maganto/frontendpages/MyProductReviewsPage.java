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
    MyDashboardPage myDashboardPage;

    public MyProductReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/div/a/span[2]")
    WebElement cartLink;

    @FindBy(xpath = "//*[@id=\"cart-sidebar\"]/li[2]/div/a[1]")
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

    @FindBy(xpath = "//*[@id=\"review-form\"]/div[2]/button/span/span")
    WebElement submitReviewLink;

    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[1]/a")
    WebElement myAccountLink;


    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/a/span[2]")
    WebElement accountLink;

    @FindBy(css = ".block-content>ul>li:nth-child(7)")
    WebElement myProductReviewsLink;


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
