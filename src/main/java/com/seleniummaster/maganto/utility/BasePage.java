package com.seleniummaster.maganto.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    WebDriver driver;

    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public void closeDriver(){
        driver.quit();
    }
}
