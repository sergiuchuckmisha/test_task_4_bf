package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/memo
 * pageObject pattern is implemented
 */
public class ThreeWordMemoByBIPMnemonicCodeAlgorithmPage implements iPage, iNavigateTo, iTopMenu, iBottomMenu, iDecryptedBallotSubPageName, iGetTextFromFieldWithCertainName {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/memo";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent() && "3-word memo BIP 0039 Mnemonic algorithm".equals(getDecryptedBallotSubPageName());
    }

    @Override
    public String getTopMenuName() {
        return "Full Ballot Encryption Details";
    }

    public String getMnemonicCodePlaintext(){
        return getDecryptedBallotSubPageName("Mnemonic code plaintext");
    }
}
