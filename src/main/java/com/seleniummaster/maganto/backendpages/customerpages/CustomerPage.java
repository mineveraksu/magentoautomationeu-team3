package com.seleniummaster.maganto.backendpages.customerpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    WebDriver driver;
    TestUtility testUtility;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    //Add Customer
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
