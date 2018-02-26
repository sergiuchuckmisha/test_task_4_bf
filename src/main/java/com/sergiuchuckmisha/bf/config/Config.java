package com.sergiuchuckmisha.bf.config;

import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverFactory;

import javax.inject.Named;

import static com.sergiuchuckmisha.bf.selenium.browsers.WebDriverFactory.Browser.CHROME;
import static com.sergiuchuckmisha.bf.selenium.browsers.WebDriverFactory.Browser.UNKNOWN;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 10:41 AM
 * purpose of the class is to contain global configuration properties of the project
 */
public class Config {
    public static final WebDriverFactory.Browser BROWSER;

    @com.google.inject.Inject(optional = true)
    @Named("DRIVER_CHROME_PATH")
    public static String DRIVER_CHROME_PATH = "C:/dev/programs/drivers/chromedriver.exe";

    @com.google.inject.Inject(optional = true)
    @Named("SCREENSHOTS_PATH")
    public static String SCREENSHOTS_PATH = "screenshots/";//used in TestListener


    public static final int HOW_MANY_MINUTES_TO_WAIT_FOR_EMAIL = 60;//meaning email with CryptoDetails
    public static final String EMAIL_TO_RECEIVE_CRYPTO_DETAILS = "ahfkvwnf@guerrillamailblock.com";//meaning email to receive confirmations with CryptoDetails


    static {

        WebDriverFactory.Browser browserTemporaryVariable = WebDriverFactory.Browser.fromString(getEnvVariable("browser"));
        if (browserTemporaryVariable == UNKNOWN) {
            browserTemporaryVariable = CHROME;
        }

        BROWSER = browserTemporaryVariable;
    }

    /**
     * purpose of the method is to catch certain property from environment variables with local or Jenkins use
     *
     * @return // todo add description
     */
    private static String getEnvVariable(String variable) {
        String property = System.getProperty(variable);  // use to run on Jenkins
        if (property == null)
            property = System.getenv(variable);   // use to run local
        if (property == null) {
            property = "";
        }
        return property;
    }
}
