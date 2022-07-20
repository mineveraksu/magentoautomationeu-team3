package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

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

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
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
