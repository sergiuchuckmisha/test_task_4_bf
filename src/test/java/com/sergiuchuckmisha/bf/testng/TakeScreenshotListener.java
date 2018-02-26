package com.sergiuchuckmisha.bf.testng;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.inject.Inject;
import javax.inject.Provider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static com.sergiuchuckmisha.bf.config.Config.SCREENSHOTS_PATH;

//used code from http://www.seleniumeasy.com/testng-tutorials/how-to-take-screenshot-for-only-failed-tests-using-webdriver
public class TakeScreenshotListener implements ITestListener {

    private  final Logger log = Logger.getLogger(getClass());

    @Inject
    Provider<TakesScreenshot> takesScreenshotProvider;

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("***** Error "+result.getName()+" test has failed *****");
        String methodName= result.getName().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        //get the driver
       // WebDriver driver= new WebDriverManager(new WebDriverFactory()).getDriver();


       // WebDriver driver= wdManager.getDriver();
       // File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        TakesScreenshot takesScreenshot = takesScreenshotProvider.get();
        if (takesScreenshot == null){
            log.trace("Screenshot was not created. Driver closed.");
            return;
        }
       File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //The below method will save the screen shot in d drive with test method name
        try {


            FileUtils.copyFile(scrFile, Paths.get(SCREENSHOTS_PATH, methodName+".png").toFile());
            log.info("***Place screenshot to "+SCREENSHOTS_PATH+" ***");
        } catch (IOException e) {
            log.warn("Screenshot error.", e);
        }
    }
    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}
