package pageObjects.voting;

import pageObjects.IPage;
import pageObjects.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/encrypted
 * pageObject pattern is implemented
 */
public class EncryptedBallotPage implements IPage, INavigateTo, ITopMenu, IBottomMenu, IDecryptedBallotSubPageName, IGetTextFromFieldWithCertainName {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/encrypted";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent() && "Encrypted ballot".equals(getDecryptedBallotSubPageName());
    }

    @Override
    public String getTopMenuName() {
        return "Full Ballot Encryption Details";
    }

    public String getEncryptedBallotHexadecimal(){
        return getDecryptedBallotSubPageName("Encrypted ballot hexadecimal");
    }
}
