package com.sergiuchuckmisha.bf.selenium.browsers;

import com.sergiuchuckmisha.bf.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nullable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sergiuchuckmisha.bf.config.Config.DRIVER_CHROME_PATH;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 11:23 AM
 * pattern Factory
 * purpose of the class is to generate com.sergiuchuckmisha.bf.selenium browsers objects
 * currently only one instance of WebDriver is supported
 * type of this single WebDriver is defined in Config file or in enviroment variable "browser"
 * currently the only public method  getDriver() should be used
 * todo: support multiple WebDriver instances
 */
public class WebDriverFactory {

    private static final Logger LOG = Logger.getLogger(WebDriverFactory.class.toString());

    private static DesiredCapabilities capabilities;

    private static void setCommonCapabilities() {
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ACCEPT");
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    }

    /**
     * purpose of this enum is to enlist browsers which can be used in the project
     * WebDriverFactory will take member of this enum as parameter
     * String label of browser should be converted to enum instance asap using method fromString()
     */
    public enum Browser {
        UNKNOWN(""),
        HTML_UNIT("HU"),
        CHROME("CH");

        public final String label;


        Browser(String label) {
            this.label = label;
        }

        public static Browser fromString(@Nullable String label) {
            for (Browser browser : Browser.values()) {
                if (browser.label.equals(label))
                    return browser;
            }
            return UNKNOWN;
        }
    }

    public WebDriver getDriver() {
        return getDriver(Config.BROWSER);
    }

    //	/**for public purposes method without parameters (which takes browser type from environment variable) should be used*/
    private  WebDriver getDriver(Browser browser) {
        LOG.log(Level.CONFIG, "Requested driver: " + browser);
        return newWebDriver(browser);

    }

    private static WebDriver newWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return newChromeDriver();
            case HTML_UNIT:
                return newHtmlUnitDiver();
            default:
                throw new IllegalArgumentException(browser.label);
        }
    }

    private static WebDriver newChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_CHROME_PATH);

        return new ChromeDriver();
    }

    private static WebDriver newHtmlUnitDiver() {
//		capabilities = new DesiredCapabilities().htmlUnitWithJs();
        capabilities = new DesiredCapabilities().htmlUnit();
        capabilities.setBrowserName("HtmlUnit");
        setCommonCapabilities();

//		return new HtmlUnitDriver(capabilities);
        return new HtmlUnitDriver(true);
    }



}
