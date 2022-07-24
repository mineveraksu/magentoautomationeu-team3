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

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[11]/a")
    WebElement newsLetterSubscriptionsLink;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div/h1")
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
