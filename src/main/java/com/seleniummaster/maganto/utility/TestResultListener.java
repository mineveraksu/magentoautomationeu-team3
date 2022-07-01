package com.seleniummaster.maganto.utility;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultListener implements ITestListener {

    ScreenShotUtility screenShotUtility=new ScreenShotUtility();
    public void onTestSuccess(ITestResult result) {
        screenShotUtility.takeScreenshot("image",result.getMethod().getMethodName(),
                (WebDriver) result.getTestContext().getAttribute("driver"));//downCast
    }

    public void onTestFailure(ITestResult result) {
        screenShotUtility.takeScreenshot("image",result.getMethod().getMethodName(),
                (WebDriver) result.getTestContext().getAttribute("driver"));
    }
    public void onTestSkipped(ITestResult result) {
        screenShotUtility.takeScreenshot("image",result.getMethod().getMethodName(),
                (WebDriver) result.getTestContext().getAttribute("driver"));
    }



}
