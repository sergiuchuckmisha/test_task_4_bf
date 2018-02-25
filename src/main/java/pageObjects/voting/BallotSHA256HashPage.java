package pageObjects.voting;

import pageObjects.IPage;
import pageObjects.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/hash
 * pageObject pattern is implemented
 */
public class BallotSHA256HashPage implements IPage, INavigateTo, ITopMenu, IBottomMenu, IDecryptedBallotSubPageName, IGetTextFromFieldWithCertainName {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/hash";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent() && "Ballot SHA-256 hash".equals(getDecryptedBallotSubPageName());
    }

    @Override
    public String getTopMenuName() {
        return "Full Ballot Encryption Details";
    }

    public String getHashHexadecimal(){
        return getDecryptedBallotSubPageName("Hash hexadecimal");
    }

    public String getHashPrefixHexadecimal(){
        return getDecryptedBallotSubPageName("Hash prefix hexadecimal");
    }
}
