package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;


public class SalesShipmentsPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "(//a[text()='View'])[18]")
    WebElement viewIcon;
    @FindBy(css = "textarea#history_comment")
    WebElement shipmentHistoryCommentField;
    @FindBy(css = "button[title='Submit Comment']")
    WebElement submitCommentButton;
    @FindBy(xpath = "//select[@name='carrier']")
    WebElement carrierDropDown;
    @FindBy(css = "input#tracking_title")
    WebElement titleField;
    @FindBy(css = "tracking_number")
    WebElement numberField;
    @FindBy(xpath = "//button[@title='Add']")
    WebElement addButton;
    @FindBy(xpath = "(//button[@class='scalable save'])[2]")
    WebElement sendTrackingInformationButton;


    public SalesShipmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void updateShipments(){
        testUtility.waitForElementPresent(viewIcon);
        viewIcon.click();
        testUtility.waitForElementPresent(shipmentHistoryCommentField);
        shipmentHistoryCommentField.sendKeys();
    }











}


