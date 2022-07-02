package com.seleniummaster.maganto.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
    public  WebDriver driver;
    public  String browserName = "chrome";

    public  void browserSetUp(String Url) {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(Url);

            } else if (browserName.equalsIgnoreCase("Fire fox")) {
                System.setProperty("webdriver.gecko.driver", "c:\\webdriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(Url);
            }
            else if (browserName.equalsIgnoreCase("safari")) {
                System.setProperty("webdriver.safari.driver", "c:\\safaridriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(Url);
            }
        }
    }

    public  void closeBrowser() {
        driver.quit();
    }
}
