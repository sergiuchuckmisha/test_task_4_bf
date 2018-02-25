package e2e;

import com.guerrillamail.www.EmailChecker;
import dataModels.CryptoDetails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.voting.*;
import selenium.browsers.WebDriverManager;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 * */
public class EmailWaitTest {

    private static final Logger log = Logger.getLogger(AfterVoteTest.class.toString());

    private static final WelcomePage welcomePage = new WelcomePage();
    private static final ElectionsPage electionsPage = new ElectionsPage();
    private static final CandidatesOfElectionPage candidatesOfElectionPage = new CandidatesOfElectionPage();
    private static final VoteConfirmationPopUpPage voteConfirmationPopUpPage = new VoteConfirmationPopUpPage();
    private static final UnsignedBallotPage unsignedBallotPage = new UnsignedBallotPage();
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
     * 1. vote for smb
     * 2. sign ballot
     * 3. wait for email with same CryptoDetails
     * */
    @Test
    public void signBallotAndWaitForEmail() throws Exception {

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
        WebDriverManager.quiteDriver();

//        emailChecker.waitForCertainCryptoDetails(cryptoDetailsOnUnsignedPage, Config.howManyMinutesToWaitForEmail);
    }
}
