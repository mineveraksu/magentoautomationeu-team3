package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.Alert;
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

    @FindBy(xpath = "//span[contains(text(),'Add New Address')]")
    WebElement addNewAddressButton;
    @FindBy(id= "_item2street0")
    WebElement streetAddressField;
    @FindBy(id="_item2city")
    WebElement cityField;
    @FindBy(id="_item2country_id")
    WebElement countryField;
    @FindBy(id="_item2region_id")
    WebElement stateField;
    @FindBy(id="_item2postcode")
    WebElement zipCodeField;
    @FindBy(id="_item2telephone")
    WebElement telephoneField;
    @FindBy(xpath = "//div[@id='page:main-container']//button[@onclick='editForm.submit();']//span[text()='Save Customer']")
    WebElement addedAddressSaveButton;
    @FindBy(xpath = "//span[text()=\"The customer has been saved.\"]")
    WebElement verifyNewAddressAddedMassage;
    @FindBy(xpath = "//td[contains(text(),\"team33@hotmail.com\")]")
    WebElement customerEmailAddress;
    @FindBy(css = "#customer_info_tabs_addresses")
    WebElement addressesLink;
    @FindBy(id="delete_button2")
    WebElement deleteButton2;

    public AddAddressesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void addNewAddress(){
        testUtility.waitForElementPresent(addNewAddressButton);
        addNewAddressButton.click();
        testUtility.waitForElementPresent(streetAddressField);
        streetAddressField.sendKeys(testUtility.generateStreetAddress());
        testUtility.waitForElementPresent(cityField);
        cityField.sendKeys(testUtility.generateCityName());
        testUtility.waitForElementPresent(countryField);
        select=new Select(countryField);
        select.selectByVisibleText("Turkey");
        testUtility.waitForElementPresent(zipCodeField);
        zipCodeField.sendKeys(testUtility.generateZipCode());
        testUtility.waitForElementPresent(telephoneField);
        telephoneField.sendKeys(testUtility.generateTelephoneNumber());
        addedAddressSaveButton.click();
    }

    public boolean verifyNewAddressAdded(){
        testUtility.waitForElementPresent(verifyNewAddressAddedMassage);
        if(driver.getPageSource().contains(verifyNewAddressAddedMassage.getText())){
            System.out.println("New address added successful ! ");
            return true;}
        else{
            System.out.println(" New address failed to add !");
            return false;
        }
    }
    //Delete Added new address steps
    public void deleteAddedAddress(){
        testUtility.waitForElementPresent(customerEmailAddress);
        customerEmailAddress.click();
        testUtility.waitForElementPresent(addressesLink);
        addressesLink.click();
        testUtility.waitForElementPresent(deleteButton2);
        deleteButton2.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        actions.moveToElement(addedAddressSaveButton).click().perform();
    }

}
