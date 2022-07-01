package com.seleniummaster.maganto.frontendpages;

import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;



import com.seleniummaster.maganto.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyDownloadableProductsPage {
        WebDriver driver;
        TestUtility testUtility;

        @FindAll(@FindBy(xpath = "//table[@id = 'my-downloadable-products-table']//tbody/tr"))
        List<WebElement> downloadableProductsList;



        public MyDownloadableProductsPage(WebDriver driver) {

            this.driver = driver;
            testUtility = new TestUtility(driver);
            PageFactory.initElements(driver, this);
        }

        public boolean isDownloadableProductsExist() {


            if (downloadableProductsList.size() >= 1) {
                System.out.println("The list is not empty.");
                return true;
            } else {
                System.out.println("The list is empty.");
                return false;
            }

        }

    }


