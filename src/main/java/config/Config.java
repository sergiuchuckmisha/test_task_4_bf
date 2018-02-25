package config;

import selenium.browsers.WebDriverFactory;

import static selenium.browsers.WebDriverFactory.Browser.CHROME;
import static selenium.browsers.WebDriverFactory.Browser.UNKNOWN;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 10:41 AM
 * purpose of the class is to contain global configuration properties of the project
 */
public class Config {
    public static final WebDriverFactory.Browser BROWSER;
    public static final String DRIVER_CHROME_PATH = "C:/dev/programs/drivers/chromedriver.exe";
    public static final String SCREENSHOTS_PATH = "screenshots/";//used in TestListener

    public static final int howManyMinutesToWaitForEmail = 60;//meaning email with CryptoDetails
    public static final String emailToReceiveCryptoDetails = "ahfkvwnf@guerrillamailblock.com";//meaning email to receive confirmations with CryptoDetails


    static {

        // TODO rename browser
        WebDriverFactory.Browser browser = WebDriverFactory.Browser.fromString(getEnvVariable("browser"));
        if (browser == UNKNOWN) {
            browser = CHROME;
        }

        BROWSER = browser;
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
