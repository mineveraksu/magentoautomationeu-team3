package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class StoreProductPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;


    @FindBy(css = "button[title='Add Product']")
    WebElement addProductButton;
    @FindBy(css = "select#attribute_set_id")
    WebElement attributeSetDropDown;
    @FindBy(id = "continue_button")
    WebElement continueButton;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(css = "textarea#description")
    WebElement descriptionField;
    @FindBy(css = "textarea#short_description")
    WebElement shortDescriptionFiled;
    @FindBy(xpath = "//input[@name='product[sku]']")
    WebElement SKUField;
    @FindBy(css = "input#weight")
    WebElement weightFiled;
    @FindBy(css = "select#status")
    WebElement statusDropDown;
    @FindBy(css = "select#visibility")
    WebElement visibilityDropdown;
    @FindBy(css = "a[title='Clothing']")
    WebElement clothingLink;
    @FindBy(css = "select#apparel_type")
    WebElement typeDropDown;
    @FindBy(css = "a[title='Prices']")
    WebElement pricesLink;
    @FindBy(css = "#price")
    WebElement priceField;
    @FindBy(xpath = "//select[@name='product[tax_class_id]']")
    WebElement taxClassDropDown;
    @FindBy(xpath = "//a[@title='Websites']")
    WebElement websiteLink;
    @FindBy(xpath = "//span[text()='Inventory']")
    WebElement inventoryLink;
    @FindBy(css = "#inventory_qty")
    WebElement qtyFiled;
    @FindBy(css = "select#inventory_stock_availability")
    WebElement stockAvailabilityDropDown;
    @FindBy(css = "button[title='Save']")
    WebElement saveButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement addProductSuccessMessage;

    //add product categories
@FindBy(xpath = "//a[@name=\"categories\"]")
WebElement categoriesLink;
@FindBy(xpath = "//span[contains(text(),\"Default Category\")]")
WebElement existingRootCategories;
@FindBy(xpath = "//span[contains(text(),\"VIP\")]")
WebElement existingSubCategories;
@FindBy(xpath = "//*[contains(text(),\"Jeans\")]")
WebElement addedProductLink;

//delete product categories
    @FindBy(xpath = "//span[contains(text(),\"VIP\")]")
    WebElement deletedCategory;
@FindBy(xpath = "//span[text()='Delete']")
WebElement deleteProductCategoryButton;
@FindBy(css = ".success-msg>ul li span")
WebElement deleteProductCategorySuccessfulMessage;



    public StoreProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void addProduct(TestDataHolder testDataHolder,String name, String description, String shortDescription, String SKU, String weight , String price, String qty) {
        testUtility.waitForElementPresent(addProductButton);
        addProductButton.click();
        testUtility.waitForElementPresent(continueButton);
        continueButton.click();
        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(name);
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(description);
        testUtility.waitForElementPresent(shortDescriptionFiled);
        shortDescriptionFiled.sendKeys(shortDescription);
        testUtility.waitForElementPresent(SKUField);
        SKUField.sendKeys(SKU);
        testUtility.waitForElementPresent(weightFiled);
        weightFiled.sendKeys(weight);
        testUtility.waitForElementPresent(statusDropDown);
        Select select2 = new Select(statusDropDown);
        select2.selectByValue("1");
        testUtility.waitForElementPresent(visibilityDropdown);
        Select select3 = new Select(visibilityDropdown);
        select3.selectByValue("4");
        testUtility.waitForElementPresent(pricesLink);
        testUtility.javaScriptClick(pricesLink);
        testUtility.waitForElementPresent(priceField);
        priceField.sendKeys(price);
        testUtility.waitForElementPresent(taxClassDropDown);
        Select select5=new Select(taxClassDropDown);
        select5.selectByValue("2");
        testUtility.waitForElementPresent(websiteLink);
        websiteLink.click();
        WebElement websiteCheckBox= driver.findElement(By.xpath(String.format("//label[text()='%s']//preceding::input[1]",testDataHolder.getWebsiteName())));
        testUtility.waitForElementPresent(websiteCheckBox);
        websiteCheckBox.click();
        testUtility.waitForElementPresent(inventoryLink);
        testUtility.javaScriptClick(inventoryLink);
        testUtility.waitForElementPresent(qtyFiled);
        qtyFiled.sendKeys(qty);
        testUtility.waitForElementPresent(stockAvailabilityDropDown);
        stockAvailabilityDropDown.click();
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();

    }

    public boolean verifyAddProductSuccessfully() {
        testUtility.waitForElementPresent(addProductSuccessMessage);
        if (driver.getPageSource().contains(addProductSuccessMessage.getText())){
            System.out.println("Store Manager can Add Product Test is Passed!!!");
            return true;
        }else {
            System.out.println("Store Manager can Add Product Test is Failed!!!");
            return false;
        }
    }

    public void addProductCategory(){
        testUtility.sleep(3);
        testUtility.waitForElementPresent(addedProductLink);
        addedProductLink.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
       testUtility.waitForElementPresent(existingRootCategories);
       existingRootCategories.click();
        testUtility.sleep(3);
       testUtility.waitForElementPresent(saveButton);
       saveButton.click();

    }
    public boolean verifyAddProductCategory() {
        testUtility.waitForElementPresent(addProductSuccessMessage);
        if (driver.getPageSource().contains(addProductSuccessMessage.getText())){
            System.out.println("Store Manager can Add Product Test is Passed!!!");
            return true;
        }else {
            System.out.println("Store Manager can Add Product Test is Failed!!!");
            return false;
        }
    }
    public void updateProductCategory(){
        testUtility.waitForElementPresent(addedProductLink);
        addedProductLink.click();
        testUtility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
       testUtility.waitForElementPresent(existingSubCategories);
       existingSubCategories.click();
        existingRootCategories.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();

    }
    public boolean verifyUpdateProductCategory() {
        testUtility.waitForElementPresent(addProductSuccessMessage);
        if (driver.getPageSource().contains(addProductSuccessMessage.getText())){
            System.out.println("Store Manager can Add Product Test is Passed!!!");
            return true;
        }else {
            System.out.println("Store Manager can Add Product Test is Failed!!!");
            return false;
        }
    }
    public void deleteProductCategory(){
        testUtility.waitForElementPresent(addedProductLink);
        addedProductLink.click();
        testUtility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
        testUtility.waitForElementPresent(deletedCategory);
       deletedCategory.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(deleteProductCategoryButton);
        deleteProductCategoryButton.click();

    }
    public boolean verifyDeleteProductCategory() {
        testUtility.waitForElementPresent(deleteProductCategorySuccessfulMessage);
        if (driver.getPageSource().contains(deleteProductCategorySuccessfulMessage.getText())){
            System.out.println("Store Manager can delete Product category Test is Passed!!!");
            return true;
        }else {
            System.out.println("Store Manager can delete Product category Test is Failed!!!");
            return false;
        }
    }
}