package com.sergiuchuckmisha.bf.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 7:29 PM
 * purpose of this class is to contain methods common to all basicNavigation classes. e.g. clear browser before/after each basicNavigation
 */
public abstract class SeleniumBaseTest {
//	@BeforeSuite
//	@AfterSuite
//	@BeforeTest
//	@AfterTest
	@BeforeMethod
	@AfterMethod
	/**purpose of the method is to clear possible browser initializations*/
	public void closeBrowser()
	{
		WebDriverManager.quiteDriver();
	}
}
