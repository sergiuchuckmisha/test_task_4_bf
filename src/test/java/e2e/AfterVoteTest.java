package e2e;

import actions.voting.*;
import base.SeleniumBaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 */
public class AfterVoteTest extends SeleniumBaseTest {

	private static final WelcomeActions welcomeActions = new WelcomeActions();
	private static final ElectionsActions electionsActions = new ElectionsActions();
	private static final CandidatesOfElectionActions candidatesOfElectionActions = new CandidatesOfElectionActions();
	private static final VoteConfirmationPopUpActions voteConfirmationPopUpActions = new VoteConfirmationPopUpActions();
	private static final UnsignedBallotActions unsignedBallotActions = new UnsignedBallotActions();
	private static final DecryptConfirmationPopUpActions decryptConfirmationPopUpActions = new DecryptConfirmationPopUpActions();
	private static final EncryptedBallotActions encryptedBallotActions = new EncryptedBallotActions();

	/**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
	@Before
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
		voteConfirmationPopUpActions.pressVoteConfirmationPopUpYesButton();

		assertTrue(unsignedBallotActions.isOnPage());
	}


	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press discard and get to welcome page
	 * */
	@Test
	public void discardTest(){
		unsignedBallotActions.discardButtonClick();
		assertTrue(welcomeActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and get to 'Full Ballot Encryption Details' page
	 * */
	@Test
	public void decryptTest(){
		unsignedBallotActions.discardButtonClick();
		assertTrue(welcomeActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and discard then get to 'Unsigned Ballot' page
	 * */
	@Test
	public void decryptDiscardTest(){
		unsignedBallotActions.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpActions.isOnPage());

		decryptConfirmationPopUpActions.pressDecryptConfirmationPopUpCancelButton();
		assertTrue(unsignedBallotActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and get to 'Full Ballot Encryption Details' page
	 * */
	@Test
	public void decryptConfirmTest(){
		unsignedBallotActions.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpActions.isOnPage());

		decryptConfirmationPopUpActions.pressDecryptBallotConfirmationPopUpButton();
		assertTrue(encryptedBallotActions.isOnPage());

		encryptedBallotActions.pressReturnButton();
		assertTrue(welcomeActions.isOnPage());
	}
}
