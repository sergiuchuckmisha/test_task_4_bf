package com.sergiuchuckmisha.bf.e2e;

import com.google.inject.Inject;
import com.guerrillamail.www.EmailChecker;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import com.sergiuchuckmisha.bf.pages.voting.*;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 * */
public class EmailWaitTest extends SeleniumBaseTest {



    private static final Logger log = Logger.getLogger(AfterVoteTest.class.toString());

    @Inject private WelcomePage welcomePage;
    @Inject private ElectionsPage electionsPage;
    @Inject private CandidatesOfElectionPage candidatesOfElectionPage;
    @Inject private VoteConfirmationPopUpPage voteConfirmationPopUpPage;
    @Inject private UnsignedBallotPage unsignedBallotPage;
    @Inject private SignConfirmationPopUpPage signConfirmationPopUpPage;
    @Inject private SignedBallotPage signedBallotPage;
    @Inject private SubmittedBallotPage submittedBallotPage;

    /**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
//    @BeforeMethod
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
     * 1. vote for smb
     * 2. sign ballot
     * 3. wait for email with same CryptoDetails
     * */
    @Test
    public void signBallotAndWaitForEmail() throws Exception {

        voteForSmbPrerequisite();

        assertTrue(unsignedBallotPage.isOnPage());

        EmailChecker emailChecker = new EmailChecker();
        log.info("current email: " + emailChecker.getCurrentEmail());

        CryptoDetails cryptoDetailsOnUnsignedPage = unsignedBallotPage.getCryptoDetails();

        unsignedBallotPage.signButtonClick();
        assertTrue(signConfirmationPopUpPage.isOnPage());

        signConfirmationPopUpPage.enterSomePINCode();
        signConfirmationPopUpPage.pressSignConfirmationPopUpYesButton();
        assertTrue(signedBallotPage.isOnPage());

        signedBallotPage.typeEmail(emailChecker.getCurrentEmail());

        signedBallotPage.pressSubmitButton();
        assertTrue(submittedBallotPage.isOnPage());


        assertEquals(submittedBallotPage.getCryptoDetails(), cryptoDetailsOnUnsignedPage);

        //no need to keep page while waiting for email
        closeBrowser();

//        emailChecker.waitForCertainCryptoDetails(cryptoDetailsOnUnsignedPage, Config.HOW_MANY_MINUTES_TO_WAIT_FOR_EMAIL);
    }
}
