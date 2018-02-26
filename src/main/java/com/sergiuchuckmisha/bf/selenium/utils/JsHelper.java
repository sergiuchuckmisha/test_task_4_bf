package com.sergiuchuckmisha.bf.selenium.utils;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 2:08 PM
 * purpose of the class is to accumulate methods which works with WebDriver page via JavaScript
 * this class has dependency only on WebDriverManager to fet instance of WebDriver
 */
public class JsHelper {

    private static WebDriverManager wdManager;

    @Inject
    public JsHelper(WebDriverManager wdManager) {
        this.wdManager = wdManager;
    }

    private static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) wdManager.getDriver();
    }

    public static boolean isAjaxComplete() {
        try {
            return (Boolean) getJsExecutor().executeScript("return $.active == 0");
        } catch (Exception ignore) {
            return true;
        }
    }

    public static void navigate(String url) {
        getJsExecutor().executeScript(String.format("window.location.href = '%s'", url));
    }

    public static Boolean isPageLoaded() {
        try {
            return ("complete").equals(getJsExecutor().executeScript("return document.readyState"));
        } catch (WebDriverException ignore) {
            return true;
        }
    }

    public static void click(WebElement element) {
        try {
            getJsExecutor().executeScript("arguments[0].click();", element);
        } catch (WebDriverException ignore) {
            getJsExecutor().executeScript("arguments[0].click();", element);
        }
    }
}
