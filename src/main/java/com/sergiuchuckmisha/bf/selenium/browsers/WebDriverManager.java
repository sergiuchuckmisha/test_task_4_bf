package com.sergiuchuckmisha.bf.selenium.browsers;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

//todo use dependency injection and decide which method is static and which is not
public class WebDriverManager {

    private final static ThreadLocal<WebDriver> WD_CONTAINER = new ThreadLocal<>();

//    private static WebDriverFactory webDriverFactory = new WebDriverFactory();

    private static WebDriverFactory webDriverFactory;

    @Inject
    public WebDriverManager(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

//    public WebDriverManager() {
//        this(new WebDriverFactory());
//    }

    /**
     * @return current driver or null if driver closed/not launched
     */
    public  WebDriver getActiveDriver() {
        if (WD_CONTAINER.get() == null) {
           return null;
        }
        return WD_CONTAINER.get();
    }
    public  WebDriver getDriver() {
        if (WD_CONTAINER.get() == null) {
            WebDriver driver = webDriverFactory.getDriver();
            WD_CONTAINER.set(driver);
        }
        return WD_CONTAINER.get();
    }

    public  void quiteDriver() {
        WebDriver driver = WD_CONTAINER.get();
        if (driver == null) {
            // todo: log "Driver already quite"
        } else {
            driver.quit();
            WD_CONTAINER.set(null);
        }
    }

}
