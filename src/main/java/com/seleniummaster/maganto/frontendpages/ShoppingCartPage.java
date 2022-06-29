package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath ="//span[text()='Cart' ]" )
    WebElement cartLink;

    @FindBy(xpath ="//a[@class=\"cart-link\"]")
    WebElement ViewShoppingCartLink;

    @FindBy(css = ".empty")  //xpath="//p[@class="empty"]"
    WebElement emptyMessageDisplayed;

    @FindBy(xpath ="td[@class = 'product-cart-actions']//a[text() = 'Edit']" )
    WebElement EditIcon;

    @FindBy(xpath = "//span[text()=\"Update Cart\"]")
    WebElement UpdateCARTLink;

    @FindBy(linkText = "Body Wash with Lemon Flower Extract and Aloe Vera was updated in your shopping cart.")
    WebElement SuccessMessageDisplayed;

    //create constructor
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickCartLink(){
        testUtility.waitForElementPresent(cartLink);
        cartLink.click();
    }
    public void clickViewShoppingCartLink(){
        testUtility.waitForElementPresent(ViewShoppingCartLink);
        ViewShoppingCartLink.click();
    }
    public void clickEditIcon(){
       testUtility.waitForElementPresent(EditIcon);
        EditIcon.click();
    }
    // public void inputQTYBox(int QTY_Number){
    // functionPage.waitUntilElementIsPresent(QTY_input,30);
    //  QTY_input.sendKeys("3");

    // }
    public void clickUpdateCartLink(){
        testUtility.waitForElementPresent(UpdateCARTLink);
        UpdateCARTLink.click();

    }

    public void updateShoppingCart(){
        clickCartLink();
        clickViewShoppingCartLink();
        clickEditIcon();
        //inputQTYBox(3);
        clickUpdateCartLink();

    }

    public boolean verifyUpdateShoppingCart() {
        testUtility.waitForElementPresent(SuccessMessageDisplayed);
        if (driver.getPageSource().contains(SuccessMessageDisplayed.getText()))
            System.out.println("Update shopping cart successfully");
        return true;
    }


}
