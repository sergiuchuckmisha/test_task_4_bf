package e2e;

import actions.voting.*;
import base.SeleniumBaseTest;
import dataModels.CryptoDetails;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static config.Config.emailToReceiveCryptoDetails;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 */
public class AfterVoteTest extends SeleniumBaseTest {

	private static Logger log = Logger.getLogger(AfterVoteTest.class.toString());

	private static final WelcomeActions welcomeActions = new WelcomeActions();
	private static final ElectionsActions electionsActions = new ElectionsActions();
	private static final CandidatesOfElectionActions candidatesOfElectionActions = new CandidatesOfElectionActions();
	private static final VoteConfirmationPopUpActions voteConfirmationPopUpActions = new VoteConfirmationPopUpActions();
	private static final UnsignedBallotActions unsignedBallotActions = new UnsignedBallotActions();
	private static final DecryptConfirmationPopUpActions decryptConfirmationPopUpActions = new DecryptConfirmationPopUpActions();
	private static final DecryptedBallotActions decryptedBallotActions = new DecryptedBallotActions();
	private static final SignConfirmationPopUpActions signConfirmationPopUpActions = new SignConfirmationPopUpActions();
	private static final SignedBallotActions signedBallotActions = new SignedBallotActions();
	private static final SubmittedBallotActions submittedBallotActions = new SubmittedBallotActions();

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
		assertTrue(decryptedBallotActions.isOnPage());

		//at encryptedBallot page top menu back arrow is absent
		assertFalse(decryptedBallotActions.isTopMenuBackArrowVisible());

		decryptedBallotActions.pressReturnButton();
		assertTrue(welcomeActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press sign and cancel then and get to 'Your Unsigned Ballot' page
	 * */
	@Test
	public void signCancelTest(){
		unsignedBallotActions.signButtonClick();
		assertTrue(signConfirmationPopUpActions.isOnPage());

		signConfirmationPopUpActions.pressSignConfirmationPopUpCancelButton();
		assertTrue(unsignedBallotActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press sign and get to 'Ballot has been signed' page
	 * 4. press discard and move to welcome page
	 * */
	@Test
	public void signConfirmAndDiscardTest(){
		unsignedBallotActions.signButtonClick();
		assertTrue(signConfirmationPopUpActions.isOnPage());

		signConfirmationPopUpActions.pressSignConfirmationPopUpYesButton();
		assertTrue(signedBallotActions.isOnPage());

		signedBallotActions.pressDiscardButton();
		assertTrue(welcomeActions.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press sign and get to 'Ballot has been signed' page
	 * 4. press discard and move to welcome page
	 * 5. verify that 'BALLOT RECEIPT 3-WORD MEMO AND HASH' details are same on different pages
	 * */
	@Test
	public void signConfirmAndSubmitTest() throws Exception {

		CryptoDetails cryptoDetailsOnUnsignedPage = unsignedBallotActions.getCryptoDetails();
		log.info("cryptoDetailsOnUnsignedPage: " + String.valueOf(cryptoDetailsOnUnsignedPage));

		unsignedBallotActions.signButtonClick();
		assertTrue(signConfirmationPopUpActions.isOnPage());

		signConfirmationPopUpActions.pressSignConfirmationPopUpYesButton();
		assertTrue(signedBallotActions.isOnPage());

		signedBallotActions.typeEmail(emailToReceiveCryptoDetails);

		//at signedBallot page top menu back arrow is absent
		assertFalse(signedBallotActions.isTopMenuBackArrowVisible());

		signedBallotActions.pressSubmitButton();
		assertTrue(submittedBallotActions.isOnPage());

		//at submittedBallot page top menu back arrow is absent
		assertFalse(submittedBallotActions.isTopMenuBackArrowVisible());


		assertEquals(submittedBallotActions.getCryptoDetails(), cryptoDetailsOnUnsignedPage);
	}
}
