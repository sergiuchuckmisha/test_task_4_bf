package com.sergiuchuckmisha.bf.e2e.navigation;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.pages.voting.*;
import org.testng.annotations.Test;

import static com.sergiuchuckmisha.bf.dataModels.ValidationUtils.is01;
import static com.sergiuchuckmisha.bf.dataModels.ValidationUtils.isHexadecimal;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain scenarios with navigation between decrypted com.sergiuchuckmisha.bf.pages: TallyingAuthoritiesAggregatePublicKeyPage and so on
 */
public class DecryptedPagesTest extends SeleniumBaseTest {

	@Inject private DecryptedBallotPage decryptedBallotPage;
	@Inject private TallyingAuthoritiesAggregatePublicKeyPage tallyingAuthoritiesAggregatePublicKeyPage;
	@Inject private CandidateOptionSelectedAndEncryptionRandomnessPage candidateOptionSelectedAndEncryptionRandomnessPage;
	@Inject private EncryptedBallotPage encryptedBallotPage;
	@Inject private BallotSHA256HashPage ballotSHA256HashPage;
	@Inject private ThreeWordMemoByBIPMnemonicCodeAlgorithmPage threeWordMemoByBIPMnemonicCodeAlgorithmPage;



	/**idea of test is to visit each DecryptedBallotSubPage*/
	@Test
	public void navigationOnDecryptedBallotSubPagesTest(){
		// TODO: 2/27/2018 use dataProvider
	}

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. vote for smb and get decrypted Ballot
	 * 2. navigate to TallyingAuthoritiesAggregatePublicKeyPage
	 * 2.1. verify ModulusHexadecimal and PublicExponent and come back
	 * 3. navigate to CandidateOptionSelectedAndEncryptionRandomnessPage and come back
	 * 4. navigate to EncryptedBallotPage
	 * 4.1. verify EncryptedBallotHexadecimal and come back
	 * 5. navigate to BallotSHA256HashPage
	 * 5.1. verify HashHexadecimal and HashPrefixHexadecimal and come back
	 * 6. navigate to ThreeWordMemoByBIPMnemonicCodeAlgorithmPage and come back
	 * */
	@Test
	public void validationOnDecryptedBallotSubPagesTest(){
		assertTrue(decryptedBallotPage.defaultNavigateTo());

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
