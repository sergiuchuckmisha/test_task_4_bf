package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/randomness
 * pageObject pattern is implemented
 */
public class CandidateOptionSelectedAndEncryptionRandomnessPage implements iPage, NavigateTo, iTopMenu, iBottomMenu, iDecryptedBallotSubPageName, iGetTextFromFieldWithCertainName {

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
}
