package selenium.browsers;

import base.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 6:40 PM
 * purpose of the class is to contain unit tests for WebDriverFactory class
 */
public class WebDriverFactoryTest  extends SeleniumBaseTest {

	@Test
	public void testEnumBrowsers()
	{
		try {
			assert WebDriverFactory.Browser.CHROME.equals(WebDriverFactory.Browser.fromString("CH"));
			assert WebDriverFactory.Browser.HTML_UNIT.equals(WebDriverFactory.Browser.fromString("HU"));
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
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

			org.testng.Assert.assertNotNull(WebDriverManager.getDriver());
			WebDriverManager.getDriver().get("http://www.google.com");
			org.testng.Assert.assertNotNull(WebDriverManager.getDriver().findElement(By.name("q")));

//		} catch ( NoSuchMethodException | IllegalAccessException |InvocationTargetException e) {  //this is for Java7
    } catch (Exception e) {                                                                   //this is for Java6
			e.printStackTrace();
		}
	}
}


