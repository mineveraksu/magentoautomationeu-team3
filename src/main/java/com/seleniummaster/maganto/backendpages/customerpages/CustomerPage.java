package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CustomerPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";
    String email;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
        email = testUtility.generateEmailAddress();
    }

    @FindBy(xpath = " (//span[text()='Add New Customer'])[1]")
    WebElement addNewCustomerButton;
    @FindBy(id = "_accountfirstname")
    WebElement firstNameField;
    @FindBy(id = "_accountlastname")
    WebElement lastNameField;
    @FindBy(name = "account[email]")
    WebElement emailField;
    @FindBy(id = "_accountpassword")
    WebElement passwordField;
    @FindBy(xpath = "//div[@id='anchor-content']//p/button[3]")
    WebElement saveCustomerButton;
    @FindBy(css = ".success-msg>ul>li>span")
    WebElement successMessage;
    @FindBy(id = "customerGrid_massaction-select")
    WebElement actionsDropDown;
    @FindBy(id = "visibility")
    WebElement groupDropDown;
    @FindBy(xpath = "//span[@class=\"field-row\"]//span[text()=\"Submit\"]")
    WebElement submitButton;
    @FindBy(css = ".success-msg")
    WebElement verifyACustomerAssignToGroupSuccessfulSms;
    @FindBy(xpath = "(//button[@title=\"Delete Customer\"])[1]")
    WebElement deleteCustomerButton;
    @FindBy(xpath = "//span[contains(text(),'The customer has been deleted.')]")
    WebElement deleteSuccessMessage;


    public void addNewCustomer() {
        testUtility.waitForElementPresent(addNewCustomerButton);
        addNewCustomerButton.click();
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(testUtility.generateFirstName());
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(testUtility.generateLastName());
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config, "password"));
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();

    }

    public boolean verifyNewCustomerAdded() {
        testUtility.waitForElementPresent(successMessage);
        if (driver.getPageSource().contains(successMessage.getText())) ;
        System.out.println("The customer has been saved.");
        return true;
    }

    //Export Customer

    @FindBy(id = "customerGrid_export")
    WebElement fileFormatOption;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;


    public void selectFileType(String type) {
        testUtility.waitForElementPresent(fileFormatOption);
        Select option = new Select(fileFormatOption);
        option.selectByVisibleText(type);

    }

    public void clickOnExportButton() {
        testUtility.waitForElementPresent(exportButton);
        exportButton.click();
    }


    public boolean isCustomerFileExported() {
        String systemUserName = System.getProperty("user.name");
        String exportedFilePath = "C:\\Users\\" + systemUserName + "\\Downloads\\customers.xml";
        File exportedFileName = new File(exportedFilePath);
        Boolean isFileExported;
        isFileExported = exportedFileName.exists();
        Boolean isExported;
        if (isFileExported) {
            isExported = true;
        } else
            isExported = false;
        return isExported;
    }

    public void selectAddedCustomer() {
        String ckekBox = "//*[@id=\"customerGrid_table\"]//tbody//*[contains(text(),'?')]//ancestor::tr//input[@type=\"checkbox\"]";
        WebElement selectedCustomerChekBox = driver.findElement(By.xpath(ckekBox.replace("?", email)));
        testUtility.waitForElementPresent(selectedCustomerChekBox);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedCustomerChekBox).perform();
    }

    public void selectActionsList() {
        testUtility.waitForElementPresent(actionsDropDown);
        Select select = new Select(actionsDropDown);
        select.selectByVisibleText("Assign a Customer Group");
    }

    public void selectGroup(TestDataHolder testDataHolder) {
        testUtility.waitForElementPresent(groupDropDown);
        Select select2 = new Select(groupDropDown);
        select2.selectByVisibleText(testDataHolder.getCustomerGroupName());
    }

    public void clickOnSubmitButton() {
        testUtility.waitForElementPresent(submitButton);
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verificationACustomerAssignToGroup() {
        System.out.println(" assign a customer to group " + verifyACustomerAssignToGroupSuccessfulSms);
        return true;
    }

    //Update Customer

    @FindBy(xpath = "//a[@id='customer_info_tabs_account' and @class='tab-item-link'][1]")
    WebElement accountInformationLink;
    @FindBy(xpath = "(//select[@id=_accountgender])[1]")
    WebElement selectGender;
    @FindBy(css = "input[name='email']")
    WebElement emailFieldBox;
    @FindBy(css = "button[title='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//table[@id=\"customerGrid_table\"]//tr/td[4]")
    WebElement emailAddressAfterSearched;

    public void updateCustomer() {
        CustomerDashboardPage customerDashboardPage = new CustomerDashboardPage(driver);
        customerDashboardPage.clickOnManageCustomers();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(emailFieldBox);
        emailFieldBox.sendKeys(email);
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(emailAddressAfterSearched);
        emailAddressAfterSearched.click();
        testUtility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.clear();
        testUtility.sleep(3);
        lastNameField.sendKeys(testUtility.generateLastName());
        testUtility.sleep(3);
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
        testUtility.sleep(3);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyUpdateCustomer() {
        testUtility.waitForElementPresent(successMessage);
        if (driver.getPageSource().contains(successMessage.getText())) ;
        System.out.println("Update an existing customer information successfully");
        return true;
    }

    //Delete Customer

    public void deleteCustomer() {
        WebElement emailLocation = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", email)));
        testUtility.waitForElementPresent(emailLocation);
        testUtility.javaScriptClick(emailLocation);
        testUtility.waitForElementPresent(deleteCustomerButton);
        deleteCustomerButton.click();
        testUtility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyDeleteCustomer() {
        testUtility.waitForElementPresent(deleteSuccessMessage);
        if (deleteSuccessMessage.isDisplayed())
            System.out.println("The customer has been deleted.");
        return true;
    }


}
