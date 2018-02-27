package com.sergiuchuckmisha.bf.e2e;

import com.google.inject.Inject;
import com.guerrillamail.www.EmailChecker;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.config.Config;
import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import com.sergiuchuckmisha.bf.pages.voting.SignConfirmationPopUpPage;
import com.sergiuchuckmisha.bf.pages.voting.SignedBallotPage;
import com.sergiuchuckmisha.bf.pages.voting.SubmittedBallotPage;
import com.sergiuchuckmisha.bf.pages.voting.UnsignedBallotPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * purpose of the class is to contain scenarios which go after vote: decrypt and sign
 * */
public class EmailWaitTest extends SeleniumBaseTest {
    @Inject private UnsignedBallotPage unsignedBallotPage;
    @Inject private SignConfirmationPopUpPage signConfirmationPopUpPage;
    @Inject private SignedBallotPage signedBallotPage;
    @Inject private SubmittedBallotPage submittedBallotPage;

    /**
     *  * purpose of the method is to check following scenario:
     * 1. vote for smb
     * 2. sign ballot
     * 3. wait for email with same CryptoDetails
     * */
    @Test
    public void signBallotAndWaitForEmail() throws Exception {

        assertTrue(unsignedBallotPage.defaultNavigateTo());

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

        log.info("waiting for cryptoDetails: " + String.valueOf(cryptoDetailsOnUnsignedPage));
        emailChecker.waitForCertainCryptoDetails(cryptoDetailsOnUnsignedPage, Config.HOW_MANY_MINUTES_TO_WAIT_FOR_EMAIL);
    }
}
