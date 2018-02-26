package com.sergiuchuckmisha.bf.selenium.utils;

import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 12:46 PM
 * this class wraps calls to WebDriver instance in order to add checks, try-catch etc to common WebDriver functions
 */
public class DriverHelper {

    //    static WebDriverManager wdManager = new WebDriverManager(new WebDriverFactory());
    @Inject
    static WebDriverManager wdManager;

    //    static JsHelper jsHelper = new JsHelper(wdManager);
    @Inject
    static JsHelper jsHelper;

    private static final Logger log = Logger.getLogger(DriverHelper.class);
//        public static final int defaultPageLoadWaitTimeoutSeconds = 60; //wait up to this time for element to appear or page to be loaded
    @com.google.inject.Inject(optional = true)
    @Named("defaultPageLoadWaitTimeoutSeconds")
//    @Getter
    private static Integer defaultPageLoadWaitTimeoutSeconds = 60;

    @com.google.inject.Inject(optional = true)
    @Named("defaultTimeoutSeconds")
    private static Integer defaultTimeoutSeconds = 20; //wait up to this time for element to appear or page to be loaded

    @com.google.inject.Inject(optional = true)
    @Named("defaultImplicitlyWaitTimeoutSeconds")
    private static Integer defaultImplicitlyWaitTimeoutSeconds = 5; //wait up to this time for element to appear or page to be loaded

    @com.google.inject.Inject(optional = true)
    @Named("defaultJsAsyncWaitTimeoutMilliseconds")
    private static Integer defaultJsAsyncWaitTimeoutMilliseconds = 1; //wait up to this time for element to appear or page to be loaded

    public static Integer getDefaultPageLoadWaitTimeoutSeconds() {
        return defaultPageLoadWaitTimeoutSeconds;
    }

    /**
     * Gets text from element
     *
     * @param locator target element locator
     * @return String text or null if element is absent
     */
    public static String getText(By locator) {
        if (!isElementPresent(locator))
            return null;

        return findElement(locator).getText();
    }

    public static String getTitle() {
        waitUntilPageIsLoaded();
        return wdManager.getDriver().getTitle();
    }

    public static boolean isElementPresent(By locator) {
        waitUntilPageIsLoaded();
        wdManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = !wdManager.getDriver().findElements(locator).isEmpty();
        wdManager.getDriver().manage().timeouts().implicitlyWait(defaultTimeoutSeconds, TimeUnit.SECONDS);
        return result;
    }

    public static void navigateToCertainUrl(String url) {
        try {
            wdManager.getDriver().get(url);
        } catch (Exception e) {
            log.info(e);
            wdManager.quiteDriver();
        }
    }

    public static void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        waitUntilExpectedCondition(webDriver -> (Boolean) ((JavascriptExecutor) webDriver).executeScript(angularReadyScript));
    }

    public static void wait4jQuery() {
        String angularReadyScript = "return jQuery.active==0";
        waitUntilExpectedCondition(webDriver -> (Boolean) ((JavascriptExecutor) webDriver).executeScript(angularReadyScript));
    }

    public static void waitForJsAsync() {
        wdManager.getDriver().manage().timeouts().setScriptTimeout(defaultTimeoutSeconds, TimeUnit.SECONDS);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) wdManager.getDriver();

        try {
            jsExecutor.executeAsyncScript(String.format("window.setTimeout(arguments[arguments.length - 1], %d);",
                    defaultJsAsyncWaitTimeoutMilliseconds));
        } catch (Exception e) {
            log.info(e);
        }
    }

    public static void waitUntilExpectedCondition(ExpectedCondition<Boolean> condition, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(wdManager.getDriver(), timeOutInSeconds);

//		waitUntilExpectedCondition(driver -> JsHelper.isPageLoaded());

        try {
            wait.until(condition);
        } catch (Exception ignored) {
        }

//		try {
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver driver) {
//					return JsHelper.isPageLoaded();
//				}
//			});
//		} catch (Exception ignored) {
//		}
    }

    public static void waitUntilExpectedCondition(ExpectedCondition<Boolean> condition) {
        waitUntilExpectedCondition(condition, defaultTimeoutSeconds);
    }

    public static void waitUntilPageIsLoaded() {
        wdManager.getDriver().manage().timeouts().pageLoadTimeout(defaultTimeoutSeconds, TimeUnit.SECONDS);
        wdManager.getDriver().manage().timeouts().implicitlyWait(defaultImplicitlyWaitTimeoutSeconds, TimeUnit.SECONDS);


        WebDriverWait wait = new WebDriverWait(wdManager.getDriver(), defaultTimeoutSeconds);

        try {
            wait.until(driver -> JsHelper.isPageLoaded());//return document.readyState == complete
        } catch (Exception ignored) {
        }

        wait4jQuery();
        waitForAngularLoad();
        waitForJsAsync();
    }

    public static List<WebElement> findElements(By locator) {
        waitUntilPageIsLoaded();
        return wdManager.getDriver().findElements(locator);
    }

    public static WebElement findElement(By locator) {
        return findElement(locator, defaultTimeoutSeconds);
    }

    public static WebElement findElement(By locator, int newTimeOutSeconds) {
        log.warn("Find element: " + locator);
        WebElement webElement = null;

        try {
            webElement = new WebDriverWait(wdManager.getDriver(), newTimeOutSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
            log.warn("Find element: " + locator + " => true");
        } catch (Exception ex) {
            log.warn("Web element not found: " + locator);
        }
        return webElement;
    }

    /**
     * purpose of the method is to enrich standard click with try/catch and possible click with JavaScript
     */
    public static void click(By locator) {
        waitUntilPageIsLoaded();
        WebElement element = findElement(locator);
        try {
            element.click();
        } catch (Exception ex) {
            jsHelper.click(element);
        }
        waitUntilPageIsLoaded();
    }


    public static void type(By locator, String str) {
        waitUntilPageIsLoaded();
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(str);
    }

    /**
     * idea is to replace condition like
     * div[@class='bottom-menu-item-title']
     * with
     * div[contains(concat(' ', @class, ' '), ' bottom-menu-item-title ']
     */
    public static String wrapClassContainsForPath(String classPart) {
        return String.format(" contains(concat(' ', @class, ' '), concat(' ', '%s', ' ')) ", classPart);
    }
}
