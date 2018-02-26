package com.sergiuchuckmisha.bf.e2e.navigation;

import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.pages.voting.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.sergiuchuckmisha.bf.dataModels.ValidationUtils.is01;
import static com.sergiuchuckmisha.bf.dataModels.ValidationUtils.isHexadecimal;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios with navigation between decrypted com.sergiuchuckmisha.bf.pages: TallyingAuthoritiesAggregatePublicKeyPage and so on
 */
public class NavigationOnDecryptedPagesTest extends SeleniumBaseTest {

	private static final Logger log = Logger.getLogger(NavigationOnDecryptedPagesTest.class.toString());

	private static final WelcomePage welcomePage = new WelcomePage();
	private static final ElectionsPage electionsPage = new ElectionsPage();
	private static final CandidatesOfElectionPage candidatesOfElectionPage = new CandidatesOfElectionPage();
	private static final VoteConfirmationPopUpPage voteConfirmationPopUpPage = new VoteConfirmationPopUpPage();
	private static final UnsignedBallotPage unsignedBallotPage = new UnsignedBallotPage();
	private static final DecryptConfirmationPopUpPage decryptConfirmationPopUpPage = new DecryptConfirmationPopUpPage();
	private static final DecryptedBallotPage decryptedBallotPage = new DecryptedBallotPage();
	private static final TallyingAuthoritiesAggregatePublicKeyPage tallyingAuthoritiesAggregatePublicKeyPage = new TallyingAuthoritiesAggregatePublicKeyPage();
	private static final CandidateOptionSelectedAndEncryptionRandomnessPage candidateOptionSelectedAndEncryptionRandomnessPage = new CandidateOptionSelectedAndEncryptionRandomnessPage();
	private static final EncryptedBallotPage encryptedBallotPage = new EncryptedBallotPage();
	private static final BallotSHA256HashPage ballotSHA256HashPage = new BallotSHA256HashPage();
	private static final ThreeWordMemoByBIPMnemonicCodeAlgorithmPage threeWordMemoByBIPMnemonicCodeAlgorithmPage = new ThreeWordMemoByBIPMnemonicCodeAlgorithmPage();

	/**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
	@BeforeMethod
	public void decryptedBallotPagePrecondition() {
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

		unsignedBallotPage.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpPage.isOnPage());

		decryptConfirmationPopUpPage.pressDecryptBallotConfirmationPopUpButton();
		assertTrue(decryptedBallotPage.isOnPage());
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. vote for smb and get decrypted Ballot
	 * 2. navigate to TallyingAuthoritiesAggregatePublicKeyPage and come back
	 * 3. navigate to CandidateOptionSelectedAndEncryptionRandomnessPage and come back
	 * 4. navigate to EncryptedBallotPage and come back
	 * 5. navigate to BallotSHA256HashPage and come back
	 * 6. navigate to ThreeWordMemoByBIPMnemonicCodeAlgorithmPage and come back
	 * */
	@Test
	public void navigationOnDecryptedBallotSubPagesTest(){
		assertTrue(decryptedBallotPage.isOnPage());

		//navigate to TallyingAuthoritiesAggregatePublicKeyPage and come back
		decryptedBallotPage.pressTallyingAuthoritiesAggregatePublicKey();
		assertTrue(tallyingAuthoritiesAggregatePublicKeyPage.isOnPage());

		//print info from TallyingAuthoritiesAggregatePublicKeyPage
		String modulusHexadecimal = tallyingAuthoritiesAggregatePublicKeyPage.getModulusHexadecimal();
		log.info("ModulusHexadecimal: " + modulusHexadecimal);
		assertTrue(isHexadecimal(modulusHexadecimal));
		assertTrue(256 == modulusHexadecimal.length());
		String publicExponent = tallyingAuthoritiesAggregatePublicKeyPage.getPublicExponent();
		log.info("PublicExponent: " + publicExponent);
		assertTrue(is01(publicExponent));//todo is it correct check?

		tallyingAuthoritiesAggregatePublicKeyPage.pressTopMenuBackArrow();
		assertTrue(decryptedBallotPage.isOnPage());

		//navigate to CandidateOptionSelectedAndEncryptionRandomnessPage and come back
		decryptedBallotPage.pressCandidateOptionSelectedAndEncryptionRandomness();
		assertTrue(candidateOptionSelectedAndEncryptionRandomnessPage.isOnPage());

		//print info from CandidateOptionSelectedAndEncryptionRandomnessPage
		log.info("PlaintextCandidateAndRandomness: " + candidateOptionSelectedAndEncryptionRandomnessPage.getPlaintextCandidateAndRandomness());

		candidateOptionSelectedAndEncryptionRandomnessPage.pressTopMenuBackArrow();
		assertTrue(decryptedBallotPage.isOnPage());

		//navigate to EncryptedBallotPage and come back
		decryptedBallotPage.pressEncryptedBallot();
		assertTrue(encryptedBallotPage.isOnPage());

		//print info from EncryptedBallotPage
		String encryptedBallotHexadecimal = encryptedBallotPage.getEncryptedBallotHexadecimal();
		log.info("EncryptedBallotHexadecimal: " + encryptedBallotHexadecimal);
		assertTrue(isHexadecimal(encryptedBallotHexadecimal));
		assertTrue(256 == encryptedBallotHexadecimal.length());

		encryptedBallotPage.pressTopMenuBackArrow();
		assertTrue(decryptedBallotPage.isOnPage());

		//navigate to BallotSHA256HashPage and come back
		decryptedBallotPage.pressBallotSHA256Hash();
		assertTrue(ballotSHA256HashPage.isOnPage());

		//print info from BallotSHA256HashPage
		String hashHexadecimal = ballotSHA256HashPage.getHashHexadecimal();
		String hashPrefixHexadecimal = ballotSHA256HashPage.getHashPrefixHexadecimal();
		log.info("HashHexadecimal: " + hashHexadecimal);
		assertTrue(isHexadecimal(hashHexadecimal));
		assertTrue(64 == hashHexadecimal.length());
		log.info("HashPrefixHexadecimal: " + hashPrefixHexadecimal);
		assertTrue(isHexadecimal(hashPrefixHexadecimal));
		assertTrue(8 == hashPrefixHexadecimal.length());

		ballotSHA256HashPage.pressTopMenuBackArrow();
		assertTrue(decryptedBallotPage.isOnPage());

		//navigate to ThreeWordMemoByBIPMnemonicCodeAlgorithmPage and come back
		decryptedBallotPage.press3WordMemoByBIPMnemonicCodeAlgorithm();
		assertTrue(threeWordMemoByBIPMnemonicCodeAlgorithmPage.isOnPage());

		//print info from ThreeWordMemoByBIPMnemonicCodeAlgorithmPage
		log.info("MnemonicCodePlaintext: " + threeWordMemoByBIPMnemonicCodeAlgorithmPage.getMnemonicCodePlaintext());

		threeWordMemoByBIPMnemonicCodeAlgorithmPage.pressTopMenuBackArrow();
		assertTrue(decryptedBallotPage.isOnPage());
	}
}
