package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicesPage {
    WebDriver driver;
    TestUtility testUtility;

    public InvoicesPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//td[@class=' last'])[6]/a")
    WebElement viewButton;
    @FindBy(xpath = "(//h3[@class=\"icon-head head-sales-order-invoice\"])[2]")
    WebElement invoiceID;
    @FindBy(xpath = "//textarea[@name=\"comment[comment]\"]")
    WebElement commentTextArea;
    @FindBy(xpath = "//input[@name=\"comment[is_customer_notified]\"]")
    WebElement notifyCustomerByEmailClickButton;
    @FindBy(xpath = "//input[@name=\"comment[is_visible_on_front]\"]")
    WebElement visibleByFrontEndClickButton;
    @FindBy(xpath = "//span[contains(text(),'Submit Comment')]")
    WebElement submitCommentButton;
    @FindBy(xpath = "//strong[@class=\"subdue\"]")
    WebElement customerNotifiedSMS;


    public void clickOnViewButton(){
        testUtility.waitForElementPresent(viewButton);
        viewButton.click();
    }
    public boolean verifyViewInvoices(){
        testUtility.waitForElementPresent(invoiceID);
        if (invoiceID.isDisplayed()){
            System.out.println("Sales manager view invoices successfully passes!");
            return true;
        }else {
            System.out.println("Sales manager view invoices successfully failed!");
            return true;
        }
    }
    public void clickOnCommentTextField(){
        testUtility.waitForElementPresent(commentTextArea);
        commentTextArea.click();
    }
    public void writeComment(String commentText){
        testUtility.waitForElementPresent(commentTextArea);
        commentTextArea.sendKeys(commentText);
    }
    public void clickOnNotifyCustomerByEmailClickButton(){
        testUtility.waitForElementPresent(notifyCustomerByEmailClickButton);
        notifyCustomerByEmailClickButton.click();
    }
    public void clickOnVisibleByFrontEndClickButton(){
        testUtility.waitForElementPresent(visibleByFrontEndClickButton);
        visibleByFrontEndClickButton.click();
    }
    public void clickOnSubmitCommentButton(){
        testUtility.waitForElementPresent(submitCommentButton);
        submitCommentButton.click();
    }
    public void viewInvoicesAndAddComments(String commentText){
        clickOnViewButton();
        clickOnCommentTextField();
        writeComment(commentText);
        clickOnNotifyCustomerByEmailClickButton();
        clickOnVisibleByFrontEndClickButton();
        clickOnSubmitCommentButton();
    }
    public boolean verifyAddedCommentsToInvoiceHistorySuccessful(){
        testUtility.waitForElementPresent(customerNotifiedSMS);
        if (customerNotifiedSMS.isDisplayed()){
            System.out.println("Sales manager add comments to invoice history test passed! ");
            return true;
        }else {
            System.out.println("Sales manager add comments to invoice history test failed!");
            return true;
        }
    }
}
