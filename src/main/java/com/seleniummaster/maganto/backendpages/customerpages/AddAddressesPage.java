package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressesPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;

    @FindBy(xpath = "(//div[@class=\"multi-input\"]//input[@class=\"input-text required-entry\"])[2]")
    WebElement streetAddressField;
    @FindBy(xpath = "(//div[@class=\"multi-input\"]/input[@class=\"input-text required-entry\"])[2]/ancestor::table[@class=\"form-list\"]/tbody/tr[8]/td[2]/input")
    WebElement cityField;
    @FindBy(xpath ="//select[@class=\" required-entry countries required-entry select required-entry select\"]")
    WebElement countryField;
    @FindBy(id="_item391region_id")
    WebElement stateField;
    @FindBy(id="_item391postcode")
    WebElement zipCodeField;
    @FindBy(xpath = "//input[contains(@id,'_item391telephone') and contains(@name,'address[391][telephone]')]")
    WebElement telephoneField;
    @FindBy(xpath = "//button[@title='Save Customer'][1]")
    WebElement addedAddressSaveButton;
    @FindBy(xpath = "//span[text()=\"The customer has been saved.\"]")
    WebElement verifyNewAddressAddedMassage;

    public AddAddressesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void addNewAddress(){
        testUtility.sleep(3);
        testUtility.sleep(3);
        streetAddressField.clear();
        streetAddressField.click();
        streetAddressField.sendKeys(testUtility.generateStreetAddress());
        System.out.println("Street address field filled ");
        cityField.clear();
        cityField.click();
        testUtility.sleep(2);
        cityField.sendKeys(testUtility.generateCityName());
        System.out.println("city name is selected  by  faker ");
        countryField.click();
        testUtility.sleep(2);
        select=new Select(countryField);
        select.selectByVisibleText("Canada");
        System.out.println(" Country field filled by canada");
        stateField.click();
        testUtility.sleep(2);
        select=new Select(stateField);
        select.selectByIndex(1);
        System.out.println("state fill in bye Index");
        testUtility.waitForElementPresent(zipCodeField);
        zipCodeField.clear();
        zipCodeField.click();
        zipCodeField.sendKeys(testUtility.generateZipCode());
        System.out.println("Zip code filled successful");
        telephoneField.clear();
        telephoneField.click();
        telephoneField.sendKeys(testUtility.generateTelephoneNumber());
        System.out.println("telephone field filled successfully");
        testUtility.sleep(3);
        addedAddressSaveButton.click();
        System.out.println(" add address button clicked ");
    }

    public boolean verifyNewAddressAdded(){
        testUtility.waitForElementPresent(verifyNewAddressAddedMassage);
        if(driver.getPageSource().contains(verifyNewAddressAddedMassage.getText()))
            System.out.println("New address added successful ! ");
            return true;
    }

}
