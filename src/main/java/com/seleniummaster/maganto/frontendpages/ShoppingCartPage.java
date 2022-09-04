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

    @FindBy(xpath = "(//a[@title='View Details'])[1]")
    WebElement viewDetailsButton;
    @FindBy(id = "attribute92")
    WebElement colorDropDownList;
    @FindBy(id = "attribute180")
    WebElement sizeDropDownList;
    @FindBy(css = ".add-to-cart-buttons>button.button.btn-cart")
    WebElement addToCartButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessage;
    @FindBy(xpath = "//span[text()='Cart' ]")
    WebElement cartLink;
    @FindBy(xpath = "//a[@class=\"cart-link\"]")
    WebElement ViewShoppingCartLink;
    @FindBy(css = ".product-cart-actions>ul li a[title]")
    WebElement EditIcon;
    @FindBy(xpath = "//span[text()=\"Update Cart\"]")
    WebElement UpdateCARTLink;
    @FindBy(css = ".a-center.product-cart-remove.last>.btn-remove.btn-remove2")
    WebElement deleteCartButton;
    @FindBy(id = "qty")
    WebElement quantityField;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickCartLink() {
        testUtility.waitForElementPresent(cartLink);
        cartLink.click();
    }

    public void clickViewShoppingCartLink() {
        testUtility.waitForElementPresent(ViewShoppingCartLink);
        ViewShoppingCartLink.click();
    }

    public void clickEditIcon() {
        testUtility.waitForElementPresent(EditIcon);
        EditIcon.click();
    }


    public void clickUpdateCartLink() {
        testUtility.waitForElementPresent(UpdateCARTLink);
        UpdateCARTLink.click();
    }

    public void fillOutQuantityField() {
        testUtility.waitForElementPresent(quantityField);
        quantityField.sendKeys("2");
    }

    public void clickOnViewDetailsButton() {
        testUtility.waitForElementPresent(viewDetailsButton);
        viewDetailsButton.click();
    }

    public void selectColor() {
        testUtility.waitForElementPresent(colorDropDownList);
        colorDropDownList.click();
        Select select = new Select(colorDropDownList);
        select.selectByIndex(1);
    }


    public void selectSize(int index) {
        testUtility.waitForElementPresent(sizeDropDownList);
        Select select = new Select(sizeDropDownList);
        select.selectByIndex(index);
    }

    public void clickOnAddToCartButton() {
        testUtility.waitForElementPresent(addToCartButton);
        addToCartButton.click();
    }

    public void addProductsToCart() {
        clickOnViewDetailsButton();
        selectColor();
        selectSize(2);
        clickOnAddToCartButton();
    }

    public void addToCart() {
        clickOnAddToCartButton();
    }

    public boolean verifyProductsAddedToCart() {
        testUtility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("was added to your shopping cart.")) {
            System.out.println("Add products to shopping cart Test Passed !!");
            return true;
        } else {
            System.out.println("Add products to shopping cart Test Failed !!");
            return false;
        }
    }

    public void updateShoppingCart() {
        clickCartLink();
        clickViewShoppingCartLink();
        clickEditIcon();
        fillOutQuantityField();
        clickUpdateCartLink();
    }

    public boolean verifyUpdateShoppingCart() {
        testUtility.waitForElementPresent(successMessage);
        if (driver.getPageSource().contains(successMessage.getText()))
            System.out.println("Update shopping cart successfully");
        return true;
    }

}
