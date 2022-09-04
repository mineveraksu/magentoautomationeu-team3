package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.ExcelUtility;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    ExcelUtility excelUtility=new ExcelUtility();
    String excelFile = "Test-Data/addressBookData.xlsx";

    @FindBy(css = ".block-content>ul>li:nth-child(4)")
    WebElement myOrdersLink;
    @FindBy(css = ".nav-primary>li.level0.nav-3.parent")
    WebElement saleLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]//ul//li[2]/a")
    WebElement accountInformationLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]//ul//li[3]/a")
    WebElement addressBookLink;
    @FindBy(css = ".col-1.addresses-primary>ol")
    WebElement updatedAddressTable;
    @FindBy(css = "li.success-msg")
    WebElement updatedAddressBookSuccessfulMessage;

    @FindBy(css = "p.welcome-msg")
    WebElement loginVerifyMessage;
    @FindBy(xpath = "(//img[@alt='Madison Island'])[1]")
    WebElement madisonLogo;

    @FindBy(xpath = "//a[text() = 'My Downloadable Products']")
    WebElement myDownloadableProductsLink;
    @FindBy(xpath = "(//span[text()='Account'])[1]")
    WebElement accountLink;
    @FindBy(xpath = "//div[@id='header-account']/div/ul/li[@class='first']/a")
    WebElement myAccountLink;
    @FindBy(css = ".block-content>ul>li:nth-child(7)")
    WebElement myProductReviewsLink;

    @FindBy(xpath = "//div[@class=\"block-content\"]//ul//li[9]/a")
    WebElement myWishListLink;



    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public boolean verifyLogin() {
        testUtility.waitForElementPresent(loginVerifyMessage);
        if (driver.getPageSource().contains(loginVerifyMessage.getText()))
            System.out.println("login successfully");
        return true;
    }
    public void clickOnMyOrdersLink() {
        testUtility.waitForElementPresent(myOrdersLink);
        myOrdersLink.click();
    }

    public void clickOnMyWishListLink(){
        testUtility.waitForElementPresent(myWishListLink);
        myWishListLink.click();
    }

    public void clickOnAccountInformationLink(){
        testUtility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }
    public void clickOnAddressBookLink(){
        testUtility.waitForElementPresent(addressBookLink);
        addressBookLink.click();
    }

    public boolean verifyUpdatedAddressBookSuccessful(){
        testUtility.sleep(4);
        //testUtility.waitForElementPresent(updatedAddressBookSuccessfulMessage);
        System.out.println("The address has been saved." + "successful message displayed");
        return updatedAddressBookSuccessfulMessage.isDisplayed();

    }
    public boolean verifyViewUpdatedAddressBook(){
        testUtility.waitForElementPresent(updatedAddressTable);
        return updatedAddressTable.getText().contains(excelUtility.readFromExcelCell(
                excelFile, "Address-Book", 0, 1));
    }
    public void clickOnSaleLink(){
        testUtility.waitForElementPresent(saleLink);
        saleLink.click();
    }

    public void clickOnMyDownloadableProductsLink() {
        testUtility.waitForElementPresent(myDownloadableProductsLink);
        myDownloadableProductsLink.click();
    }


    public MyDownloadableProductsPage clickMyDownloadableProductsLink() {
        testUtility.waitForElementPresent(myDownloadableProductsLink);
        myDownloadableProductsLink.click();
        return new MyDownloadableProductsPage(driver);
    }
    public void clickOnMyProductReviewsLink(){
        testUtility.waitForElementPresent(myProductReviewsLink);
        myProductReviewsLink.click();

    }

    public void backToDashboardPage() {
        testUtility.waitForElementPresent(accountLink);
        accountLink.click();
        testUtility.waitForElementPresent(myAccountLink);
        myAccountLink.click();
    }

    public void clickOnMadisonLogo() {
        testUtility.waitForElementPresent(madisonLogo);
        madisonLogo.click();
    }

}

