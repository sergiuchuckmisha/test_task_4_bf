package config;

import org.apache.commons.lang3.StringUtils;
import selenium.browsers.WebDriverFactory;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 10:41 AM
 * purpose of the class is to contain global configuration properties of the project
 */
public class Config {
	public static WebDriverFactory.browsers BROWSER;
	public static final String DRIVER_CHROME_PATH;

	public static final int howManyMinutesToWaitForEmail = 60;//meaning email with CryptoDetails
	public static final String emailToReceiveCryptoDetails = "ahfkvwnf@guerrillamailblock.com";//meaning email to receive confirmations with CryptoDetails

	static {

		DRIVER_CHROME_PATH = "C:\\dev\\programs\\drivers\\chromedriver.exe";

		try {
			if(StringUtils.isEmpty(getEnvVariable("browser")))//todo refactoring seems to be required because 2 checks (try/catch and if) are intersected
			{BROWSER = WebDriverFactory.browsers.getBrowserByLabel("CH");}
			else
			{BROWSER = WebDriverFactory.browsers.getBrowserByLabel(getEnvVariable("browser"));}
		} catch (Exception e) {
			e.printStackTrace();
			BROWSER = WebDriverFactory.browsers.Chrome;//Chrome is a default browser
		}
	}

	/**purpose of the method is to catch certain property from environment variables with local or Jenkins use*/
	public static final String getEnvVariable(String variable) {
		String property = System.getProperty(variable);  // use to run on Jenkins
		if (property == null)
			property = System.getenv(variable);   // use to run local
		if (property == null) {
			property = "";
		}
		return property;
	}
}
