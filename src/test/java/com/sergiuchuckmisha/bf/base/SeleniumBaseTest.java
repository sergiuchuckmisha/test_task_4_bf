package com.sergiuchuckmisha.bf.base;

import com.sergiuchuckmisha.bf.guice.TestModuleFactory;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import com.sergiuchuckmisha.bf.testng.ListenerFactory;
import com.sergiuchuckmisha.bf.testng.TakeScreenshotListener;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 7:29 PM
 * purpose of this class is to contain methods common to all basicNavigation classes. e.g. clear browser before/after each basicNavigation
 */
//@Guice(modules = PagesModule.class)
@Guice(moduleFactory = TestModuleFactory.class)
@Listeners({ListenerFactory.class, TakeScreenshotListener.class})
public abstract class SeleniumBaseTest {

    @Inject
    private WebDriverManager wdManager;

    protected final Logger log = Logger.getLogger(getClass());


//	@BeforeSuite
//	@AfterSuite
//	@BeforeTest
//	@AfterTest
    @BeforeMethod
    public void startTestCase(ITestResult testResult) {
        closeBrowser();
    }

    @AfterMethod(alwaysRun = true)
    /**purpose of the method is to clear possible browser initializations*/
    public void finishTestCase(ITestResult testResult) {
        closeBrowser();
    }

    public void closeBrowser() {
        log.debug("closeBrowser");
        wdManager.quiteDriver();
    }
}
