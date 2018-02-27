package com.sergiuchuckmisha.bf.selenium.browsers;

import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 6:40 PM
 * purpose of the class is to contain unit tests for WebDriverFactory class
 */
public class WebDriverFactoryTest  extends SeleniumBaseTest {

	@Inject
	private WebDriverManager wdManager;


	@Test
	public void testEnumBrowsers()
	{
		try {
			assert WebDriverFactory.Browser.CHROME.equals(WebDriverFactory.Browser.fromString("CH"));
			assert WebDriverFactory.Browser.HTML_UNIT.equals(WebDriverFactory.Browser.fromString("HU"));
		} catch (Exception e) {
			log.info(e);
		}
	}

	/**purpose of the basicNavigation is to start HU driver, open google and check for presence of a search field*/
	@Ignore
	@Test
	public void testHtmlUnitCreation()
	{
		try {
			Method method = WebDriverFactory.class.getDeclaredMethod("getDriver", WebDriverFactory.Browser.class);
			method.setAccessible(true);
			method.invoke(null, WebDriverFactory.Browser.HTML_UNIT);

			org.testng.Assert.assertNotNull(wdManager.getDriver());
			wdManager.getDriver().get("http://www.google.com");
			org.testng.Assert.assertNotNull(wdManager.getDriver().findElement(By.name("q")));

		} catch ( NoSuchMethodException | IllegalAccessException |InvocationTargetException e) {  //this is for Java7
			log.info(e);
		}
	}
}


