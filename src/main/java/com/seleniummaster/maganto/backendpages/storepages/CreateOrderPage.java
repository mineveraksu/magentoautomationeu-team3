package com.seleniummaster.maganto.backendpages.storepages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    Select select;

//    public CreateOrderPage(){
//        this.driver=
//    }

    @FindBy(xpath = "(//span[text()='Create New Order'])[2]")
    WebElement createNewOrdersTab;
    @FindBy (id = "sales_order_create_customer_grid_filter_name")
    WebElement customerNameField;
    @FindBy (id = "sales_order_create_customer_grid_filter_entity_id")
    WebElement customerIdField;
    @FindBy (xpath = "//input[@type='text' and @id='sales_order_create_customer_grid_filter_email']")
    WebElement customerEmailField;
}
