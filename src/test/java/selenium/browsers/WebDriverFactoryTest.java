package selenium.browsers;

import base.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static selenium.browsers.WebDriverFactory.browsers;


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
			assert browsers.Chrome.equals(browsers.getBrowserByLabel("CH"));
			assert browsers.HtmlUnit.equals(browsers.getBrowserByLabel("HU"));
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	/**purpose of the basicNavigation is to start HU driver, open google and check for presence of a search field*/
	@Test
	public void testHtmlUnitCreation()
	{
		try {
			Method method = WebDriverFactory.class.getDeclaredMethod("getDriver", browsers.class);
			method.setAccessible(true);
			method.invoke(null, browsers.HtmlUnit);

			org.testng.Assert.assertNotNull(WebDriverFactory.getDriver());
			WebDriverFactory.getDriver().get("http://www.google.com");
			org.testng.Assert.assertNotNull(WebDriverFactory.getDriver().findElement(By.name("q")));

//		} catch ( NoSuchMethodException | IllegalAccessException |InvocationTargetException e) {  //this is for Java7
    } catch (Exception e) {                                                                   //this is for Java6
			e.printStackTrace();
		}
	}
}


