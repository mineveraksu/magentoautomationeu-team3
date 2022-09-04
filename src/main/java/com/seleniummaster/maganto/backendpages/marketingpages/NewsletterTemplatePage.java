package com.seleniummaster.maganto.backendpages.marketingpages;

import com.seleniummaster.maganto.utility.TestDataHolder;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewsletterTemplatePage {
    WebDriver driver;
    TestUtility testUtility;
    String email;

    @FindBy(xpath = "(//td[@class=\"form-buttons\"])[1]//span/span/span")
    WebElement addNewTemplateButton;
    @FindBy(id = "code")
    WebElement templateNameField;
    @FindBy(id = "subject")
    WebElement templateSubjectField;
    @FindBy(id = "sender_email")
    WebElement senderEmailField;
    @FindBy(xpath = "(//button[@title='Save Template']//span[text()='Save Template'])[1]")
    WebElement saveTemplateButton;
    @FindBy(name = "limit")
    WebElement viewDropDown;
    @FindBy(xpath = "(//button[@title='Delete Template']//span[text()='Delete Template'])[1]")
    WebElement deleteTemplateButton;
    @FindBy(xpath = "//input[@name='code']")
    WebElement templateNameFilterField;
    @FindBy(xpath = "//td[contains(text(),'No records found.')]")
    WebElement noRecordsFoundMessage;

    public NewsletterTemplatePage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
        email = testUtility.generateEmailAddress();
    }

    public void clickOnAddNewTemplate() {
        testUtility.waitForElementPresent(addNewTemplateButton);
        addNewTemplateButton.click();
    }

    public void typeTemplateName(String templateName) {
        testUtility.waitForElementPresent(templateNameField);
        templateNameField.sendKeys(templateName+System.currentTimeMillis());
    }

    public void typeTemplateSubject(String templateSubject) {
        testUtility.waitForElementPresent(templateSubjectField);
        templateSubjectField.sendKeys(templateSubject);
    }

    public void clickOnSaveTemplateButton() {
        testUtility.waitForElementPresent(saveTemplateButton);
        saveTemplateButton.click();
    }

    public void clickOnDeleteTemplateButton() {
        testUtility.waitForElementPresent(deleteTemplateButton);
        deleteTemplateButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void selectViewDropDown() {
        testUtility.waitForElementPresent(viewDropDown);
        Select select = new Select(viewDropDown);
        select.selectByIndex(4);
    }

    public void clickOnTheTemplateName(String templateName) {
        WebElement templateNameLocation = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", templateName)));
        testUtility.waitForElementPresent(templateNameLocation);
        templateNameLocation.click();
    }

    public void typeNewEmail() {
        testUtility.waitForElementPresent(senderEmailField);
        senderEmailField.clear();
        senderEmailField.sendKeys(email);
    }

    public void typeTemplateNameInTemplateNameFilterField(String templateName ) {
        testUtility.waitForElementPresent(templateNameFilterField);
        templateNameFilterField.sendKeys(templateName+ Keys.ENTER);
    }

    public void addNewNewsletterTemplate(String templateName, String templateSubject) {
        clickOnAddNewTemplate();
        typeTemplateName(templateName);
        typeTemplateSubject(templateSubject);
        clickOnSaveTemplateButton();
    }

    public boolean verifyNewsletterTemplateAddedSuccessfully(String templateName) {
        selectViewDropDown();
        WebElement templateNameLocation = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", templateName)));
        testUtility.waitForElementPresent(templateNameLocation);
        if (templateNameLocation.isDisplayed()) {
            System.out.println("Marketing Manager add new Newsletter template Test Passed ");
            return true;
        } else {
            System.out.println("Marketing Manager add new Newsletter template Test Failed");
            return false;
        }
    }

    public void updateNewsletterTemplate(String templateName) {
        selectViewDropDown();
        clickOnTheTemplateName(templateName);
        typeNewEmail();
        clickOnSaveTemplateButton();
    }

    public boolean verifyNewsletterTemplateUpdatedSuccessfully() {
        selectViewDropDown();
        WebElement emailLocation = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", email)));
        testUtility.waitForElementPresent(emailLocation);
        if (emailLocation.isDisplayed()) {
            System.out.println("Marketing Manager update Newsletter template Test Passed ");
            return true;
        } else {
            System.out.println("Marketing Manager update Newsletter template Test Failed");
            return false;
        }
    }

    public void deleteNewsletterTemplate(String templateName) {
        selectViewDropDown();
        clickOnTheTemplateName(templateName);
        clickOnDeleteTemplateButton();
    }

    public boolean verifyNewsletterTemplateDeletedSuccessfully(String templateName) {
        selectViewDropDown();
        typeTemplateNameInTemplateNameFilterField(templateName);
        testUtility.waitForElementPresent(noRecordsFoundMessage);
        if (noRecordsFoundMessage.isDisplayed()) {
            System.out.println("Marketing Manager delete Newsletter template Test Passed ");
            return true;
        } else {
            System.out.println("Marketing Manager delete Newsletter template Test Failed");
            return false;
        }
    }
}
