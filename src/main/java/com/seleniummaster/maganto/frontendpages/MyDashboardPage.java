package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = "li[class=\"current\"]>a strong")
    WebElement myOrdersLink;
    // for click account information
    @FindBy(linkText = "Account Information")
    WebElement accountInformationLink;
    @FindBy(css = "p.welcome-msg")
    WebElement loginVerifyMessage;



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


}

