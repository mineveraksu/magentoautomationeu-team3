package com.seleniummaster.maganto.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestUtility{
    private int timeout=Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties","timeout"
    ));

    WebDriver driver;

    Faker faker=new Faker();

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(int second){
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }
    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String generateFirstName(){
        String firstName=faker.name().firstName();
        return firstName;
    }

    public String generateLastName(){
        String lastName=faker.name().lastName();
        return lastName;
    }
    public String generateMiddleName(){
        String middleName=faker.name().nameWithMiddle();
        return middleName;
    }

    public String generateEmailAddress(){
        String emailAddress=faker.internet().emailAddress();
        return emailAddress;
    }

    public void waitForAlertPresent(){
        WebDriverWait wai=new WebDriverWait(driver,timeout);
        wai.until(ExpectedConditions.alertIsPresent());
    }

    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
