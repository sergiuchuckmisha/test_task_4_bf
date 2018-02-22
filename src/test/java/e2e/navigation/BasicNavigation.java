package e2e.navigation;

import actions.voting.ElectionsActions;
import actions.voting.MonitorActions;
import actions.voting.WelcomeActions;
import base.SeleniumBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */
public class BasicNavigation extends SeleniumBaseTest {

	private static final WelcomeActions welcomeActions = new WelcomeActions();
	private static final MonitorActions monitorActions = new MonitorActions();
	private static final ElectionsActions electionsActions = new ElectionsActions();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate over pages, check buttons and top and bottom menus
	 * */
	@Test
	public void basicNavigation() {
		welcomeActions.navigateTo();

		//welcome page check 'Monitor election process'
		welcomeActions.pressMonitorElectionProcess();
		assertTrue(monitorActions.isOnPage());

		// top menu check back arrow
		monitorActions.pressTopMenuBackArrow();
		assertTrue(welcomeActions.isOnPage());

		//welcome page check 'VOTE IN ELECTION'
		welcomeActions.pressVoteInElectionButton();
		assertTrue(electionsActions.isOnPage());

		//check bottom menu 'Monitor'
		electionsActions.pressBottomMenuMonitor();
		assertTrue(monitorActions.isOnPage());

		//check bottom menu 'Elections'
		monitorActions.pressBottomMenuElections();
		assertTrue(electionsActions.isOnPage());
	}


}
