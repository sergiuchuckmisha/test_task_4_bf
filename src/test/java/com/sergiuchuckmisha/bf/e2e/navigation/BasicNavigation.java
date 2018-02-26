package com.sergiuchuckmisha.bf.e2e.navigation;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.pages.voting.ElectionsPage;
import com.sergiuchuckmisha.bf.pages.voting.MonitorPage;
import com.sergiuchuckmisha.bf.pages.voting.WelcomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */

public class BasicNavigation extends SeleniumBaseTest {

	@Inject private WelcomePage welcomePage;
	@Inject private MonitorPage monitorPage;
	@Inject private ElectionsPage electionsPage;

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate over com.sergiuchuckmisha.bf.pages, check buttons and top and bottom menus
	 * */
	@Test()
	public void basicNavigation() {
		welcomePage.navigateTo();

		//welcome page check 'Monitor election process'
		welcomePage.pressMonitorElectionProcess();
		assertTrue(monitorPage.isOnPage());

		// top menu check back arrow
		monitorPage.pressTopMenuBackArrow();
		assertTrue(welcomePage.isOnPage());

		//welcome page check 'VOTE IN ELECTION'
		welcomePage.pressVoteInElectionButton();
		assertTrue(electionsPage.isOnPage());

		//check bottom menu 'Monitor'
		electionsPage.pressBottomMenuMonitor();
		assertTrue(monitorPage.isOnPage());

		//check bottom menu 'Elections'
		monitorPage.pressBottomMenuElections();
		assertTrue(electionsPage.isOnPage());
	}


}
