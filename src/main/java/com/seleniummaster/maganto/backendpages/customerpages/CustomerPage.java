package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CustomerPage {
    WebDriver driver;
    TestUtility testUtility;
    String config="config.properties";
    String email= testUtility.generateEmailAddress();

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
        emailField.sendKeys(email);
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



    //Export Customer

   @FindBy(id = "customerGrid_export")
    WebElement fileFormatOption;
   @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;





    public void selectFileType(String type){
               testUtility.waitForElementPresent(fileFormatOption);
                Select option = new Select(fileFormatOption);
                option.selectByVisibleText(type);

            }
            public void clickOnExportButton(){
                testUtility.waitForElementPresent(exportButton);
                exportButton.click();
            }


            public boolean isCustomerFileExported () {
                String systemUserName= System.getProperty("user.name");
                String exportedFilePath="C:\\Users\\"+systemUserName+"\\Downloads\\customers.xml";
                File exportedFileName=new File(exportedFilePath);
                Boolean isFileExported;
                isFileExported = exportedFileName.exists();
                Boolean isExported;
                if(isFileExported)
                {
                    isExported=true;
                }
                else
                    isExported=false;
                return isExported;
            }



}
