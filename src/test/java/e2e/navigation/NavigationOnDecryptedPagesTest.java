package e2e.navigation;

import actions.voting.*;
import base.SeleniumBaseTest;
import dataModels.CryptoDetails;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static config.Config.emailToReceiveCryptoDetails;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios with navigation between decrypted pages: TallyingAuthoritiesAggregatePublicKeyPage and so on
 */
public class NavigationOnDecryptedPagesTest extends SeleniumBaseTest {

	private static Logger log = Logger.getLogger(NavigationOnDecryptedPagesTest.class.toString());

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
	private static final TallyingAuthoritiesAggregatePublicKeyActions tallyingAuthoritiesAggregatePublicKeyActions = new TallyingAuthoritiesAggregatePublicKeyActions();
	private static final CandidateOptionSelectedAndEncryptionRandomnessActions candidateOptionSelectedAndEncryptionRandomnessActions = new CandidateOptionSelectedAndEncryptionRandomnessActions();
	private static final EncryptedBallotActions encryptedBallotActions = new EncryptedBallotActions();
	private static final BallotSHA256HashActions ballotSHA256HashActions = new BallotSHA256HashActions();
	private static final ThreeWordMemoByBIPMnemonicCodeAlgorithmActions threeWordMemoByBIPMnemonicCodeAlgorithmActions = new ThreeWordMemoByBIPMnemonicCodeAlgorithmActions();

	/**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
	@Before
	public void decryptedBallotPagePrecondition() {
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

		unsignedBallotActions.decryptButtonClick();
		assertTrue(decryptConfirmationPopUpActions.isOnPage());

		decryptConfirmationPopUpActions.pressDecryptBallotConfirmationPopUpButton();
		assertTrue(decryptedBallotActions.isOnPage());
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
		assertTrue(decryptedBallotActions.isOnPage());

		//navigate to TallyingAuthoritiesAggregatePublicKeyPage and come back
		decryptedBallotActions.pressTallyingAuthoritiesAggregatePublicKey();
		assertTrue(tallyingAuthoritiesAggregatePublicKeyActions.isOnPage());

		tallyingAuthoritiesAggregatePublicKeyActions.pressTopMenuBackArrow();
		assertTrue(decryptedBallotActions.isOnPage());

		//navigate to CandidateOptionSelectedAndEncryptionRandomnessPage and come back
		decryptedBallotActions.pressCandidateOptionSelectedAndEncryptionRandomness();
		assertTrue(candidateOptionSelectedAndEncryptionRandomnessActions.isOnPage());

		candidateOptionSelectedAndEncryptionRandomnessActions.pressTopMenuBackArrow();
		assertTrue(decryptedBallotActions.isOnPage());

		//navigate to EncryptedBallotPage and come back
		decryptedBallotActions.pressEncryptedBallot();
		assertTrue(encryptedBallotActions.isOnPage());

		encryptedBallotActions.pressTopMenuBackArrow();
		assertTrue(decryptedBallotActions.isOnPage());

		//navigate to BallotSHA256HashPage and come back
		decryptedBallotActions.pressBallotSHA256Hash();
		assertTrue(ballotSHA256HashActions.isOnPage());

		ballotSHA256HashActions.pressTopMenuBackArrow();
		assertTrue(decryptedBallotActions.isOnPage());

		//navigate to ThreeWordMemoByBIPMnemonicCodeAlgorithmPage and come back
		decryptedBallotActions.press3WordMemoByBIPMnemonicCodeAlgorithm();
		assertTrue(threeWordMemoByBIPMnemonicCodeAlgorithmActions.isOnPage());

		threeWordMemoByBIPMnemonicCodeAlgorithmActions.pressTopMenuBackArrow();
		assertTrue(decryptedBallotActions.isOnPage());
	}
}
