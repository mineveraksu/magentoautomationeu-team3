package com.seleniummaster.maganto.backendpages.catalogpages;

import com.seleniummaster.maganto.utility.TestResultListener;
import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import java.io.File;
import java.util.List;

public class CatalogDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    @FindBy(css = ".active>a")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(xpath = "//span[text()='Attributes']")
    WebElement attributesLink;
    @FindBy(xpath = "//span[text()='Manage Attributes']")
    WebElement manageAttributesLink;
    @FindBy(xpath = "//a[text()=\"Expand All\"]")
    WebElement expendLink;
    @FindBy(css = "#ext-gen20")
    WebElement defaultCategoryIcon;
    @FindAll(@FindBy(xpath = "//ul[@class=\"x-tree-node-ct\"]"))
    List<WebElement> defaultCategories;

    public CatalogDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
    }

    public void clickOnManageCategories(){
        testUtility.waitForElementPresent(catalogLink);
        catalogLink.click();
        testUtility.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
    }
    public void clickOnExpendLink(){
        testUtility.waitForElementPresent(expendLink);
        expendLink.click();
    }
    public boolean verifyManagerCanViewAllCategoriesUnderDefault(){
        System.out.println("catalog manager can view all categories");
        return defaultCategories.size()>1;
    }

    public void clickOnManageAttributes(){
        testUtility.waitForElementPresent(catalogLink);
        actions.moveToElement(catalogLink).perform();
        testUtility.waitForElementPresent(attributesLink);
        actions.moveToElement(attributesLink).click(manageAttributesLink).perform();
    }
//    public boolean isDefaultCategoryExist(){
//
//        String categoryFilePath= String.valueOf(categoryFileLocation);
//        File defaultCategory=new File(categoryFilePath);
//        boolean isCategoryExist;
//        isCategoryExist=defaultCategory.exists();
//        boolean isCategoryViewable;
//        if (isCategoryExist){
//            isCategoryViewable=true;
//        }else {
//            isCategoryViewable=false;
//        }
//        return isCategoryViewable;
//
//    }
}
