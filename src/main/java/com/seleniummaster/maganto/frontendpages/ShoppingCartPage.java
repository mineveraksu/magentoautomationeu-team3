package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath ="//span[text()='Cart' ]" )
    WebElement cartLink;

    @FindBy(xpath ="//a[@class=\"cart-link\"]")
    WebElement ViewShoppingCartLink;

    //@FindBy(css = ".empty")  //xpath="//p[@class="empty"]"
   // WebElement emptyMessageDisplayed;

   // @FindBy(xpath ="td[@class = 'product-cart-actions']//a[text() = 'Edit']" )
    @FindBy(css =".product-cart-actions>ul li a[title]")
    WebElement EditIcon;

    @FindBy(xpath = "//span[text()=\"Update Cart\"]")
    WebElement UpdateCARTLink;

    @FindBy(css= ".success-msg>ul>li>span")
    WebElement SuccessMessageDisplayed;

    @FindBy(xpath = "//label[text() = 'Size']/parent::dt//following-sibling::dd//select")
    WebElement sizeSelector;

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

    public void selectSize(){
        testUtility.waitForElementPresent(sizeSelector);
        Select select = new Select(sizeSelector);
        select.selectByIndex(3);
    }

    public void clickUpdateCartLink(){
        testUtility.waitForElementPresent(UpdateCARTLink);
        UpdateCARTLink.click();

    }

    public void updateShoppingCart() {
        clickCartLink();
        clickViewShoppingCartLink();
        clickEditIcon();
        selectSize();
        clickUpdateCartLink();

    }

    public boolean verifyUpdateShoppingCart() {
        testUtility.waitForElementPresent(SuccessMessageDisplayed);
        if (driver.getPageSource().contains(SuccessMessageDisplayed.getText()))
            System.out.println("Update shopping cart successfully");
        return true;
    }




}
