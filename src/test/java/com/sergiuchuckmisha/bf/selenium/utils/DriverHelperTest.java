package com.sergiuchuckmisha.bf.selenium.utils;

import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 7:08 PM
 * purpose of the class is to contain simple smoke web UI basicNavigation which calls factory for Chrome browser, opens google
 */
public class DriverHelperTest extends SeleniumBaseTest {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DriverHelperTest.class);

	@Ignore
	@Test
	public void navigateToCertainUrlTest()
	{
		DriverHelper.navigateToCertainUrl("http://google.com");
		DriverHelper.waitUntilPageIsLoaded();
		log.info("Page Title: " + DriverHelper.getTitle());
		org.testng.Assert.assertTrue(DriverHelper.isElementPresent(By.name("q")));
	}
}
