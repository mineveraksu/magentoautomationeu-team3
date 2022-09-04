package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ExcelUtility;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage {
    WebDriver driver;
    TestUtility testUtility;
    ExcelUtility excelUtility;
    String excelFile = "Test-Data/addressBookData.xlsx";

    @FindBy(linkText = "Edit Address")
    WebElement  editAddressLink;
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;
    @FindBy(id = "telephone")
    WebElement telephoneField;
    @FindBy(id = "street_1")
    WebElement street_1Field;
    @FindBy(id = "city")
    WebElement cityField;
    @FindBy(id = "zip")
    WebElement zipField;
    @FindBy(id = "country")
    WebElement countrySelectField;
    @FindBy(css = "button[title=\"Save Address\"]")
    WebElement saveAddressButton;


    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        excelUtility = new ExcelUtility();
    }

    public void clickONEditNewAddressButton() {
        testUtility.waitForElementPresent(editAddressLink);
        editAddressLink.click();
    }

    public void enterFirstName() {
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(testUtility.generateFirstName());
    }

    public void enterLastName() {
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.clear();
        lastNameField.sendKeys(testUtility.generateLastName());
    }

    public void enterPhoneNumber() {

        testUtility.waitForElementPresent(telephoneField);
        telephoneField.clear();
        telephoneField.sendKeys(excelUtility.readFromExcelCell(excelFile, "Address-Book", 3, 1));
    }

    public void enterStreetAddress() {
        testUtility.waitForElementPresent(street_1Field);
        street_1Field.clear();
        street_1Field.sendKeys(excelUtility.readFromExcelCell(excelFile, "Address-Book", 0, 1));
    }

    public void enterCity() {
        testUtility.waitForElementPresent(cityField);
        cityField.clear();
        cityField.sendKeys(excelUtility.readFromExcelCell(excelFile, "Address-Book", 1, 1));
    }

    public void enterZipCode() {
        testUtility.waitForElementPresent(zipField);
        zipField.clear();
        zipField.sendKeys(excelUtility.readFromExcelCell(excelFile, "Address-Book", 2, 1));
    }
    public void selectCountry() {
        testUtility.waitForElementPresent(countrySelectField);
        Select select2 = new Select(countrySelectField);
        select2.selectByValue("GB");
    }
    public MyDashboardPage clickONSaveAddressButton() {
        testUtility.waitForElementPresent(saveAddressButton);
        saveAddressButton.click();
        return new MyDashboardPage(driver);
    }
    public void updateAddressBookMethod(){
        clickONEditNewAddressButton();
        enterFirstName();
        enterLastName();
        enterPhoneNumber();
        enterStreetAddress();
        enterCity();
        enterZipCode();
        selectCountry();
    }
}