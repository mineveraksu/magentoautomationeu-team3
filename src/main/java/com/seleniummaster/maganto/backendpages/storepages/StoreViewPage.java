package com.seleniummaster.maganto.backendpages.storepages;
import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class StoreViewPage {

    WebDriver driver;
    TestUtility testUtility;
    @FindBy(xpath = "//td[@class=\"form-buttons\"]/button[3]/span/span/span")
    WebElement createStoreViewButton;
    @FindBy(name = "store[group_id]")
    WebElement storeDropDown;
    @FindBy(id = "store_name")
    WebElement storeViewNameField;
    @FindBy(id = "store_code")
    WebElement storeCodeField;
    @FindBy(xpath = "(//span[text()=\"Save Store View\"])[1]")
    WebElement saveStoreViewButton;
    @FindBy(css = "ul.messages")
    WebElement successMsg;

    public StoreViewPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateStoreViewButton() {
        testUtility.waitForElementPresent(createStoreViewButton);
        createStoreViewButton.click();
    }
public void selectStoreViewDropDown (TestDataHolder testDataHolder) {
    testUtility.waitForElementPresent(storeDropDown);
    Select select = new Select(storeDropDown);
    select.selectByVisibleText(testDataHolder.getStoreName());
}
    public void enterName (String name){
        testUtility.waitForElementPresent(storeViewNameField);
        storeViewNameField.sendKeys(name);
    }
    public void enterCode (String code){
        testUtility.waitForElementPresent(storeCodeField);
        storeCodeField.sendKeys(code);
    }
    public void clickSaveStoreViewButton () {
        testUtility.waitForElementPresent(saveStoreViewButton);
        saveStoreViewButton.click();
    }
    public void createAStoreView (TestDataHolder testDataHolder, String name, String code){
        selectStoreViewDropDown(testDataHolder);
        enterName(name);
        enterCode(code);
        clickSaveStoreViewButton();
    }
    public boolean verifyStoreViewSaved(){

        return successMsg.isDisplayed();
    }
       // public void clickOnTheCreatedStoreViewLink(){
//           JavascriptExecutor js = (JavascriptExecutor) driver;
//           js.executeScript("window.location");// returns current window location
//           js.executeScript("window.scrollBy(0,900)");
            //scrollToElementAppears(createdStoreViewLink,driver);

//            avascriptExecutor js=(JavascriptExecutor)driver;
            //js.executeScript("arguments[0].scrolltoView(true);",createdStoreViewLink);
           // actions=new Actions(driver);
           // testUtility.waitForElementPresent(createdStoreViewLink);
           // testUtility.sleep(3);
           // createdStoreViewLink.click();
          //  actions.moveToElement(createdStoreViewLink).perform();
       // }
//    public  void scrollToElementAppears(WebElement element,WebDriver driver){
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrolltoView(true);",element);
//
//    }
    public void clickOnStoreViewName(){
    WebElement storeViewName = driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", "\n" +
            "    team3")));
    testUtility.waitForElementPresent(storeViewName);
    storeViewName.click();
}
    public void enterEditName(String name){
        testUtility.waitForElementPresent(storeViewNameField);
        storeViewNameField.clear();
        storeViewNameField.sendKeys(name);
    }
    public void editStoreView(String name){
            clickOnStoreViewName();
            enterEditName(name);
            clickSaveStoreViewButton();

    }
    }

