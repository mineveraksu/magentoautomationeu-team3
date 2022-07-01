package com.seleniummaster.maganto.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    public WebDriver driver;

    public void browserSetUp(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void closeDriver(){
        driver.quit();
    }
}
