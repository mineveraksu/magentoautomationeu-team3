package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCreditMemoPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "(//span[text()='Invoice'])[1]")
    WebElement invoiceButton;
    @FindBy(xpath = "//span[text()='Submit Invoice']")
    WebElement invoiceSubmitButton;
    @FindBy(xpath = "(//span[text()='Credit Memo'])[1]")
    WebElement creditMemoButton;
    @FindBy(xpath = "//span[text()='Refund Offline']")
    WebElement refundOfflineButton;
    @FindBy(css = "li.success-msg")//The credit memo has been created.
    WebElement successMessage;


    public AddCreditMemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void submitInvoice(){
        testUtility.waitForElementPresent(invoiceButton);
        invoiceButton.click();
        testUtility.waitForElementPresent(invoiceSubmitButton);
        invoiceSubmitButton.click();
    }
    public void addMemo(){
        testUtility.waitForElementPresent(creditMemoButton);
        creditMemoButton.click();
        testUtility.waitForElementPresent(refundOfflineButton);
        refundOfflineButton.click();
    }
    public void addCreditMemo(){
        submitInvoice();
        addMemo();
    }
    public boolean verifyAddedCreditMemo(){

        testUtility.waitForElementPresent(successMessage);

        return successMessage.getText().contains("The credit memo has been created.");
    }

}
