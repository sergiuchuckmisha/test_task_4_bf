package base;

import org.junit.After;
import org.junit.Before;
import selenium.browsers.WebDriverFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 7:29 PM
 * purpose of this class is to contain methods common to all basicNavigation classes. e.g. clear browser before/after each basicNavigation
 */
public abstract class SeleniumBaseTest {
	@Before
	@After
	/**purpose of the method is to clear possible browser initializations*/
	public void closeBrowser()
	{
		WebDriverFactory.clearDriver();
	}
}
