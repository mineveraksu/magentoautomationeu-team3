package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = ".block-content>ul>li:nth-child(4)")
    WebElement myOrdersLink;
    @FindBy(css = ".nav-primary>li.level0.nav-3.parent")
    WebElement saleLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]//ul//li[2]/a")
    WebElement accountInformationLink;

    @FindBy(css = "p.welcome-msg")
    WebElement loginVerifyMessage;

    @FindBy(xpath = "//a[text() = 'My Downloadable Products']")
    WebElement myDownloadableProductsLink;

//    @FindBy(css = ".block-content>ul>li:nth-child(7)")
//    WebElement myProductReviewsLink;



    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public boolean verifyLogin() {
        testUtility.waitForElementPresent(loginVerifyMessage);
        if (driver.getPageSource().contains(loginVerifyMessage.getText()))
            System.out.println("login successfully");
        return true;
    }
    public void clickOnMyOrdersLink() {
        testUtility.waitForElementPresent(myOrdersLink);
        myOrdersLink.click();
    }

    public void clickOnAccountInformationLink(){
        testUtility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }

    public void clickOnSaleLink(){
        testUtility.waitForElementPresent(saleLink);
        saleLink.click();
    }

    public void clickOnMyDownloadableProductsLink() {
        testUtility.waitForElementPresent(myDownloadableProductsLink);
        myDownloadableProductsLink.click();
    }

    //public void clickOnMyProductReviewsLink(){
       // testUtility.waitForElementPresent(myProductReviewsLink);
      //  myProductReviewsLink.click();
  //  }

    public MyDownloadableProductsPage clickMyDownloadableProductsLink() {
        testUtility.waitForElementPresent(myDownloadableProductsLink);
        myDownloadableProductsLink.click();
        return new MyDownloadableProductsPage(driver);
    }






}

