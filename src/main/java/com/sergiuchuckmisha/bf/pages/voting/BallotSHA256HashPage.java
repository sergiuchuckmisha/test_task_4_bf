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
 * https://exonum.com/demo/voting/#/elections/hash
 * pageObject pattern is implemented
 */
public class BallotSHA256HashPage
        implements IPage, INavigateToUrl, ITopMenu, IBottomMenu,
        IDecryptedBallotSubPageName, IGetTextFromFieldWithCertainName {

    @Inject private DecryptedBallotPage decryptedBallotPage;

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

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        decryptedBallotPage.defaultNavigateTo();
        decryptedBallotPage.pressBallotSHA256Hash();
        return isOnPage();
    }
}
