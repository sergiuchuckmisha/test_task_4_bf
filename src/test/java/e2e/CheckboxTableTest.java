package e2e;

import actions.voting.CandidatesOfElectionActions;
import actions.voting.ElectionsActions;
import actions.voting.WelcomeActions;
import base.SeleniumBaseTest;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */
public class CheckboxTableTest extends SeleniumBaseTest {

	private static Logger log = Logger.getLogger(CheckboxTableTest.class.toString());

	private static final WelcomeActions welcomeActions = new WelcomeActions();
//	private static final MonitorActions monitorActions = new MonitorActions();//is not used because monitor page is unfinished
	private static final ElectionsActions electionsActions = new ElectionsActions();
	private static final CandidatesOfElectionActions candidatesOfElectionActions = new CandidatesOfElectionActions();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate to page e-Voting (https://exonum.com/demo/voting/#/elections)
	 * 2.1 and then to 'Candidates of Election' pages
	 * 3. verify that only one option can be selected and that one option is selected
	 * */
	@Test
	public void checkboxTablesTest() {
		welcomeActions.navigateTo();

		//welcome page check 'VOTE IN ELECTION'
		welcomeActions.pressVoteInElectionButton();
		assertTrue(electionsActions.isOnPage());

		//only one option can be selected
		assertEquals(1, electionsActions.howManyOptionsChecked());

		for(String value: electionsActions.getCheckBoxTableValues()){
			electionsActions.selectCheckBoxTableValue(value);

			assertEquals(1, electionsActions.howManyOptionsChecked());

			//same check for 'Candidates of Election' pages
			electionsActions.pressVoteInElectionButton();
			assertTrue(candidatesOfElectionActions.isOnPage());
			for(String value2: candidatesOfElectionActions.getCheckBoxTableValues()) {
				candidatesOfElectionActions.selectCheckBoxTableValue(value2);

				assertEquals(1, candidatesOfElectionActions.howManyOptionsChecked());
			}
			candidatesOfElectionActions.pressTopMenuBackArrow();
			assertTrue(electionsActions.isOnPage());
		}

	}

}
