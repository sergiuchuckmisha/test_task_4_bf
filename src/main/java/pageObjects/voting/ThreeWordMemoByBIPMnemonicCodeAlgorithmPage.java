package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iDecryptedBallotSubPageName;
import pageObjects.voting.pageElements.iTopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/memo
 * pageObject pattern is implemented
 */
public class ThreeWordMemoByBIPMnemonicCodeAlgorithmPage implements iPage, iTopMenu, iBottomMenu, iDecryptedBallotSubPageName {

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
}
