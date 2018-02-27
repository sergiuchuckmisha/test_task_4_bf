package com.sergiuchuckmisha.bf.e2e;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import com.sergiuchuckmisha.bf.pages.voting.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sergiuchuckmisha.bf.config.Config.EMAIL_TO_RECEIVE_CRYPTO_DETAILS;
import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 */
public class AfterVoteTest extends SeleniumBaseTest {

	@Inject private WelcomePage welcomePage;
	@Inject private UnsignedBallotPage unsignedBallotPage;
	@Inject private DecryptConfirmationPopUpPage decryptConfirmationPopUpPage;
	@Inject private DecryptedBallotPage decryptedBallotPage;
	@Inject private SignConfirmationPopUpPage signConfirmationPopUpPage;
	@Inject private SignedBallotPage signedBallotPage;
	@Inject private SubmittedBallotPage submittedBallotPage;

	/**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
	@BeforeMethod
	public void voteForSmbPrerequisite() {
		assertTrue(unsignedBallotPage.defaultNavigateTo());
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
	 * 5. verify that 'BALLOT RECEIPT 3-WORD MEMO AND HASH' details are same on different com.sergiuchuckmisha.bf.pages
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

		signedBallotPage.typeEmail(EMAIL_TO_RECEIVE_CRYPTO_DETAILS);

		//at signedBallot page top menu back arrow is absent
		assertFalse(signedBallotPage.isTopMenuBackArrowVisible());

		signedBallotPage.pressSubmitButton();
		assertTrue(submittedBallotPage.isOnPage());

		//at submittedBallot page top menu back arrow is absent
		assertFalse(submittedBallotPage.isTopMenuBackArrowVisible());


		assertEquals(submittedBallotPage.getCryptoDetails(), cryptoDetailsOnUnsignedPage);
	}
}
