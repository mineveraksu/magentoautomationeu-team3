package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreOrdersPage {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;


    @FindBy(xpath ="(//span[text()=\"Edit\"])[1]")
    WebElement editButton;
    @FindBy(xpath = "//input[@id=\"order-billing_address_postcode\"]")
    WebElement zipCodeField;
    @FindBy(xpath = "//input[@id=\"order-billing_address_telephone\"]")
    WebElement telephoneField;
    @FindBy(xpath ="//div[@class=\"order-totals-bottom\"]//p[3]//button//span[text()=\"Submit Order\"]")
    WebElement submitOrderButton;//cancel
    @FindBy(xpath ="//span[text()='The order has been created.']")
    WebElement verifyOrderSuccessfulEdited;


    //Store Manager can edit orders
    //Store Manager can cancel orders
    public StoreOrdersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void editOrderInformation(){
        testUtility.waitForElementPresent(editButton);
        actions.moveToElement(editButton).click().perform();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        testUtility.waitForElementPresent(zipCodeField);
        zipCodeField.clear();
        zipCodeField.sendKeys(testUtility.generateZipCode());
        testUtility.waitForElementPresent(telephoneField);
        telephoneField.clear();
        telephoneField.sendKeys(testUtility.generateTelephoneNumber());
        testUtility.sleep(2);
        //testUtility.waitForElementPresent(submitOrderButton);
        actions.moveToElement(submitOrderButton).click().perform();
        System.out.println(" submit button clicked ");
        testUtility.sleep(3);
    }

    public boolean verifyOrderEdited(){
        testUtility.waitForElementPresent(verifyOrderSuccessfulEdited);
        if(verifyOrderSuccessfulEdited.getText().contains("created.")){
            System.out.println(" Store manager edit order successful !");
            return true;
        }else{
            System.out.println("Store manager edit order failed ! ");
            return false;
        }
    }













}
