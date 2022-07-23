package com.seleniummaster.maganto.utility;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class TestUtility{
    private int timeout=Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties","timeout"
    ));

    WebDriver driver;

    Faker faker=new Faker();

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void javaScriptClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", element);
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

    public String generateStreetAddress(){
        String streetAddress=faker.address().streetAddress();
        return streetAddress;
    }

    public String generateCityName(){
        String cityName=faker.address().cityName();
        return cityName;
    }

    public  String generateCountryName(){
        String countryName=faker.address().country();
        return countryName;
    }

    public String generateStateName(){
        String stateName=faker.address().state();
        return stateName;
    }

    public String generateZipCode(){
        String zinCode=faker.address().zipCode();
        return zinCode;
    }

    public String generateTelephoneNumber(){
        String telephoneNumber=faker.phoneNumber().phoneNumber();
        return telephoneNumber;
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

    public static String getFieldFromJson(String fileName, String key)
    {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            String data = map.get(key).toString();
            return data;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Failed";
    }

}
