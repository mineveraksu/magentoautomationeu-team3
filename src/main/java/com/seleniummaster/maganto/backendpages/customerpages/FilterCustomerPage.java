package com.seleniummaster.maganto.backendpages.customerpages;


import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterCustomerPage {
    WebDriver driver;
    TestUtility testUtility;
    String config = "config.properties";

    public FilterCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(css = "input[name='email']")
    WebElement emailField;

    @FindBy(css = "button[title='Search']")
    WebElement searchButton;

    @FindBy(css = "tr>td:nth-child(4)")
    WebElement customerEmail;

    @FindBy(id = "customerGrid_filter_billing_country_id")
    WebElement countryField;

    @FindBy(id = "customerGrid_filter_billing_region")
    WebElement stateField;

    @FindBy(id = "customerGrid_filter_website_id")
    WebElement websiteField;

    @FindBy(xpath = "//button[@title='Reset Filter']")
    WebElement resetFilter;


    public void clickEmailField(String email) {
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public boolean verifyFilterCustomerByEmail() {
        testUtility.waitForElementPresent(customerEmail);
        if (driver.getPageSource().contains(customerEmail.getText())) {
            System.out.println("Customer Manager can filter customers by Email Test is Passed!");
            return true;
        } else {
            System.out.println("Customer Manager can filter customers by Email Test is Failed!");
            return false;

        }
    }




    public void filterByCountry() {
        testUtility.waitForElementPresent(countryField);
        Select selectCountry = new Select(countryField);
        selectCountry.selectByValue("TR");
        searchButton.click();
    }

    public void verifyFilteredByCountry() {
        if (driver.getPageSource().contains("Turkey")) {
            System.out.println("Customer Manager can filter customers by country Test is Passed!");
        } else {
            System.out.println("Customer Manager can filter customers by country Test is Failed!");

        }
    }

    public void clickOnResetFilter() {
        testUtility.waitForElementPresent(resetFilter);

        try {
            resetFilter.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            resetFilter = driver.findElement(By.xpath("//button[@title='Reset Filter']"));
            resetFilter.click();
        }
    }

    public void filterByWebsite() {
        testUtility.waitForElementPresent(websiteField);
        try {
            websiteField.click();
        }catch (org.openqa.selenium.StaleElementReferenceException ex)
            {
                Select selectWebsite = new Select(websiteField);
                selectWebsite.selectByIndex(0);
                testUtility.sleep(2);
                searchButton.click();
        }
    }

    public void verifyFilteredByWebsite() {
        if (driver.getPageSource().contains("Admin")) {
            System.out.println("Customer Manager can filter customers by website Test is Passed!");
        } else {
            System.out.println("Customer Manager can filter customers by Website Test is Failed!");
        }
    }

    public void filterByState() {
        testUtility.waitForElementPresent(stateField);
        String state = TestUtility.getFieldFromJson("Test-Data/testDatasSmall.json", "state_name");
        stateField.sendKeys(state);
        try {
            searchButton.click();
        }catch (org.openqa.selenium.StaleElementReferenceException ex){}

    }



    public void verifyFilteredByState(){
        String state = TestUtility.getFieldFromJson("Test-Data/testDatasSmall.json","state_name");
        if (driver.getPageSource().contains(state)) {
            System.out.println("Customer Manager can filter customers by state Test is Passed!");
        } else {
            System.out.println("Customer Manager can filter customers by state Test is Failed!");
        }

    }
    }

