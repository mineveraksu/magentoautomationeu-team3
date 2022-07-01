package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalePage {
    WebDriver driver;
    TestUtility testUtility;

    public SalePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "(//a[@title='View Details'])[1]")
    WebElement viewDetailsButton;
    @FindBy(id = "attribute92")
    WebElement colorDropDownList;
    @FindBy(id = "attribute180")
    WebElement sizeDropDownList;
    @FindBy(css = ".add-to-cart-buttons>button.button.btn-cart")
    WebElement addToCartButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement addedToCardSuccessMessage;

    public void addProductsToCart(){
        testUtility.waitForElementPresent(viewDetailsButton);
        viewDetailsButton.click();
        testUtility.waitForElementPresent(colorDropDownList);
        colorDropDownList.click();
        Select select=new Select(colorDropDownList);
        select.selectByIndex(1);
        testUtility.waitForElementPresent(sizeDropDownList);
        Select select1=new Select(sizeDropDownList);
        sizeDropDownList.click();
        select1.selectByIndex(3);
        addToCartButton.click();
    }

    public boolean verifyProductsAddedToCart(){
        testUtility.waitForElementPresent(addedToCardSuccessMessage);
        if(addedToCardSuccessMessage.getText().contains("was added to your shopping cart.")){
            System.out.println("Add products to shopping cart Test Passed !!");
            return true;
        }else{
            System.out.println("Add products to shopping cart Test Failed !!");
            return false;
        }

    }
}
