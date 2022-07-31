package com.seleniummaster.maganto.frontendpages;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterSubscriptionsPage {
    WebDriver driver;
    TestUtility testUtility;

    public NewsLetterSubscriptionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//*[@class=\"block-content\"]//li[11] ")
    WebElement newsLetterSubscriptionsLink;
    @FindBy(xpath = "//*[@class=\"page-title\"]//h1")
    WebElement newsLetterSubscriptionPage;

    public void newsLetterSubscription(){
        testUtility.waitForElementPresent(newsLetterSubscriptionsLink);
        newsLetterSubscriptionsLink.click();
    }

    public boolean verifyNewsLetterSubscription(){
        testUtility.waitForElementPresent(newsLetterSubscriptionPage);
        if(newsLetterSubscriptionPage.isDisplayed()){
            System.out.println("A User Can See NewsLetter Subscription Link And Contents ");
            return true;
        }

        else {
            System.out.println("A User Cannot See NewsLetter Subscription Link And Contents ");
            return false;
        }

    }


}
