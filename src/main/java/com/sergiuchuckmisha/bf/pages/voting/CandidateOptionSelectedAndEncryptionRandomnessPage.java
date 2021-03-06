package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/randomness
 * pageObject pattern is implemented
 */
public class CandidateOptionSelectedAndEncryptionRandomnessPage
        implements IPage, INavigateToUrl, ITopMenu, IBottomMenu,
        IDecryptedBallotSubPageName, IGetTextFromFieldWithCertainName {

    @Inject private DecryptedBallotPage decryptedBallotPage;

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/randomness";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent()
                && !getDecryptedBallotSubPageName().isEmpty()  //these ugly conditions are required because of strange symbol '\u0003' in the name of subpage
                && getDecryptedBallotSubPageName().startsWith("Candidate option selected")
                && getDecryptedBallotSubPageName().endsWith("and encryption randomness")
                ;
    }

    @Override
    public String getTopMenuName() {
        return "Full Ballot Encryption Details";
    }

    public String getPlaintextCandidateAndRandomness(){
        return getDecryptedBallotSubPageName("Plaintext candidate + randomness");
    }

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        decryptedBallotPage.defaultNavigateTo();
        decryptedBallotPage.pressCandidateOptionSelectedAndEncryptionRandomness();
        return isOnPage();
    }
}
