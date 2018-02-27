package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IDecryptConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot
 * pageObject pattern is implemented
 */
public class DecryptConfirmationPopUpPage implements IDecryptConfirmationPopUp {

    @Inject private UnsignedBallotPage unsignedBallotPage;

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        unsignedBallotPage.defaultNavigateTo();
        unsignedBallotPage.decryptButtonClick();
        return isOnPage();
    }
}
