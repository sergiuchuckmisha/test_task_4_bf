package com.sergiuchuckmisha.bf.selenium.browsers;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private  final Logger log = Logger.getLogger(getClass());

    private static final ThreadLocal<WebDriver> WD_CONTAINER = new ThreadLocal<>();

    private static WebDriverFactory webDriverFactory;

    @Inject
    public WebDriverManager(WebDriverFactory webDriverFactory) {
        WebDriverManager.webDriverFactory = webDriverFactory;
    }

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
            log.info("Driver already quite");
        } else {
            driver.quit();
            WD_CONTAINER.set(null);
        }
    }

}
