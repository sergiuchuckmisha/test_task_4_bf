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
 * https://exonum.com/demo/voting/#/elections/encrypted
 * pageObject pattern is implemented
 */
public class EncryptedBallotPage
        implements IPage, INavigateToUrl, ITopMenu, IBottomMenu,
        IDecryptedBallotSubPageName, IGetTextFromFieldWithCertainName {

    @Inject private DecryptedBallotPage decryptedBallotPage;

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

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        decryptedBallotPage.defaultNavigateTo();
        decryptedBallotPage.pressEncryptedBallot();
        return isOnPage();
    }
}
