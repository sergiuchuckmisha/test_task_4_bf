package com.sergiuchuckmisha.bf.testng;

import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static com.sergiuchuckmisha.bf.config.Config.SCREENSHOTS_PATH;

//used code from http://www.seleniumeasy.com/testng-tutorials/how-to-take-screenshot-for-only-failed-tests-using-webdriver
public class TestListener implements ITestListener {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TestListener.class);
    WebDriver driver=null;
    @Override
    public void onTestFailure(ITestResult result) {
        log.info("***** Error "+result.getName()+" test has failed *****");
        String methodName= result.getName().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        //get the driver
        driver= new WebDriverManager().getDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {


            FileUtils.copyFile(scrFile, Paths.get(SCREENSHOTS_PATH, methodName+".png").toFile());
            log.info("***Place screenshot to "+SCREENSHOTS_PATH+" ***");
        } catch (IOException e) {
            log.warn(e);
        }
    }
    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}
