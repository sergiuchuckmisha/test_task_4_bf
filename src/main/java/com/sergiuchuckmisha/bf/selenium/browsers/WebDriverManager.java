package com.sergiuchuckmisha.bf.selenium.browsers;

import org.openqa.selenium.WebDriver;

//todo use dependency injection and decide which method is static and which is not
public class WebDriverManager {

    private final static ThreadLocal<WebDriver> WD_CONTAINER = new ThreadLocal<>();
    private static WebDriverFactory webDriverFactory = new WebDriverFactory();

    public WebDriverManager(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public WebDriverManager() {
        this(new WebDriverFactory());
    }

    public static WebDriver getDriver() {
        if (WD_CONTAINER.get() == null) {
            WebDriver driver = webDriverFactory.getDriver();
            WD_CONTAINER.set(driver);
        }
        return WD_CONTAINER.get();
    }

    public static void quiteDriver() {
        WebDriver driver = WD_CONTAINER.get();
        if (driver == null) {
            // todo: log "Driver already quite"
        } else {
            driver.quit();
            WD_CONTAINER.set(null);
        }
    }

}
