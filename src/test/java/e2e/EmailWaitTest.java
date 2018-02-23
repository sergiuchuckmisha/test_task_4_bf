package e2e;

import actions.voting.*;
import com.guerrillamail.www.EmailChecker;
import config.Config;
import dataModels.CryptoDetails;
import org.junit.Before;
import org.junit.Test;
import selenium.browsers.WebDriverFactory;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 * */
public class EmailWaitTest {

    private static final Logger log = Logger.getLogger(AfterVoteTest.class.toString());

    private static final WelcomeActions welcomeActions = new WelcomeActions();
    private static final ElectionsActions electionsActions = new ElectionsActions();
    private static final CandidatesOfElectionActions candidatesOfElectionActions = new CandidatesOfElectionActions();
    private static final VoteConfirmationPopUpActions voteConfirmationPopUpActions = new VoteConfirmationPopUpActions();
    private static final UnsignedBallotActions unsignedBallotActions = new UnsignedBallotActions();
    private static final SignConfirmationPopUpActions signConfirmationPopUpActions = new SignConfirmationPopUpActions();
    private static final SignedBallotActions signedBallotActions = new SignedBallotActions();
    private static final SubmittedBallotActions submittedBallotActions = new SubmittedBallotActions();

    /**prerequisite for another tests in this class: get to 'Your Unsigned Ballot' page*/
    @Before
    public void voteForSmbPrerequisite() {
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
     * 1. vote for smb
     * 2. sign ballot
     * 3. wait for email with same CryptoDetails
     * */
    @Test
    public void signBallotAndWaitForEmail() throws Exception {

        EmailChecker emailChecker = new EmailChecker();
        log.info("current email: " + emailChecker.getCurrentEmail());

        CryptoDetails cryptoDetailsOnUnsignedPage = unsignedBallotActions.getCryptoDetails();

        unsignedBallotActions.signButtonClick();
        assertTrue(signConfirmationPopUpActions.isOnPage());

        signConfirmationPopUpActions.enterSomePINCode();
        signConfirmationPopUpActions.pressSignConfirmationPopUpYesButton();
        assertTrue(signedBallotActions.isOnPage());

        signedBallotActions.typeEmail(emailChecker.getCurrentEmail());

        signedBallotActions.pressSubmitButton();
        assertTrue(submittedBallotActions.isOnPage());


        assertEquals(submittedBallotActions.getCryptoDetails(), cryptoDetailsOnUnsignedPage);

        //no need to keep page while waiting for email
        WebDriverFactory.clearDriver();

        emailChecker.waitForCertainCryptoDetails(cryptoDetailsOnUnsignedPage, Config.howManyMinutesToWaitForEmail);
    }
}
