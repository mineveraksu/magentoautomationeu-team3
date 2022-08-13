package com.seleniummaster.maganto.backendpages.salespages;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RefundsPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;
    int reportsSize;


    @FindBy(css = "#store_switcher")
    WebElement showReportForField;
    @FindBy(css = "#sales_report_report_type")
    WebElement matchPeriodToField;
    @FindBy(css = "#sales_report_period_type")
    WebElement periodField;
    @FindBy(css = "#sales_report_from")
    WebElement startFrom;
    @FindBy(css = "#sales_report_to")
    WebElement endTo;
    @FindBy(xpath = "(//span[contains(text(),'Show Report')])[1]")
    WebElement showReportButton;

    @FindBy(id = "sales_order_grid_filter_billing_name")
    WebElement billNoNameField;
    @FindBy(xpath = "(//td[contains(text(),'Pending')])[1]")
    WebElement pendingButton;
    @FindBy(xpath = "(//span[text()='Invoice'])[1]")
    WebElement invoiceButton;
    @FindBy(xpath = "//span[contains(text(),'Submit Invoice')]")
    WebElement submitInvoiceButton;
    @FindBy(xpath = "//span[contains(text(),'The invoice has been created.')]")
    WebElement invoiceSuccessCreatedMassage;
    @FindBy(xpath = "(//button[@class=\"scalable go\"])[1]")
    WebElement creditMemoButton;
    @FindBy(xpath = "//button[@class=\"scalable save submit-button\"]")
    WebElement refundOfflineButton;
    @FindBy(xpath = "//tr[@class='2']/td[2]/strong/span")
    WebElement refundPrice;
    @FindBy(xpath = "//span[text()=\"The credit memo has been created.\"]")
    WebElement refundCreatedSuccessMassage;


    public RefundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    //for data base test {Sales Manager should be able to add refunds in the Reports  }
    //public void addRefunds


    public void refundsReport(TestDataHolder testDataHolder){
        testUtility.waitForElementPresent(showReportForField);
        actions.moveToElement(showReportForField).click().perform();
        Select select=new Select(showReportForField);
        select.selectByVisibleText("All Websites");
        System.out.println(" all choose");
        testUtility.waitForElementPresent(matchPeriodToField);
        Select select1=new Select(matchPeriodToField);
        select1.selectByVisibleText("Order Created Date");
        testUtility.waitForElementPresent(periodField);
        Select select2=new Select(periodField);
        select2.selectByVisibleText("Year");
        testUtility.waitForElementPresent(startFrom);
        startFrom.sendKeys(testDataHolder.getStartFrom());
        testUtility.waitForElementPresent(endTo);
        endTo.sendKeys(testDataHolder.getEndTo());
        testUtility.sleep(2);
        testUtility.waitForElementPresent(showReportButton);
        actions.moveToElement(showReportButton).click().perform();
        System.out.println(" clicked showReportButton");
        testUtility.sleep(2);



    }

    public boolean verifyRefundsReportSuccessfulShow(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportsSize= rows.size();//4
        if(reportsSize>=1){
            System.out.println("Refunds reports showed !");
            return  true;
        }else{
            System.out.println("Refunds have not founded !");
            return false;
        }
    }

    public  void createNewRefunds(){
        testUtility.sleep(2);
        testUtility.waitForElementPresent(billNoNameField);
        billNoNameField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","username")+ Keys.ENTER);
        testUtility.sleep(2);
        testUtility.waitForElementPresent(pendingButton);
        actions.moveToElement(pendingButton).click().perform();
        testUtility.waitForElementPresent(invoiceButton);
        actions.moveToElement(invoiceButton).click().perform();
        testUtility.waitForElementPresent(submitInvoiceButton);
        actions.moveToElement(submitInvoiceButton).click().perform();
        testUtility.waitForElementPresent(creditMemoButton);
        actions.moveToElement(creditMemoButton).click().perform();
        testUtility.waitForElementPresent(refundOfflineButton);
        actions.moveToElement(refundOfflineButton).click().perform();
    }

    public double refundedAmount(){
        testUtility.waitForElementPresent(refundPrice);
        return Double.parseDouble(refundPrice.getText().replace("$",""));
    }

    public boolean verifyCreateNewRefunds(){
        testUtility.waitForElementPresent(refundCreatedSuccessMassage);
        if(refundCreatedSuccessMassage.isDisplayed()){
            System.out.println(" Sales manager created new refunds is success !");
            return true;
        }else{
            System.out.println("Sales manager can not crated new refund , please check it !");
            return  false;
        }
    }

}
