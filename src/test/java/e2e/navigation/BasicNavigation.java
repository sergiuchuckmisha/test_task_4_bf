package e2e.navigation;

import actions.voting.MonitorActions;
import actions.voting.WelcomeActions;
import actions.voting.iTopMenuActions;
import base.SeleniumBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like search and verify results
 */
public class BasicNavigation extends SeleniumBaseTest {

	private static final WelcomeActions welcomeActions = new WelcomeActions();
	private static final MonitorActions monitorActions = new MonitorActions();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens google.com in browser (HtmlUnit is preferred, but you're free to use any)
	 * 2. fill search field with "qwerty" and press Enter
	 * 3. verify that search results contain string "qwerty"
	 * */
	@Test
	public void test() {
		welcomeActions.navigateTo();
		welcomeActions.pressMonitorElectionProcess();
		assertTrue(monitorActions.isOnPage());

		iTopMenuActions.pressBackArrow();
		assertTrue(welcomeActions.isOnPage());
	}

}
