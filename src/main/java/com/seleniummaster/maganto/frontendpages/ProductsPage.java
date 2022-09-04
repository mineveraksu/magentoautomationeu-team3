package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//a[@title='Black Nolita Cami-Black-S']/img")
    WebElement productImage;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickProductImage(){
        testUtility.waitForElementPresent(productImage);
        productImage.click();
    }

}
