package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    WebDriver driver;
    TestUtility testUtility;
    String config="config.properties";

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }

    //Add Customer
    @FindBy(xpath = " (//span[text()='Add New Customer'])[1]")
    WebElement addNewCustomerButton;
    @FindBy(id="_accountfirstname")
    WebElement firstNameField;
    @FindBy(id="_accountlastname")
    WebElement lastNameField;
    @FindBy(name="account[email]")
    WebElement emailField;
    @FindBy(id="_accountpassword")
    WebElement passwordField;
    @FindBy(xpath = "//div[@id='anchor-content']//p/button[3]")
    WebElement saveCustomerButton;
    @FindBy(css = ".success-msg>ul>li>span")
    WebElement customerSavedSMS;

    public void addNewCustomer(){
        testUtility.waitForElementPresent(addNewCustomerButton);
        addNewCustomerButton.click();
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(testUtility.generateFirstName());
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(testUtility.generateLastName());
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"email"));
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"password"));
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();

    }
    public boolean verifyNewCustomerAdded(){
        testUtility.waitForElementPresent(customerSavedSMS);
        if (driver.getPageSource().contains(customerSavedSMS.getText()));
        System.out.println("The customer has been saved.");
        return true;
    }

    //Update Customer
    //Delete Customer
    //Export Customer
    @FindBy(css="button[title='Export']")
    WebElement exportButton;

    //Assign Customer to Group

    //WebElements needed in Add Customer Method


    //WebElements needed in Update Customer Method


    //WebElements needed in Delete Customer Method


    //WebElements needed in Export Customer Method



    //WebElements needed in Assign Customer to Group Method


    //Add Customer Method

    //Update Customer Method

    //Delete Customer Method

    //Export Customer Method

    //Assign Customer to Group Method
}
