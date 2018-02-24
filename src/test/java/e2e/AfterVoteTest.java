package e2e;

import base.SeleniumBaseTest;
import dataModels.CryptoDetails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.voting.*;

import java.util.logging.Logger;

import static config.Config.emailToReceiveCryptoDetails;
import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 */
public class AfterVoteTest extends SeleniumBaseTest {

	private static final Logger log = Logger.getLogger(AfterVoteTest.class.toString());

	private static final WelcomePage welcomePage = new WelcomePage();
	private static final ElectionsPage electionsPage = new ElectionsPage();
	private static final CandidatesOfElectionPage candidatesOfElectionPage = new CandidatesOfElectionPage();
	private static final VoteConfirmationPopUpPage voteConfirmationPopUpPage = new VoteConfirmationPopUpPage();
	private static final UnsignedBallotPage unsignedBallotPage = new UnsignedBallotPage();
	private static final DecryptConfirmationPopUpPage decryptConfirmationPopUpPage = new DecryptConfirmationPopUpPage();
	private static final DecryptedBallotPage decryptedBallotPage = new DecryptedBallotPage();
	private static final SignConfirmationPopUpPage signConfirmationPopUpPage = new SignConfirmationPopUpPage();
	private static final SignedBallotPage signedBallotPage = new SignedBallotPage();
	private static final SubmittedBallotPage submittedBallotPage = new SubmittedBallotPage();

	/**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
	@BeforeMethod
	public void voteForSmbPrerequisite() {
		welcomePage.navigateTo();

		//welcome page check 'VOTE IN ELECTION'
		welcomePage.pressVoteInElectionButton();
		assertTrue(electionsPage.isOnPage());

		//only one option can be selected
		assertEquals(1, electionsPage.howManyOptionsChecked());

		//select voting
		electionsPage.pressVoteInElectionButton();
		assertTrue(candidatesOfElectionPage.isOnPage());

		//vote for smb
		assertEquals(1, candidatesOfElectionPage.howManyOptionsChecked());
		candidatesOfElectionPage.pressVoteInElectionButton();

		assertTrue(voteConfirmationPopUpPage.isOnPage());
		voteConfirmationPopUpPage.pressVoteConfirmationPopUpYesButton();

		assertTrue(unsignedBallotPage.isOnPage());
	}


	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press discard and get to welcome page
	 * */
	@Test
	public void discardTest(){
		unsignedBallotPage.discardButtonClick();
		assertTrue(welcomePage.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and get to 'Full Ballot Encryption Details' page
	 * */
	@Test
	public void decryptTest(){
		unsignedBallotPage.discardButtonClick();
		assertTrue(welcomePage.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and discard then get to 'Unsigned Ballot' page
	 * */
	@Test
	public void decryptDiscardTest(){
		unsignedBallotPage.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpPage.isOnPage());

		decryptConfirmationPopUpPage.pressDecryptConfirmationPopUpCancelButton();
		assertTrue(unsignedBallotPage.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press decrypt and get to 'Full Ballot Encryption Details' page
	 * */
	@Test
	public void decryptConfirmTest(){
		unsignedBallotPage.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpPage.isOnPage());

		decryptConfirmationPopUpPage.pressDecryptBallotConfirmationPopUpButton();
		assertTrue(decryptedBallotPage.isOnPage());

		//at encryptedBallot page top menu back arrow is absent
		assertFalse(decryptedBallotPage.isTopMenuBackArrowVisible());

		decryptedBallotPage.pressReturnButton();
		assertTrue(welcomePage.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. vote for smb
	 * 3. press sign and cancel then and get to 'Your Unsigned Ballot' page
	 * */
	@Test
	public void signCancelTest(){
		unsignedBallotPage.signButtonClick();
		assertTrue(signConfirmationPopUpPage.isOnPage());

		signConfirmationPopUpPage.pressSignConfirmationPopUpCancelButton();
		assertTrue(unsignedBallotPage.isOnPage());
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
		unsignedBallotPage.signButtonClick();
		assertTrue(signConfirmationPopUpPage.isOnPage());

		signConfirmationPopUpPage.enterSomePINCode();
		signConfirmationPopUpPage.pressSignConfirmationPopUpYesButton();
		assertTrue(signedBallotPage.isOnPage());

		signedBallotPage.pressDiscardButton();
		assertTrue(welcomePage.isOnPage());
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

		CryptoDetails cryptoDetailsOnUnsignedPage = unsignedBallotPage.getCryptoDetails();
		log.info("cryptoDetailsOnUnsignedPage: " + String.valueOf(cryptoDetailsOnUnsignedPage));

		unsignedBallotPage.signButtonClick();
		assertTrue(signConfirmationPopUpPage.isOnPage());

		signConfirmationPopUpPage.enterSomePINCode();
		signConfirmationPopUpPage.pressSignConfirmationPopUpYesButton();
		assertTrue(signedBallotPage.isOnPage());

		signedBallotPage.typeEmail(emailToReceiveCryptoDetails);

		//at signedBallot page top menu back arrow is absent
		assertFalse(signedBallotPage.isTopMenuBackArrowVisible());

		signedBallotPage.pressSubmitButton();
		assertTrue(submittedBallotPage.isOnPage());

		//at submittedBallot page top menu back arrow is absent
		assertFalse(submittedBallotPage.isTopMenuBackArrowVisible());


		assertEquals(submittedBallotPage.getCryptoDetails(), cryptoDetailsOnUnsignedPage);
	}
}
