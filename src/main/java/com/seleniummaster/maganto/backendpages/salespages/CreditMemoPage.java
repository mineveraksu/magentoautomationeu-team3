package com.seleniummaster.maganto.backendpages.salespages;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditMemoPage {
    WebDriver driver;
    TestUtility testUtility;
    //String billToName;
    String email;
    TestDataHolder testDataHolder;

    @FindBy(xpath = "(//*[@class=\"box-right\"])[1]")
    WebElement accountInformationTable;





    public CreditMemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        email = ApplicationConfig.readFromConfigProperties("config.properties", "email");
        testDataHolder=new TestDataHolder();

    }
    public void clickOnViewButton(TestDataHolder testDataHolder){
        //WebElement viewButton=driver.findElement(By.xpath("(//*[@id='sales_creditmemo_grid_table']/tbody/tr/td[contains(text(),'team33  team33')])[1]//ancestor::tr/td[9]"));
        WebElement viewButton=driver.findElement(By.xpath(String.format("(//*[@id='sales_creditmemo_grid_table']/tbody/tr/td[contains(text(),'%s')])[1]//ancestor::tr/td[9]",testDataHolder.getBillToName())));
        testUtility.waitForElementPresent(viewButton);
        viewButton.click();
    }
    public void viewAccountInformation(){
        testUtility.sleep(3);
        //testUtility.waitForElementPresent(accountInformationTable);
        accountInformationTable.isDisplayed();
    }
    public void viewCreditMemoMethod(TestDataHolder testDataHolder){
        clickOnViewButton(testDataHolder);
        viewAccountInformation();
    }
    public boolean verifyViewCreditMemo(){
        testUtility.waitForElementPresent(accountInformationTable);

        return accountInformationTable.getText().contains(email);
    }


}
