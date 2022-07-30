package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;

    @FindBy(xpath = "(//span[contains(text(),'Search')])[3]")
    WebElement searchButton;
    @FindBy(css = "#productGrid_product_filter_name")
    WebElement nameField;
    @FindBy(xpath = "//tr[@class=\"even pointer\"]//td[3]")
    WebElement productName;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[contains(text(),'The product has been deleted.')]")
    WebElement deleteSuccessfulMassage;

    @FindBy(xpath = "(//span[contains(text(),\"Add Product\")])[1]")
    WebElement addProductsLink;
    @FindBy(id = "attribute_set_id")
    WebElement attributeSetSelectField;
    @FindBy(id = "product_type")
    WebElement productTypeSelectField;
    @FindBy(xpath = "//span[contains(text(),\"Continue\")]")
    WebElement continueButton;
    @FindBy(id = "name")
    WebElement productNameField;
    @FindBy(id = "description")
    WebElement descriptionField;
    @FindBy(id = "short_description")
    WebElement shortDescriptionField;
    @FindBy(id = "sku")
    WebElement skuField;
    @FindBy(id = "weight")
    WebElement weightField;
    @FindBy(id = "status")
    WebElement statusSelectionField;
    @FindBy(id = "visibility")
    WebElement visibilitySelectionField;
    @FindBy(xpath = "//button[@title=\"Save\"]")
    WebElement saveButton;
    @FindBy(id = "price")
    WebElement priceField;
    @FindBy(id = "tax_class_id")
    WebElement taxClassSelectionField;
    @FindBy(xpath = "(//span[contains(text(),\"Save\")])[1]")
    WebElement priceSaveButton;
    @FindBy(id="shoe_type")
    WebElement shoesTypeField;
    @FindBy(css = "li.success-msg")
    WebElement productSavedSuccessfulSMS;
    @FindBy(xpath = "(//a[contains(text(),\"Edit\")])[2]")
    WebElement editIcon;
    @FindBy(id = "country_of_manufacture")
    WebElement countryManufacturerSelection;
    @FindBy(xpath = "(//span[contains(text(),\"Save\")])[1]")
    WebElement editProductsSaveButton;


    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void addProduct(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(addProductsLink);
        addProductsLink.click();
        testUtility.waitForElementPresent(attributeSetSelectField);
        select=new Select(attributeSetSelectField);
        select.selectByValue("18");
        testUtility.waitForElementPresent(productTypeSelectField);
        select=new Select(productTypeSelectField);
        select.selectByValue("simple");
        testUtility.waitForElementPresent(continueButton);
        continueButton.click();
        testUtility.waitForElementPresent(productNameField);
        productNameField.sendKeys(testDataHolder.getProductName());
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(testDataHolder.getProductDescription());
        testUtility.waitForElementPresent(shortDescriptionField);
        shortDescriptionField.sendKeys(testDataHolder.getShortDescription());
        testUtility.waitForElementPresent(skuField);
        skuField.sendKeys(testDataHolder.getSKU());
        testUtility.waitForElementPresent(weightField);
        weightField.sendKeys(testDataHolder.getWeight());
        testUtility.waitForElementPresent(statusSelectionField);
        select=new Select(statusSelectionField);
        select.selectByValue("1");
        testUtility.waitForElementPresent(visibilitySelectionField);
        select=new Select(visibilitySelectionField);
        select.selectByValue("2");
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
        testUtility.waitForElementPresent(priceField);
        priceField.sendKeys(testDataHolder.getPrice());
        testUtility.waitForElementPresent(taxClassSelectionField);
        select=new Select(taxClassSelectionField);
        select.selectByValue("0");
        testUtility.waitForElementPresent(priceSaveButton);
        priceSaveButton.click();
        testUtility.waitForElementPresent(shoesTypeField);
        select=new Select(shoesTypeField);
        select.selectByValue("113");
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public void editProducts(){
        testUtility.waitForElementPresent(editIcon);
        editIcon.click();
        testUtility.waitForElementPresent(countryManufacturerSelection);
        select=new Select(countryManufacturerSelection);
        select.selectByValue("NL");
        testUtility.waitForElementPresent(editProductsSaveButton);
        editProductsSaveButton.click();
    }
    public boolean verifyProductEditSuccessful(){
        testUtility.waitForElementPresent(productSavedSuccessfulSMS);
        if (productSavedSuccessfulSMS.getText().contains("saved.")){
            System.out.println("Catalog manager edit product test Passed!");
            return true;
        }else {
            System.out.println("Catalog manager edit product test failed");
            return false;
        }
    }
    public boolean verifyProductAddedSuccessfully(){
        testUtility.waitForElementPresent(productSavedSuccessfulSMS);
        if (productSavedSuccessfulSMS.getText().contains("saved.")){
            System.out.println("Catalog manager add product test Passed!");
            return true;
        }else {
            System.out.println("Catalog manager add product test failed");
            return false;
        }


    }
    public void deleteProduct(){
        searchButton.click();
        testUtility.sleep(3);
        nameField.sendKeys("Baby clothing");
        testUtility.sleep(2);
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        System.out.println(" Baby clothing");
        testUtility.sleep(3);
        testUtility.waitForElementPresent(productName);
        productName.click();
        System.out.println(" Products name  clicked and go to deleted page");
        testUtility.sleep(2);
        testUtility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("delete button clicked ");
    }

    public boolean verifyDeleteProduct(){
        testUtility.waitForElementPresent(deleteSuccessfulMassage);
        if(driver.getPageSource().contains(deleteSuccessfulMassage.getText())){
            System.out.println(" Delete product successfully !!! ");
        }
        return true;
        }
}
