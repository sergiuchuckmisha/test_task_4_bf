package e2e;

import actions.voting.*;
import base.SeleniumBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */
public class VoteTest extends SeleniumBaseTest {

	private static final WelcomeActions welcomeActions = new WelcomeActions();
	private static final ElectionsActions electionsActions = new ElectionsActions();
	private static final CandidatesOfElectionActions candidatesOfElectionActions = new CandidatesOfElectionActions();
	private static final VoteConfirmationPopUpActions voteConfirmationPopUpActions = new VoteConfirmationPopUpActions();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate to page e-Voting (https://exonum.com/demo/voting/#/elections)
	 * 2.1 and then to 'Candidates of Election' pages
	 * 3. verify that only one option can be selected and that one option is selected
	 * */
	@Test
	public void voteForSmbTest() {
		welcomeActions.navigateTo();

		//welcome page check 'VOTE IN ELECTION'
		welcomeActions.pressVoteInElectionButton();
		assertTrue(electionsActions.isOnPage());

		//only one option can be selected
		assertEquals(1, electionsActions.howManyOptionsChecked());

		//select voting
		electionsActions.pressVoteInElectionButton();
		assertTrue(candidatesOfElectionActions.isOnPage());

		//vote for smb
		assertEquals(1, candidatesOfElectionActions.howManyOptionsChecked());
		candidatesOfElectionActions.pressVoteInElectionButton();

		assertTrue(voteConfirmationPopUpActions.isOnPage());

		voteConfirmationPopUpActions.pressVoteConfirmationPopUpCancelButton();
		assertTrue(candidatesOfElectionActions.isOnPage());

		//vote for smb
		assertEquals(1, candidatesOfElectionActions.howManyOptionsChecked());
		candidatesOfElectionActions.pressVoteInElectionButton();

		assertTrue(voteConfirmationPopUpActions.isOnPage());
		voteConfirmationPopUpActions.pressVoteConfirmationPopUpYesButton();
	}

}
